<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
  <head>
    <title>BYNK Delete</title>
    <link href="./resources/delete/delete.css" rel="stylesheet" type="text/css" />
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
    />
  </head>
  <body>
    <aside class="profile-card">
      <header>
        <!-- here’s the avatar -->
        <a target="_blank" href="#">
          <img src="./resources/delete/Black POwer man.svg" />
        </a>

        <!-- the username -->
        <h1>
         <input id="user-name" name="custName" placeholder="Customer's name" type="text"
            	value=<c:forEach items="${customerInfo}" var="customer">
            			${customer.custName}
            		  </c:forEach>></input>
        </h1>

        <!-- and role or location -->
        <h2>
          <input type="text" name="custId" value=<c:forEach items="${customerInfo}" var="customer"> 
            			${customer.id}
            		  </c:forEach>>
        </h2>
      </header>

      <!-- bit of a bio; who are you? -->
      <div class="profile-bio">
        <p>
          <p><input id="user-birthday" name="custAge" placeholder="Age (in years)" type="text" min="18"
            	value=<c:forEach items="${customerInfo}" var="customer">
            			${customer.custAge}
            		  </c:forEach>></input></p>
          <p><textarea id="user-address" name="custAddress" placeholder="Current Address">
            	<c:forEach items="${customerInfo}" var="customer">
            			${customer.custAddress}
            	</c:forEach>
            </textarea></p>
          <p><input id="user-birthday" name="custCity" placeholder="Current city" type="text"
            	value=<c:forEach items="${customerInfo}" var="customer">
            			${customer.custCity}
            		  </c:forEach>></input></p>
          <p><textarea  id="user-State" placeholder="State" name="custState">
            	<c:forEach items="${customerInfo}" var="customer">
            			${customer.custState}
            	</c:forEach>
            </textarea></p>

        </p>
      </div>

      <!-- some social links to show off -->
      <div id ="del">
          CUSTOMER DELETED!
      </div>
      <nav id = "back"><button id="back-btn" >Back</button></nav>
    </aside>
  </body>
</html>
