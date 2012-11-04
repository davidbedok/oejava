package hu.qwaevisz.forum.servlet;

import hu.qwaevisz.forum.holder.Forum;
import hu.qwaevisz.forum.holder.User;
import hu.qwaevisz.forum.holder.UserData;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewEntryServlet extends HttpServlet {

	private static final long serialVersionUID = 1338299110193989099L;

	private static final String PARAM_MESSAGE = "message";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter(NewEntryServlet.PARAM_MESSAGE);
		if (message != null) {
			HttpSession session = request.getSession();
			String userName = (String) session
					.getAttribute(LoginServlet.ATTR_USERNAME);
			User user = UserData.getInstance().findUser(userName);
			if (user != null) {
				Forum.getInstance().addEntry(user.getNick(), message);
			}
			response.sendRedirect("list");
		}
	}

}
