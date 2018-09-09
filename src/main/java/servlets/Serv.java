package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(value = "/StartServlet" , asyncSupported = true)
public class Serv extends HttpServlet{
public ArrayList price = new ArrayList();
public ArrayList TimeAdd = new ArrayList();
private static final String UserName = "root";
private static final String password = "1111";
private static final String connectionUrl = "jdbc:mysql://localhost:3306/crypto?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl, UserName, password);
            String query = "SELECT * FROM crypto.btc";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price.add(rs.getString("price"));
                TimeAdd.add(rs.getString("TimeAdd"));
            }
            }
        catch(Exception e){
            e.printStackTrace();
        }

        request.setAttribute("price", price);
        request.setAttribute("TimeAdd", TimeAdd);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Etherium.jsp");
        dispatcher.forward(request,response);
    }
}



