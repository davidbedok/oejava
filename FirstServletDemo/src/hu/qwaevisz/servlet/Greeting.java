package hu.qwaevisz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Greeting
 */
@WebServlet(urlPatterns = { "/Greeting" }, initParams = { @WebInitParam(name = "name", value = "stranger") })
public class Greeting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Greeting() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = this.getServletConfig().getInitParameter("name");
		// Enumeration<String> params = this.getServletConfig().getInitParameterNames();
		PrintWriter out = response.getWriter();
		out.println("<html><title>Greeting</title><body>");
		out.println("<p style=\"text-align:center\">Hello <b>" + name + "</b>!</p>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
