package students.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Kubish on 14.03.15.
 */
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Connect dtabase
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        int a = 5;
        // Create Mysql connect
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            pw.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        }


        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/testtable", "root", "toor");

        } catch (SQLException e) {
            pw.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            pw.println("Database is work!");

        } else {
            pw.println("Connection Failed! to male connection");
        }


        // Create Table
        pw.println("<br />");
        pw.println("<table border=1 align=center width=200>");
        pw.println("<caption>My first table</caption>");

        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM USERS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int columns = 0;
        try {
            columns = rs.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {           // output data
            while (rs.next()) {
                for (int i = 1; i <= columns; ++i) {
                    pw.println("<tr>");
                    pw.println("<td>" + rs.getString(i) + "</td>");
                    pw.println("</tr>");
                }
                System.out.println("");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pw.println("</table>");


    }
}
