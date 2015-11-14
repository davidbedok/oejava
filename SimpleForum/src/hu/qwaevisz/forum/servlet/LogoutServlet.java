package hu.qwaevisz.forum.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.qwaevisz.forum.common.SessionAttribute;

public class LogoutServlet extends HttpServlet implements SessionAttribute {

	private static final long serialVersionUID = -331209667333788787L;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final HttpSession session = request.getSession();
		if ((session != null) && (session.getAttribute(USER) != null)) {
			session.removeAttribute(USER);
		}
		response.sendRedirect("list");
	}

}
