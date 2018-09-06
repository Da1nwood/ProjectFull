package servlets;


import Pars.Properties;
import Pars.WhereSet;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

//Select * From crypto.btc WHERE" + id + "<" + "SELECT MAX(`id`) FROM crypto.btc
public class Get_connection {
    private static final String UserName = Properties.getProperty("UserName");
    private static final String password = Properties.getProperty("password");
    private static final String connectionUrl = Properties.getProperty("connectionUrl");
    public static int max_id = 1;
    public static int last_id = 1;

    public static void get_con() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, UserName, password)) {
            Socket socket = null;
            ServerSocket s = null;
            try {
                s = new ServerSocket(1488);
                socket = s.accept();
                while (socket.isConnected()) {
                    try {
                        String query = " SELECT COUNT(*) from crypto.btc";
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            max_id = Integer.valueOf(rs.getString("COUNT(*)"));
                        }
                        String answer = "SELECT * from crypto.btc where " + "id<" + max_id + " AND " + last_id + "<=id";
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
                        if(!socket.isConnected()) {
                            socket.close();
                            break;
                        }
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
}