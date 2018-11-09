<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.prog32758.Player" %>
<%@ page import = "com.prog32758.Question" %>

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

  <!-- used to enable answer button after an option is selected -->
  <script src="script.js"></script>

  <link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<%
session = request.getSession();
Player p = (Player)session.getAttribute("Player");
Question q = (Question)session.getAttribute("Question");
%>

<body class="bg">
  <div class="container full-height">
    <div class="container v-center">
      <div class="row d-flex justify-content-center">
        <h4 class="text-center sheridan-orange" id="question-font">
          $<%=q.getValue() %>
        </h4>
      </div>
      <div class="row d-flex justify-content-center">
        <h3 class="text-center sheridan-lblue" id="question-font">
          <%=q.getCategory() %>
        </h3>
      </div>
      <div class="row d-flex justify-content-center">
        <h1 class="text-center" id="question-font">
          <%=q.getQuestion() %>
        </h1>
      </div>

      <form action="AnswerSelect" method="post">

        <div class="row d-flex justify-content-center answers input-group">
          <div class="input-group-prepend">
            <div class="input-group-text">
              <input type="radio" name="answer" id="option" value="<%=q.getA1() %>" onclick="enableBtn()">
            </div>
          </div>
          <h4 class="form-control answers-spacing answers-rounded-right" id="test"><%=q.getA1() %></h4>
          <div class="input-group-prepend">
            <div class="input-group-text answers-rounded-left">
              <input type="radio" name="answer" id="option" value="<%=q.getA2() %>" onclick="enableBtn()">
            </div>
          </div>
          <h4 class="form-control" id="test2"><%=q.getA2() %></h4>
        </div>

        <div class="row d-flex justify-content-center input-group">
          <div class="input-group-prepend">
            <div class="input-group-text">
              <input type="radio" name="answer" value="<%=q.getA3() %>" onclick="enableBtn()">
            </div>
          </div>
          <h4 class="form-control answers-spacing answers-rounded-right"><%=q.getA3() %></h4>
          <div class="input-group-prepend">
            <div class="input-group-text answers-rounded-left">
              <input type="radio" name="answer" value="<%=q.getA4() %>" onclick="enableBtn()">
            </div>
          </div>
          <h4 class="form-control"><%=q.getA4() %></h4>
        </div>

        <div class="row d-flex justify-content-center answers input-group">
       	  <div class="col-sm-6">
       		<input type="submit" name="continue" id="skip" value="Skip Question" class="btn btn-secondary">
       	  </div>
          <div>
        	<input type="submit" name="continue" id="answer" value="Final Answer" class="btn btn-secondary" disabled>
          </div>
        </div> 

      </form>
    </div>
  </div>
</body>

</html>
