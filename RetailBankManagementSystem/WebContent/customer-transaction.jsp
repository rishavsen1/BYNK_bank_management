<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer-Transaction</title>
<link
      href="https://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
    />

    <link href="./resources/deposit-withdraw/css/account.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="regform"><h1>DEPOSIT AMOUNT</h1></div>
	<div class="main">
			<form method="post" action="./TransactionServlet">
			<div id="name">
			
			<h2 class="name">Enter Source Customer ID</h2>
			<input class="input1" type="text" name="id1" placeholder="Source Customer ID">
			
			<h2 class="name">Enter Target Customer ID</h2>
			<input class="input3" type="text" name="id2" placeholder="Destination Customer ID">
			
			<h2 class="name">Enter Amount to Transfer</h2>
			<input class="input3" type="text" name="amount" placeholder="Amount">
			
			<input class="submit" type="submit" value="TRANSFER"> 
			</div>
			</form>
			
	</div>
</body>
</html>