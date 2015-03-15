package students.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Kubish on 14.03.15.
 */
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<Person> nameLis = new ArrayList<Person>();
        Person per=new Person();

        //Connect dtabase
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/testtable", "root", "toor");

        } catch (SQLException e) {

            e.printStackTrace();

        }

        if (connection != null) {
            //  pw.println("Database is work!");

        } else {
            //    pw.println("Connection Failed! to male connection");
        }
        // case from mysql DB
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
                    per=new Person();
                    per.setPerson(rs.getString(i),1990+i);
                    nameLis.add(per);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("nameLis", nameLis);
        req.setAttribute("nameList", nameList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
