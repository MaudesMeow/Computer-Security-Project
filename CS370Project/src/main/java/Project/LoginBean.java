package Project;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String role;
    private String id;
    private String address;
    private String phonenum;
    private String gpa;
    private String studentCredits;
    private String accountBalance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
    	return role;
    }
    
    public void setRole(String role) {
    	this.role = role;
    }
    
    public String getID() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public String getPhonenum() {
    	return phonenum;
    }
    
    public void setPhonenum(String phonenum) {
    	this.phonenum = phonenum;
    }
    
    public String getGpa() {
    	return gpa;
    }
    
    public void setGpa(String gpa) {
    	this.gpa = gpa;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public void setStudentCredits(String studentCredits) {
    	this.studentCredits = studentCredits;
    }
    
    public String getStudentCredits() {
    	return studentCredits;
    }
    
    public void setAccountBalance(String accountBalance) {
    	this.accountBalance = accountBalance;
    	
    }
    
    public String getAccountBalance() {
    	return accountBalance;
    }
    
    
}