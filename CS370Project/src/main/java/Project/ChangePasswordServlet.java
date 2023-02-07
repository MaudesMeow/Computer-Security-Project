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

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static final String URL = "jdbc:mysql://Wayne.cs.uwec.edu:3306/CS370G1";
    static final String DATABASE_NAME = "CS370G1";
    static final String DATABASE_PASSWORD = "FINALproject";
    
   
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

    	HttpSession session = request.getSession();
        String password = request.getParameter("password");
        String hash = MD5.getMd5(password);
        
        String newpassword1 = request.getParameter("newpassword1");
        String newpassword2 = request.getParameter("newpassword2");
        String newhash = MD5.getMd5(newpassword1);
        
        try {
			if(verifyPassword(hash, session) && newpassword1.equals(newpassword2)) {
				try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);
						

		                PreparedStatement preparedStatement = connection
		                .prepareStatement("UPDATE user_login SET user_password = ? WHERE blugold_id = ?")) {
		                preparedStatement.setString(1, newhash);
		                preparedStatement.setString(2, (String) session.getAttribute("id"));
		                
		                preparedStatement.executeUpdate();
		                
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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     

        
    }
    
    public boolean verifyPassword(String hash, HttpSession session) throws ClassNotFoundException {
    	boolean status = false;
    	try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);

                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from user_login where user_name = ? and user_password = ?")) {
                preparedStatement.setString(1, (String) session.getAttribute("username"));
                preparedStatement.setString(2, hash);
                
                ResultSet rs = preparedStatement.executeQuery();
                status = rs.next();

            } catch (SQLException e) {
                // process sql exception
    			e.printStackTrace();
            }
            return status;
        }
}