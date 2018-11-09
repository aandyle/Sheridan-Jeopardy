<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "com.prog32758.Player" %>
<%@ page import = "com.prog32758.LoadQuestions" %>
<%@ page import = "com.prog32758.Question" %>
<%@ page import = "java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <title>Sheridan Jeopardy!</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<%
session = request.getSession();
Player p = (Player)session.getAttribute("Player"); 
LoadQuestions lq = (LoadQuestions)session.getAttribute("Questions"); //object that has an array of question objects
%>

<body class="bg">
  <div class="v-center">
  <div class="container">
    <div class="row d-flex justify-content-center">
      <h1 class="white">Player: <%=p.getName() %> | Winnings: $<%=p.getScore() %></h1>
    </div>
    <div class="row d-flex justify-content-center">
      <div class="grid-top col-sm-2 category">
        Food
      </div>
      <div class="grid-top col-sm-2 category">
        History
      </div>
      <div class="grid-top col-sm-2 category">
        Facilities
      </div>
      <div class="grid-top col-sm-2 category">
        Academics
      </div>
      <div class="grid-top col-sm-2 category">
        Services
      </div>
    </div>
          
      <form action="PickQuestion" method="post">
      	<% 
      	HashMap<String, String> categories = new HashMap<>();
		categories.put("1", "Food"); // key, value
		categories.put("2", "History");
		categories.put("3", "Facilities");
		categories.put("4", "Academics");
		categories.put("5", "Services");

		HashMap<String, Integer> values = new HashMap<>();
		values.put("$400", 400);
		values.put("$800", 800);
		values.put("$1200", 1200);
		values.put("$1600", 1600);
		values.put("$2000", 2000);
      	  int val = 400;
      	  for (int i = 1; i < 6; i++) { %>
      		  <div class="row d-flex justify-content-center">
      		  <%
      		  for (int j = 1; j < 6; j++) { 
      			for (Question q : lq.getQuestions()) {	//find corresponding question
      				if (q.getCategory().equals(categories.get(""+j)) && q.getValue() == values.get("$"+val)) {
      					if (q.getDisabled().equals("disabled")){ %>
      						<input type="submit" name="<%=j%>" value="$<%=val%>" class="grid grid-style-disabled col-sm-2" disabled>
      						<%
      					} else {
      						%>
      						<input type="submit" name="<%=j%>" value="$<%=val%>" class="grid grid-style col-sm-2">
      						<%
      					}
      				}
      			}
      		  }
      		  %>
      		  </div>
      		  <%
      		  val += 400;
      	  }
      	%>
      </form>
  </div>
  </div>
  <script src="script.js"></script>
</body>

</html>
