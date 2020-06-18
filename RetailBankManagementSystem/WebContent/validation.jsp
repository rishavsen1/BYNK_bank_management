<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<body>
	<%
		boolean isLoggedIn = false;
	    isLoggedIn = (boolean)session.getAttribute("is_logged_in");
		if(!isLoggedIn){
			out.println("Sorry,Username or Password Error");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
	%>
</body>
</html>