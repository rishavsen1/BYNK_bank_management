<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>Logout</title>
<style>
</style>
</head>
<body>

	<%
		
		session.removeAttribute("is_logged_in");
		session.invalidate();
		
	%>

	<h1>Logout Successfully....</h1>
	<a href="welcome.jsp">Home</a>
	
	
	
	
	
</body>
</html>