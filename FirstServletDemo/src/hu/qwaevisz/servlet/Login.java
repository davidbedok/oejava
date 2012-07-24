package hu.qwaevisz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

	private static final long serialVersionUID = -1369642543569015420L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtain the session object, create a new session if doesn't exist
		HttpSession session = request.getSession(true);
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		System.out.println("isLogin = " + isLogin);
		if (isLogin != null && isLogin) {
			response.sendRedirect("Work");
		} else {
			response.sendRedirect("login.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		System.out.println("username = " + username);
		System.out.println("userpassword = " + userpassword);
		if ("david".equals(username) && "password".equals(userpassword)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("isLogin", true);
			System.out.println("set isLogin = true");
		}
		this.doGet(request, response);
	}

}
