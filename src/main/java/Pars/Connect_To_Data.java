package Pars;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 class Connect_To_Data {
    private static final String UserName = "root";
    private static final String password = "1111";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/crypto?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";

     static void mysql_connection(Crypto_info crypto_info) throws Exception {
         Class.forName("com.mysql.cj.jdbc.Driver");
         try (Connection connection_to_data = DriverManager.getConnection(connectionUrl, UserName, password)) {
             try {
                 {
                     String name_coin = crypto_info.getName().toLowerCase();
                     String price = crypto_info.getPrice();
                     String TimeAdd = crypto_info.getTimestamp();
                     String query = "INSERT INTO crypto." + name_coin + "(price, TimeAdd) VALUES (?,?)";
                     PreparedStatement stmt = connection_to_data.prepareStatement(query);
                     stmt.setString(1, price);
                     stmt.setString(2, TimeAdd);
                     stmt.executeUpdate();
                 }


             } catch (java.sql.SQLSyntaxErrorException e) {
                 FatalityExceptions.SqlTableNotFound();
             } catch (SQLException e) {
                 if (e.getErrorCode() == 0) {
                     FatalityExceptions.SqlConnectingProblems();
                 }
                 if (e.getErrorCode() == 1045) {
                     FatalityExceptions.WrongNameOrPassword();
                 }

             }
             finally {
                 connection_to_data.close();
         }
         }
     }
     static void set_info(JsonObject jsonObject,String name_coin) throws Exception {
        long timestamp = System.currentTimeMillis() / 1000;
        JsonElement usd_crypto = jsonObject.get("USD");
            if (usd_crypto != null) {
                mysql_connection(new Crypto_info(name_coin,String.valueOf(usd_crypto),String.valueOf(timestamp)));
                System.out.println(usd_crypto);
            }
            else FatalityExceptions.ErrorOfRightUrl();
    }
}