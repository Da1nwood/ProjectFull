package Pars;

import java.sql.*;


public class MySQLConnector {
    private static final String UserName = Properties.getProperty("UserName");
    private static final String password = Properties.getProperty("password");
    private static final String connectionUrl = Properties.getProperty("connectionUrl");
    public MySQLConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl,UserName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}