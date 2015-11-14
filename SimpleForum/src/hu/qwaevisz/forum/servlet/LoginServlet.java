package hu.qwaevisz.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.qwaevisz.forum.common.LoginAttribute;
import hu.qwaevisz.forum.common.LoginField;
import hu.qwaevisz.forum.common.Page;
import hu.qwaevisz.forum.common.SessionAttribute;
import hu.qwaevisz.forum.holder.User;
import hu.qwaevisz.forum.holder.UserData;

public class LoginServlet extends HttpServlet implements LoginAttribute, LoginField, SessionAttribute {

	private static final long serialVersionUID = -4874435092933942855L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		if ((session != null) && (session.getAttribute(USER) != null)) {
			response.sendRedirect("list");
			// request.getRequestDispatcher(Page.LIST).forward(request, response);
		} else {
			request.setAttribute(ERROR, "");
			request.getRequestDispatcher(Page.LOGIN).forward(request, response);
		}
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		final String username = request.getParameter(NAME);
		final String password = request.getParameter(PASSWORD);
		String error = null;
		if ((username != null) && (password != null)) {
			final User user = UserData.getInstance().login(username, password);
			if (user != null) {
				session.setAttribute(USER, user);
			} else {
				error = "Login failed.";
			}
		} else {
			error = "Username and/or password is/are empty.";
		}
		if (error != null) {
			request.setAttribute(ERROR, error);
			request.getRequestDispatcher(Page.LOGIN).forward(request, response);
		} else {
			response.sendRedirect("list");
			// request.getRequestDispatcher(Page.LIST).forward(request, response);
		}
	}
}
