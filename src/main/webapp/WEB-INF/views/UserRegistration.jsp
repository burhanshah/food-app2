<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<title>User Registration</title>
	    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	    <link rel="shortcut icon" href="images/logo.png" type="image/x-icon">
	    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
	<div align="center">
		<h1>User Registration Form</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
			<table style="width: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"/></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td>User Type</td>
					<td><input type="text" name="userType"/></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>