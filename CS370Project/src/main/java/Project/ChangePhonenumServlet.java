package Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * @email Ramesh Fadatare                             ***Change????***
 */

@WebServlet("/changephonenum")
public class ChangePhonenumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final String URL = "jdbc:mysql://Wayne.cs.uwec.edu:3306/CS370G1";
    static final String DATABASE_NAME = "CS370G1";
    static final String DATABASE_PASSWORD = "FINALproject";
    
   
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

    	HttpSession session = request.getSession();
        String phonenum = request.getParameter("phonenum");
    	try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);
			PreparedStatement preparedStatement = connection
		    .prepareStatement("UPDATE User_Authentication SET PhoneNumber = ? WHERE BlugoldID = ?")) {
		    preparedStatement.setString(1, phonenum);
		    preparedStatement.setString(2, (String) session.getAttribute("id"));
		                
		    preparedStatement.executeUpdate();
		    session.setAttribute("phonenum", phonenum);
		                
		    String role = (String) session.getAttribute("role");
		    if(role.equals("Student")) {
		    	response.sendRedirect("student.jsp");
		    }
		    else if(role.equals("Faculty")) {
		    	response.sendRedirect("faculty.jsp");
		    }

    	} catch (SQLException e) {
    		// process sql exception
    		e.printStackTrace();
    	}
    }	
}