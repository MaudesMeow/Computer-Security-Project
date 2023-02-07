package Project;

import java.sql.Timestamp;

public class Security {
	
//prevent SQL Injection variables
	final static String Inj1 = "-";
	final static String Inj2 = "(";
	final static String Inj3 = ")";
	final static String Inj4 = "*";
	final static String Inj5 = "=";
	final static String Inj6 = "/";
	final static String Inj7 = "|";
	final static String Inj8 = "\\";
	final static String Inj9 = ";";
	final static String TestPass = "test";
	final static String TestFail = "test \\";
	
	static Timestamp A; 
	
	
	public static void main(String[] args) {
		
		verifyText(TestFail);    // for testing only
		
	}

	
	
//prevent SQL injection
	
	//Receive string and test for unauthorized characters
	public static void verifyText(String X) {
		if( X.contains(Inj1) || X.contains(Inj2) || X.contains(Inj3) || X.contains(Inj4) || X.contains(Inj5) || X.contains(Inj6) || 
				X.contains(Inj7) || X.contains(Inj8) || X.contains(Inj9)) {
			//deny entry - post unauthorized character error message and deny action/ return to login page
			A = new Timestamp(System.currentTimeMillis());
			System.out.println(X + "test failed " + A);
		}
		else{		
			//perform action
			A = new Timestamp(System.currentTimeMillis());
			System.out.println(X + ": test passed " + A);
		}
		
	}
	
}
	