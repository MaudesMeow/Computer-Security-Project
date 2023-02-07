package Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import Project.LoginBean;
import Project.MD5;

public class LoginDao {
	static final String URL = "jdbc:mysql://Wayne.cs.uwec.edu:3306/CS370G1";
    static final String DATABASE_NAME = "CS370G1";
    static final String DATABASE_PASSWORD = "FINALproject";

    public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        String mySqlUsername = "", mySqlPassword= "", mySqlRole= "", mySqlId= "", mySqlAddress= "", mySqlPhoneNumber= "", mySqlGpa= "", mySqlStudentCredit = "", mySqlAccountBalance = "";
        

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from user_login where user_name = ? and user_password = ?")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, MD5.getMd5(loginBean.getPassword()));

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            if(status) {
            
            	mySqlId = rs.getString(1);
            	mySqlUsername = rs.getString(2);
            	mySqlRole = rs.getString(4);
            }
            
            loginBean.setId(mySqlId);
            loginBean.setRole(mySqlRole);

            
            

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        try (Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from user_authentication where BlugoldID = ?")) {
                preparedStatement.setString(1, loginBean.getID());

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                status = rs.next();
                if(status) {
                
                	mySqlId = rs.getString(1);
                	mySqlAddress = rs.getString(2);
                	mySqlPhoneNumber = rs.getString(3);
                	mySqlGpa = rs.getString(4);
                	mySqlStudentCredit = rs.getString(5);
                	mySqlAccountBalance = rs.getString(6);
                }

                loginBean.setAddress(mySqlAddress);
                loginBean.setPhonenum(mySqlPhoneNumber);
                loginBean.setGpa(mySqlGpa);
                loginBean.setAccountBalance(mySqlAccountBalance);
                loginBean.setStudentCredits(mySqlStudentCredit);
                
                

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        
        
        return status;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}