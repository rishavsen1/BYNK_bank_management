<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Result</title>
</head>
<body>
	<h1 align="center">Transaction Details</h1>
	<table border="1" bordercolor="red" cellpadding="30%" align="center">
		
			<tr>
				<td>Source Customer ID</td>
				<td>${tr.sourceId}</td>
				
			</tr>
		
		
			<tr>
				<td>Latest Balance(Source)</td>
				<td>${tr.sourceAmt}</td>
					
			</tr>
			
			<tr>
				<td>Target Customer ID</td>
				<td>${tr.targetId}</td>
				
			</tr>
			
			<tr>
				<td>Latest Balance(Target)</td>
				<td>${tr.targetAmt}</td>
					
			</tr>
			
			
	</table>
</body>
</html>