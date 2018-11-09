package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

@WebServlet("/AnswerSelect")
public class AnswerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AnswerSelect() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		HttpSession session = request.getSession();
		Player p = (Player) session.getAttribute("Player");
		Question q = (Question) session.getAttribute("Question");
		LoadQuestions lq = (LoadQuestions) session.getAttribute("Questions");
		Boolean isFinished = false;

		String button = request.getParameter("continue"); // determine skip or answer btn

		if (button.equals("Skip Question")) { // if skip question...
			rd = request.getRequestDispatcher(checkGameOver(lq)); 
			q.setValue(q.getOldValue());	//for board.jsp generator functionality
		} else if (button.equals("Final Answer")) { // if answer question...
			String answer = request.getParameter("answer");
			if (answer.equals(q.getaCorrect())) {		// ... check if correct
				p.setScore(p.getScore() + q.getValue());
			} else {
				p.setScore(p.getScore() - q.getValue());
			}

			rd = request.getRequestDispatcher(checkGameOver(lq)); 
			q.setValue(q.getOldValue());	//for board.jsp generator functionality			
		}
		rd.forward(request, response);
		
	}
	
	protected String checkGameOver(LoadQuestions lq) {
		String rd = "";
		for (Question q: lq.getQuestions()) {
			if (q.getDisabled().equals("disabled")) {
				rd = "gameover.jsp";
			} else {
				rd = "board.jsp";
			}
		}
		return rd;
	}

}
