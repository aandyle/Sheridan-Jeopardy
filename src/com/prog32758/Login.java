package com.prog32758;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getParameter("nickname");
		
		Player p = new Player(nickname);
		LoadQuestions q = new LoadQuestions();
		q.load();
		
		// list of categories; keys used for buttons
		HashMap<Integer, String> categories = new HashMap<>();
		categories.put(1, "Food"); // key, value
		categories.put(2, "History");
		categories.put(3, "Facilities");
		categories.put(4, "Academics");
		categories.put(5, "Services");
		
		//load the player and questions into session for tracking
		HttpSession session = request.getSession();
		session.setAttribute("Player", p);
		session.setAttribute("Questions", q);
		session.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
	}

}
