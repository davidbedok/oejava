package hu.qwaevisz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingWithHtml extends HttpServlet {

	private static final long serialVersionUID = -1369642543569015420L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		// Enumeration<String> params = request.getParameterNames();
		PrintWriter out = response.getWriter();
		out.println("<html><title>Greeting With HTML</title><body>");
		out.println("<p style=\"text-align:center\">Hello <b>" + name + "</b>!</p>");
		out.println("</body></html>");
		out.close();
	}

}
