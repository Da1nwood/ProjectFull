package Pars;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 class Connect_To_Data {
     static void mysql_connection(Crypto_info crypto_info) throws Exception {
         MySQLConnector mySQLConnector = new MySQLConnector();
         try {
             try (Connection connection = mySQLConnector.getConnection()) {
                 {
                     String name_coin = crypto_info.getName().toLowerCase();
                     String price = crypto_info.getPrice();
                     String TimeAdd = crypto_info.getTimestamp();
                     System.out.println(price);
                     String query = "INSERT INTO crypto." + name_coin + "(price, TimeAdd) VALUES (?,?)";
                     PreparedStatement stmt = connection.prepareStatement(query);
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


             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
         catch (Exception e){
             e.printStackTrace();
         }
     }
 }