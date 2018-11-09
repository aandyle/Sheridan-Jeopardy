package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DailyDouble")
public class DailyDouble extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DailyDouble() {
        super();
    }
    
    //handles changing question $$$ value for daily double
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
		
		Question q = (Question)session.getAttribute("Question");
		
		int value = Integer.parseInt(request.getParameter("value"));
		q.setOldValue(q.getValue());
		q.setValue(value);
		
		rd.forward(request, response);
	}

}
