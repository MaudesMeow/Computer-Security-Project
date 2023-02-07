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

import Project.MD5;

/**
 * @email Ramesh Fadatare                             ***Change????***
 */

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final String URL = "jdbc:mysql://Wayne.cs.uwec.edu:3306/CS370G1";
    static final String DATABASE_NAME = "CS370G1";
    static final String DATABASE_PASSWORD = "FINALproject";
    
   
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

    	HttpSession session = request.getSession();
        String gpa = request.getParameter("gpa");
        String name = request.getParameter("name");
        String role = "Student";
        String address = request.getParameter("address");
        String phoneNum = request.getParameter("phonenum");
        String password = request.getParameter("password");
        String ID = request.getParameter("ID");
        String studentCredit = request.getParameter("studentCredit");
        String accountBalance = request.getParameter("accountBalance");
        
        String hash = MD5.getMd5(password);
        
    	try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);
			PreparedStatement preparedStatement = connection
		    .prepareStatement("INSERT INTO User_Authentication (BlugoldID, Address, PhoneNumber, GPA, StudentCredits, AccountBalance) VALUES (? ,? , ?, ?, ?, ?);")) {
		    preparedStatement.setString(1, ID);
		    preparedStatement.setString(2, address);
		    preparedStatement.setString(3, phoneNum);
		    preparedStatement.setString(4, gpa);
		    preparedStatement.setString(5, studentCredit);
		    preparedStatement.setString(6, accountBalance);
		    
		                
		    preparedStatement.executeUpdate();
		                
		    

    	} catch (SQLException e) {
    		// process sql exception
    		e.printStackTrace();
    	}
    	
    	try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);
    			PreparedStatement preparedStatement = connection
    		    .prepareStatement("INSERT INTO user_login (blugold_id, user_name, user_password, user_role) VALUES (?, ?, ?, ?);")) {
    		    preparedStatement.setString(1, ID);
    		    preparedStatement.setString(2, name);
    		    preparedStatement.setString(3, hash);
    		    preparedStatement.setString(4, role);
    		    
    		                
    		    preparedStatement.executeUpdate();
    		                
    		    

        	} catch (SQLException e) {
        		// process sql exception
        		e.printStackTrace();
        	}
    	
    	
    	
    	String userrole = (String) session.getAttribute("role");
	    if(userrole.equals("Student")) {
	    	response.sendRedirect("student.jsp");
	    }
	    else if(userrole.equals("Faculty")) {
	    	response.sendRedirect("faculty.jsp");
	    }
    	
    }	
}