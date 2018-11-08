package com.prog32758;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PickQuestion")
public class PickQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PickQuestion() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("question.jsp");;
		String category, value;
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

		HttpSession session = request.getSession();

		LoadQuestions questions = (LoadQuestions) session.getAttribute("Questions");

		Enumeration en = request.getParameterNames();
		while (en.hasMoreElements()) {
			Object obj = en.nextElement(); // get element
			String param = (String) obj; // get parameter
			String val = request.getParameter(param); // get parameter value

			category = categories.get(param); // determine category
			value = val; // determine $$$ value

			for (Question q : questions.getQuestions()) { // find corresponding question; set disabled
				if (q.getCategory().equals(category) && q.getValue() == values.get(val)) {
					q.setDisabled("disabled");
					session.setAttribute("Question", q);
					if (q.getDailyDouble()) {		//isdailydouble?
						rd = request.getRequestDispatcher("dailydouble.jsp");
					}
				}
			}
		}

		rd.forward(request, response);

	}

}
