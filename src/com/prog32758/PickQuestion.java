package com.prog32758;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
		HttpSession session = request.getSession();
		
		HashMap<Integer, String> categories = (HashMap<Integer,String>)session.getAttribute("categories");
		
		LoadQuestions questions = (LoadQuestions) session.getAttribute("Questions");
		
		Pattern p = Pattern.compile("\\d+");	//regex to convert $xxx to xxx
		Matcher m;
		
		Enumeration en = request.getParameterNames();
		while (en.hasMoreElements()) {
			Object obj = en.nextElement(); 				// get parameter name
			int param = Integer.parseInt((String)obj); 	// get parameter name
			String sVal = request.getParameter(""+param);	// get parameter value
			int val = 0; 									// regex store extracted dollar value from question 
			
			m = p.matcher(sVal); //regex to convert $xxx to xxx
			while (m.find()) {
				val = Integer.parseInt(m.group());
			}

			String category = (String)categories.get(param); // determine category from board.jsp selected button 
			
			for (Question q : questions.getQuestions()) { // find corresponding question selected then set disabled
				if (q.getCategory().equals(category) && q.getValue() == val) {
					q.setDisabled("disabled");
					session.setAttribute("Question", q);
					if (q.getDailyDouble()) {		//isdailydouble?
						rd = request.getRequestDispatcher("dailydouble.jsp");
					}
					break;
				}
			}
		}

		rd.forward(request, response);

	}

}
