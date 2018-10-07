package servlets;

import Pars.Properties;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Socket_threads extends Thread{
    private static final String UserName = Properties.getProperty("UserName");
    private static final String password = Properties.getProperty("password");
    private static final String connectionUrl = Properties.getProperty("connectionUrl");
    private String name_coin;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    public Socket_threads(Socket socket, String name_coin) throws IOException {
        this.socket = socket;
        this.name_coin = name_coin;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();

    }

    @Override
    public void run() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            int max_id = 1;
            int last_id = 1;
            try (Connection connection = DriverManager.getConnection(connectionUrl, UserName, password)) {
                try {
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
                                Thread.sleep(2);
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
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
