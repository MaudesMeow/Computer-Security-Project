<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Page</title>
</head>
<body>
	
	<h2>Hello, <%= session.getAttribute("username") %>.</h2>
	<form action="<%=request.getContextPath() %>/changegpa" method="post" >
		<p id="showDate"></p>
	<h3>Change Student GPA</h3>
	<b>Enter the Student's ID</b><input type="text" name="id"><br>
	<b>Enter the Studen'ts New GPA</b><input type="text" name="gpa"><br>
	<input type = "submit" value="Change GPA" > 
	</form>
		
	<form action="<%=request.getContextPath() %>/changetuition" method="post">
	<h3>Change Student tuition</h3>
	<b>Enter the Student's ID</b><input type="text" name="id"><br>
	<b>Enter the amount to add to student's account</b><input type="text" name="tuitionamount"><br>
	<input type = "submit" value="Change Tuition">
	</form>

	<form action="<%=request.getContextPath() %>/addstudent" method="post">
	<h3>Add Student</h3>
	<b>Enter the Student's Name</b><input type="text" name="name"><br>
	<b>Create a Password for the Student</b><input type="text" name="password"><br>
	<b>Create an ID for the Student</b><input type="text" name="ID"><br>
	<b>Enter the Student's Address</b><input type="text" name="address"><br>
	<b>Enter the Student's Phone Number</b><input type="text" name="phonenum"><br>
	<b>Enter the Student's GPA</b><input type="text" name="gpa"><br>
	<b>Enter the number of credits the student has</b><input type="text" name="studentCredit"><br>
	<b>Enter Initial Tuition</b><input type="text" name="accountBalance"><br>
	<input type = "submit" value="Add Student">
	</form>
</body>
</html>