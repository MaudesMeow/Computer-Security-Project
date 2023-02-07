<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Page</title>
</head>
<body>
	<table>
		<tr><td><h3>Student Name: <%= session.getAttribute("username") %></h3></td></tr>
		<tr><td><h3>BlugoldID: <%= session.getAttribute("id") %></h3></td></tr>
		<tr><td><h3>Address: <%= session.getAttribute("address") %></h3></td></tr>
		<tr><td><h3>Phone Number: <%= session.getAttribute("phonenum") %></h3></td></tr>
		<tr><td><h3>GPA: <%= session.getAttribute("gpa") %></h3></td></tr>
		<tr><td><h3>Student Credits: <%= session.getAttribute("studentCredit") %></h3></td></tr>
		<tr><td><h3>Account Balance: $<%= session.getAttribute("accountBalance") %></h3></td></tr>
	</table>
	
	<form action="<%=request.getContextPath() %>/changepassword" method="post">
	<h3>Change Password</h3>
	<b>Enter Your Current Password</b><input type="password" name="password"><br>
	<b>Enter Your New Password</b><input type="password" name="newpassword1"><br>
	<b>Confirm Your New Password</b><input type="password" name="newpassword2"><br>
	<input type = "submit" value="Change Password">
	</form>
	
	
	<form action="<%=request.getContextPath() %>/changephonenum" method="post">
	<h3>Change Phone Number</h3>
	<b>Enter Your New Phone Number</b><input type="text" name="phonenum"><br>
	<input type = "submit" value="Change Phone Number">
	</form>
	
	<form action="<%=request.getContextPath() %>/changeaddress" method="post">
	<h3>Change Address</h3>
	<b>Enter Your New Address</b><input type="text" name="address"><br>
	<input type = "submit" value="Change Address">
	</form>
	
	
</body>
</html>