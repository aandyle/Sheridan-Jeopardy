package com.prog32758;

import java.io.IOException;

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
		
		HttpSession session = request.getSession();
		session.setAttribute("Player", p);
		session.setAttribute("Questions", q);
		
		RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
		rd.forward(request, response);
	}

}
