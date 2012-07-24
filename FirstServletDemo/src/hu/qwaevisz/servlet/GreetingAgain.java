package hu.qwaevisz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingAgain extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name = this.getServletConfig().getInitParameter("name");
		// Enumeration<String> params = this.getServletConfig().getInitParameterNames();
		PrintWriter out = response.getWriter();
		out.println("<html><title>Greeting Again</title><body>");
		out.println("<p style=\"text-align:center\">Hello <b>" + name + "</b>!</p>");
		out.println("</body></html>");
		out.close();
	}

}
