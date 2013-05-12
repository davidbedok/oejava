package hu.qwaevisz.forum.servlet;

import hu.qwaevisz.forum.holder.Forum;
import hu.qwaevisz.forum.holder.ForumEntry;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1259630997637112270L;

	private static final String INIT_PARAM_ENTRIES = "entries";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String initEntriesStr = config.getInitParameter(ListServlet.INIT_PARAM_ENTRIES);
		List<ForumEntry> initEntries = Forum.parseEntries(initEntriesStr);
		Forum.getInstance().getPosts().addAll(initEntries);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("listPage.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
