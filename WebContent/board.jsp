<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.prog32758.Player"%>
<%@ page import="com.prog32758.LoadQuestions"%>
<%@ page import="com.prog32758.Question"%>
<%@ page import="java.util.HashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Sheridan Jeopardy!</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body class="bg">
	<div class="v-center">
		<div class="container">
			<div class="row d-flex justify-content-center">
				<h1 class="white">Player: ${sessionScope.Player.name} |
					Winnings: $${sessionScope.Player.score }</h1>
			</div>

			<div class="row d-flex justify-content-center">
				<c:forEach var="cat" items="${categories}">
					<div class="grid-top col-sm-2 category">${cat.value}</div>
				</c:forEach>
			</div>
			
			<form action="PickQuestion" method="post">
				<c:set var="val" scope="page" value="400" />
				<c:forEach begin="1" end="5" varStatus="itr1">		<!-- new table row -->
					<div class="row d-flex justify-content-center">
						<c:forEach begin="1" end="5" varStatus="itr2">	<!-- columns -->
							<c:forEach var="q" items="${sessionScope.Questions.questions}">		<!-- list of questions -->
								<c:if test="${q.category == sessionScope.categories[itr2.index] && q.value == pageScope.val}">
									<c:choose>
										<c:when test="${q.disabled == 'disabled'}">
											<input type="submit" name="${itr2.index}" value="$${pageScope.val}"	class="grid grid-style-disabled col-sm-2" disabled>
										</c:when>
										<c:otherwise>
											<input type="submit" name="${itr2.index}" value="$${pageScope.val}"	class="grid grid-style col-sm-2">
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
					<c:set var="val" scope="page" value="${val + 400}" />
				</c:forEach>
			</form>

		</div>
	</div>
</body>

</html>
