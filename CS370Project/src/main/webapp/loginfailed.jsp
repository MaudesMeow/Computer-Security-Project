<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Failed</title>
</head>
<body>
 <div align="center">
  <h1>Access Denied. Please Log in again.</h1>
  Today's date: <%= (new java.util.Date()).toLocaleString()%>
 </div>
</body>
</html>