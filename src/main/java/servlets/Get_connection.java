package servlets;
import Pars.Properties;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

//Select * From crypto.btc WHERE" + id + "<" + "SELECT MAX(`id`) FROM crypto.btc
public class Get_connection extends Thread{
    private static final String UserName = Properties.getProperty("UserName");
    private static final String password = Properties.getProperty("password");
    private static final String connectionUrl = Properties.getProperty("connectionUrl");
    private String name_coin;
    private int port_name;

    public Get_connection(String name_coin, int port_name) {
        this.name_coin = name_coin;
        this.port_name = port_name;

    }

    public void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            int max_id = 1;
            int last_id = 1;
            try (Connection connection = DriverManager.getConnection(connectionUrl, UserName, password)) {
                Socket socket = null;
                ServerSocket s = new ServerSocket(port_name);
                try {
                    socket = s.accept();
                    while (true) {
                        try {
                            String query = " SELECT COUNT(*) from crypto." + name_coin;
                            Statement stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next()) {
                                max_id = Integer.valueOf(rs.getString("COUNT(*)"));
                            }
                            String answer = "SELECT * from crypto." +name_coin+ " where "  + "id<" + max_id + " AND " + last_id + "<=id";
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(answer);
                            BufferedReader in = new BufferedReader(new InputStreamReader(
                                    socket.getInputStream()));
                            PrintWriter out = new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())), true);
                            String string;
                            while (resultSet.next()) {
                                string = resultSet.getString("price");
                                out.println(string);
                            }
                            System.out.println(max_id + " " + last_id);
                            last_id = max_id;
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    socket.close();
                    s.close();
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}