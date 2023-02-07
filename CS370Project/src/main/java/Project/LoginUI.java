package Project;
//package FinalProject;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class LoginUI extends JFrame implements ActionListener {

	public String userName;
	public String password;
	
	//database credentials
	
	static final String URL = "jdbc:mysql://Wayne:3306/cs370g1";
    static final String DATABASE_NAME = "CS370G1";
    static final String DATABASE_PASSWORD = "FINALproject";
			
			
	JPanel panel;
	JLabel userLabel, passwordLabel, message;
	JTextField userNameText;
	JPasswordField passwordText;
	JButton submit, cancel;
	
	
	LoginUI() {
	      //username 
	      userLabel = new JLabel();
	      userLabel.setText("User Name :");
	      userNameText = new JTextField();
	      // Password Label
	      passwordLabel = new JLabel();
	      passwordLabel.setText("Password :");
	      passwordText = new JPasswordField();
	      // Submit
	      submit = new JButton("SUBMIT");
	      panel = new JPanel(new GridLayout(3, 1));
	      panel.add(userLabel);
	      panel.add(userNameText);
	      panel.add(passwordLabel);
	      panel.add(passwordText);
	      message = new JLabel();
	      panel.add(message);
	      panel.add(submit);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      // Adding the listeners to components..
	      submit.addActionListener(this);
	      add(panel, BorderLayout.CENTER);
	      setTitle("Please Login Here !");
	      setSize(450,350);
	      setVisible(true);
	   }
	   
	   
	   
	   @Override
	   public void actionPerformed(ActionEvent ae) {
	      userName = userNameText.getText();
	      String userPassword = passwordText.getText();
	      String mySqlUsername = null;
	      String mySqlPassword = null;
	      String mySqlRole = null;
	      String mySqlId = null;
	      String mySqlAddress = null;
	      String mySqlPhoneNumber = null;
	      String mySqlGpa = null;
	      try{
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  Connection connection = DriverManager.getConnection(URL,DATABASE_NAME,DATABASE_PASSWORD);
	      
	    	  Statement statement = connection.createStatement();
	      
	    	  
	    	  
	    	  ResultSet resultSet = statement.executeQuery("select*from User_Authentication where Name = '"+userName+"'and Password = '"+userPassword+"'");
	    	  while (resultSet.next()) {
	    		  mySqlUsername = resultSet.getString(1);
	    		  mySqlPassword = resultSet.getString(2);
	    		  mySqlRole = resultSet.getString(3);
	    		  mySqlId = resultSet.getString(4);
	    		  mySqlAddress = resultSet.getString(5)  ;
	    		  mySqlPhoneNumber = resultSet.getString(6);
	    		  mySqlGpa = resultSet.getString(7);
	    		  //System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
	    	  }
	    	  connection.close();
	      }
	      catch (Exception e){
	    	System.out.println(e);  
	      }
	      

	      if (userName.equals(mySqlUsername)&& userPassword.equals(mySqlPassword) && mySqlRole.equals("Student")) {
	         message.setText(" Hello " + userName + " you are a student" );
	        // StudentPage studentPage = new StudentPage(mySqlUsername, mySqlPassword, mySqlRole, mySqlId,mySqlAddress, mySqlPhoneNumber,mySqlGpa );
	         dispose();
	      } else if(userName.equals(mySqlUsername)&& userPassword.equals(mySqlPassword) && mySqlRole.equals("Faculty")) {
	    	 // FacultyPage facultyPage = new FacultyPage();
	    	  dispose();
	      }
	    	  else {
	         message.setText(" Invalid user.. ");
	      }
	   }
	   
	   
	}
