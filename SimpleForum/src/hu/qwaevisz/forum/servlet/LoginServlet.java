package hu.qwaevisz.forum.servlet;

import hu.qwaevisz.forum.holder.UserData;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public static final String ATTR_USERNAME = "username";
	private static final String ATTR_ERROR = "error";

	private static final String PARAM_NAME = "name";
	private static final String PARAM_PASS = "password";

	private static final long serialVersionUID = -4874435092933942855L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((session != null)
				&& (session.getAttribute(LoginServlet.ATTR_USERNAME) != null)) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("loginPage.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter(LoginServlet.PARAM_NAME);
		String password = request.getParameter(LoginServlet.PARAM_PASS);
		String errorMessage = null;
		if ((username != null) && (password != null)) {
			if (UserData.getInstance().login(username, password)) {
				session.setAttribute(LoginServlet.ATTR_USERNAME, username);
			} else {
				errorMessage = "Login failed.";
			}
		} else {
			errorMessage = "Username and/or password is/are empty.";
		}
		if (errorMessage != null) {
			session.setAttribute(LoginServlet.ATTR_ERROR, errorMessage);
			response.sendRedirect("loginPage.jsp");
		} else {
			response.sendRedirect("list");
		}
	}
}
