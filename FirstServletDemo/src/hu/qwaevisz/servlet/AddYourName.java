package hu.qwaevisz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet
public class AddYourName extends HttpServlet {

	private static final long serialVersionUID = -2277525166306841859L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");

		PrintWriter out = response.getWriter();
		out.println("<html><title>Greeting</title><body>");
		out.println("<p style=\"text-align:center\">Hello <b>" + name
				+ "</b>!</p>");
		out.println("</body></html>");
		out.close();
	}

}
