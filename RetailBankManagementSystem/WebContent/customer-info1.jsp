<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Withdraw/Deposit</title>
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
    />

    <link href="./resources/deposit-withdraw/css/account.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
    


<div class="regform"><h1>DEPOSIT AMOUNT</h1></div>
	<div class="main">
			<form action="./WithDrawResultServlet" method="post">
			<div id="name">
			
			<h2 class="name">Customer ID</h2>
			<input class="input1" type="text" name="id" placeholder="Customer ID" 
				value=<c:forEach items="${customerInfo}" var="customer">
					${customer.id}
				</c:forEach>>
			
			<h2 class="name">Deposit Amount</h2>
			<input class="input3" type="text" name="amount" placeholder="Amount">
			
			
			<input class="submit" type="submit" value="WITHDRAW"> 
			</div>
			</form>
			
	</div>
  </body>
</html>
