<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.prog32758.Question"%>
<%@ page import="com.prog32758.Player"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sheridan Jeopardy!</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<!-- Latest compiled JavaScript -->
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

	<script src="script.js"></script>

	<link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<%
	session = request.getSession();
	Player p = (Player) session.getAttribute("Player");
	Question q = (Question) session.getAttribute("Question");
%>

<body class="bg">

	<div class="container full-height">
		<div class="jumbotron v-center">
			<div class="container">
				<div class="row d-flex justify-content-center">
					<h1 class="sheridan-orange">Daily Double!</h1>
				</div>
				<div class="row d-flex justify-content-center">
					<h3 class="sheridan-lblue">More risk, more reward!</h3>
				</div>
				<div class="row d-flex justify-content-center">
					<h4>Your current score is $<%=p.getScore()%></h4>
				</div>
				
				<form class="form-inline d-flex justify-content-center" action="DailyDouble" method="post">
					<label class="sheridan-blue"> Question Value: $</label>
					<input type="number" class="form-control mr-sm-3" name="value" min="0" max="<%=((p.getScore() < 1000) ? 1000 : p.getScore())%>" value="0">
					<input type="submit" value="Continue" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>