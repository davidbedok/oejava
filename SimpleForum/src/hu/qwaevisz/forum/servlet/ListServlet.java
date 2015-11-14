package hu.qwaevisz.forum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.qwaevisz.forum.common.ListAttribute;
import hu.qwaevisz.forum.common.ListField;
import hu.qwaevisz.forum.common.Page;
import hu.qwaevisz.forum.common.SessionAttribute;
import hu.qwaevisz.forum.holder.Forum;
import hu.qwaevisz.forum.holder.ForumEntry;
import hu.qwaevisz.forum.holder.User;

public class ListServlet extends HttpServlet implements ListAttribute, ListField, SessionAttribute {

	private static final long serialVersionUID = 1259630997637112270L;

	private static final String INIT_PARAM_ENTRIES = "entries";

	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		final String initEntriesStr = config.getInitParameter(INIT_PARAM_ENTRIES);
		final List<ForumEntry> initEntries = Forum.parseEntries(initEntriesStr);
		Forum.getInstance().getPosts().addAll(initEntries);
	}

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		this.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String entry = request.getParameter(ENTRY);
		if (entry != null) {
			final HttpSession session = request.getSession();
			final User user = (User) session.getAttribute(USER);
			if (user != null) {
				Forum.getInstance().addEntry(user.getNick(), entry);
			}
			this.forward(request, response);
		}
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute(ENTRIES, Forum.getInstance().getPosts());
		request.getRequestDispatcher(Page.LIST).forward(request, response);
	}

}
