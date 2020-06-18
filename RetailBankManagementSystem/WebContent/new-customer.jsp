<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BYNK</title>
    <link href="./resources/new-customer/inputbox.css" rel="stylesheet" type="text/css" />
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans"
      rel="stylesheet"
    />
  </head>
  <body>
  	<%!
		String status = "";
	%>
	<% if(request.getAttribute("status") != null)
		
		status =  request.getAttribute("status").toString();
		
		%>
	
  <div class="signup-container">
    <div class="left-container">
      <h1>
        BYANK
      </h1>
      <div class="customer">
        <h2>We serve for you, with you</h2>
        <img src="./resources/new-customer/banner-img.png"/>
      </div>
    </div>
    <div class="right-container">
      <form action="./CustomerServlet" method="post">
      <header>          
        <h1>Complete Customer Details</h1>
        <div class="set">
          <div class="user-name">
            <label for="user-name">Name</label>
            <input id="user-name" name="custName" placeholder="Customer's name" type="text"></input>
          </div>
          <div class="user-photo">
            <button id="user-upload">
              <!-- <i class="fas fa-camera-retro"></i> -->
            </button>
            <label for="user-upload">All details mandatory</label>
          </div>
        </div>
        <div class="set">
          <div class="user-address">
            <label for="user-address">Address</label>
            <input id="user-address" name="custAddress" placeholder="Current Address" type="text"></input>
          </div>
          <div class="user-birthday">
            <label for="user-birthday">Age</label>
            <input id="user-birthday" name="custAge" placeholder="Age (in years)" type="number" min="18"></input>
          </div>
        </div>
        <div class="set">
          <div class="user-address">
            <label for="user-address">City</label>
            <input id="user-birthday" name="custCity" placeholder="Current city" type="text"></input>
          </div>
          <div class="user-State">
            <label for="user-State">State</label>
            <input type="text" id="user-State" placeholder="State" name="custState"></input>
            <!--  <select name="states" id="states">
                <option name="states" value=”Andaman and Nicobar Islands”>Andaman and Nicobar Islands</option>
                <option name="states" value=”Arunachal Pradesh”>Arunachal Pradesh</option>
                <option name="states" value=”Assam”>Assam</option>
                <option name="states" value=”Bihar”>Bihar</option>
                <option name="states" value=”Chandigarh”>Chandigarh</option>
                <option name="states" value=”Chhattisgarh”>Chhattisgarh</option>
                <option name="states" value=”Dadar and Nagar Haveli”>Dadar and Nagar Haveli</option>
                <option name="states" value=”Daman and Diu”>Daman and Diu</option>
                <option name="states" value=”Delhi”>Delhi</option>
                <option name="states" value=”Lakshadweep”>Lakshadweep</option>
                <option name="states" value=”Puducherry”>Puducherry</option>
                <option name="states" value=”Goa”>Goa</option>
                <option name="states" value=”Gujarat”>Gujarat</option>
                <option name="states" value=”Haryana”>Haryana</option>
                <option name="states" value=”Himachal Pradesh”>Himachal Pradesh</option>
                <option name="states" value=”Jammu and Kashmir”>Jammu and Kashmir</option>
                <option name="states" value=”Jharkhand”>Jharkhand</option>
                <option name="states" value=”Karnataka”>Karnataka</option>
                <option name="states" value=”Kerala”>Kerala</option>
                <option name="states" value=”Madhya Pradesh”>Madhya Pradesh</option>
                <option name="states" value=”Maharashtra”>Maharashtra</option>
                <option name="states" value=”Manipur”>Manipur</option>
                <option name="states" value=”Meghalaya”>Meghalaya</option>
                <option name="states" value=”Mizoram”>Mizoram</option>
                <option name="states" value=”Nagaland”>Nagaland</option>
                <option name="states" value=”Odisha”>Odisha</option>
                <option name="states" value=”Punjab”>Punjab</option>
                <option name="states" value=”Rajasthan”>Rajasthan</option>
                <option name="states" value=”Sikkim”>Sikkim</option>
                <option name="states" value=”Tamil Nadu”>Tamil Nadu</option>
                <option name="states" value=”Telangana”>Telangana</option>
                <option name="states" value=”Tripura”>Tripura</option>
                <option name="states" value=”Uttar Pradesh”>Uttar Pradesh</option>
                <option name="states" value=”Uttarakhand”>Uttarakhand</option>
                <option name="states" value=”West Bengal”>West Bengal</option>
              </select>-->
          </div>
        </div>
        
      </header>
      
      <footer>
        <div class="set">
        	
          <a href="actions.jsp" id="back">Back</a>
          
          <button id="next" href='#'>Submit</button>
          
        </div>
      </footer>
      </form>
      <div id="end"><%= status %></div>
  
    </div>
  </div>
    </body>
</html>
