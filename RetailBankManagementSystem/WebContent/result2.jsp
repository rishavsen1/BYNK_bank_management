<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Indie+Flower&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@600&display=swap" rel="stylesheet">
</head>
<style>
	body{
		margin:150px 50px;
		padding-top:20px;
		padding-bottom:20px;
	}
	.nav-item{
		font-family: 'Indie Flower', cursive;
		font-size: 1.5rem;
	}
	.display-3{
		font-family: 'Source Sans Pro', sans-serif;
	}
	.nav{
		margin-top:80px;
		margin-left:500px;
	}
</style>
<body>
	<h1 class="display-3"><%= request.getAttribute("balance-withdraw") %></h1>
	<nav>
			<ul class="nav">
				<li class="nav-item">
    				<a class="nav-link active" href="cashier-actions.jsp">Back</a>
  				</li>
			</ul>
		</nav>
</body>
</html>