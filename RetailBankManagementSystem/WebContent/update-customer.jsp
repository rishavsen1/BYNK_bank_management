<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>BYNK</title>
    <link href="./resources/search/search.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
    <div class="container">
      <header>
        <h2>
          <a href="#"><i class="ion-plane"></i><span id = "bynk">BYNK</span></a>
        </h2>
        <nav></nav>
      </header>

      <div class="cover">
        <h1>Search for Customers</h1>
        <form class="flex-form" method = "POST" action="./UpdateServlet">
          <label for="from">
            <i class="ion-location"></i>
          </label>
          <input name="id" type="search" placeholder="Type in Customer ID" />
          <input type="submit" value="Search" />
        </form>
        <div id="madeby">
          <span>
            
            <a href="./markus-winkler-afW1hht0NSs-unsplash.jpg" target="_blank">
            </a>
          </span>
        </div>
      </div>
    </div>
  </body>
</html>
