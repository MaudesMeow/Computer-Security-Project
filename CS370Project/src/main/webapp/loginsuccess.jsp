<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<script>
		function displayDate() {
		document.getElementByID("showDate").innerHTML = Date();
		}
	</script>
</head>
<body>
 <div align="center">
  <h1>You have logged in successfully</h1>
	<%Date date = new Date();
	out.print(date); 
	%>
 </div>
</body>
</html>