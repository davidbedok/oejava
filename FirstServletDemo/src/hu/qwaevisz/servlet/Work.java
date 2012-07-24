package hu.qwaevisz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Work extends HttpServlet {

	private static final long serialVersionUID = -1369642543569015420L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		System.out.println("isLogin = " + isLogin);
		if (isLogin != null && isLogin) {
			response.sendRedirect("work.html");
		} else {
			response.sendRedirect("Login");
		}
	}

}
