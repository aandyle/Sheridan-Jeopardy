package com.prog32758;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AnswerSelect")
public class AnswerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnswerSelect() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		HttpSession session = request.getSession();
		Player p = (Player) session.getAttribute("Player");
		Question q = (Question) session.getAttribute("Question");
		LoadQuestions lq = (LoadQuestions) session.getAttribute("Questions");
		Boolean isFinished = false;

		String button = request.getParameter("continue"); // determine skip or answer btn

		if (button.equals("Skip Question")) { // if skip question

			for (Question question : lq.getQuestions()) { // check if game over
				if (question.getDisabled().equals("disabled")) {
					isFinished = true;
					rd = request.getRequestDispatcher("gameover.jsp");
				} else {
					rd = request.getRequestDispatcher("board.jsp");
					break;
				}
			}
		} else if (button.equals("Final Answer")) { // if answer question
			String answer = request.getParameter("answer");
			if (answer.equals(q.getaCorrect())) {
				p.setScore(p.getScore() + q.getValue());
			} else {
				p.setScore(p.getScore() - q.getValue());
			}

			for (Question question : lq.getQuestions()) { // check if game over
				if (question.getDisabled().equals("disabled")) {
					isFinished = true;
					rd = request.getRequestDispatcher("gameover.jsp");
				} else {
					rd = request.getRequestDispatcher("board.jsp");
					break;
				}
			}
			q.setValue(q.getOldValue());	//for board.jsp generator
		}
		rd.forward(request, response);

	}

}
