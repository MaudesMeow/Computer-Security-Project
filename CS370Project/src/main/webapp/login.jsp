<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script src="https://www.google.com/recaptcha/enterprise.js?render=6LfWACMkAAAAAKwQaCPuJD7DfSWBfc0cUiDXYank"></script>
<script src="//www.google.com/recaptcha/api.js"></script>
</head>
<body>
	Welcome to CS370 Project
	<div align="center">
	<h1>User Login Form</h1>
	<form action="<%=request.getContextPath() %>/login" method="post">
		<table style="width: 100%">
			<tr>
				<td>Username</td>
				<td><input type = "text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type = "password" name="password"></td>
			</tr>
			<div class="g-recaptcha"
			data-sitekey="6LfWACMkAAAAAKwQaCPuJD7DfSWBfc0cUiDXYank"></div>
		</table>
		<input type="submit" value="Log In">
		</form>
		</div>
</body>
</html>