<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.prog32758.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sheridan Jeopardy!</title>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

  <link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<%
session = request.getSession();
Player p = (Player)session.getAttribute("Player");
%>

<body class="bg">
	<div class="container full-height">
		<div class="container v-center">
			<div class="row d-flex justify-content-center">
				<h1 class="text-center sheridan-lblue" id="question-font">
					Congratulations <%=p.getName() %>!
				</h1>
			</div>
			<div class="row d-flex justify-content-center">
				<h1 class="text-center sheridan-orange" id="question-font">
					Winnings: $<%=p.getScore() %>!
				</h1>
			</div>
		</div>
	</div>
</body>
</html>