package hu.qwaevisz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = -1369642543569015420L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Headerh1</h1>");
		out.println("<h2>Headerh2</h2>");
		out.println("<h3>Headerh3</h3>");
		out.println("<b>GET: </b>" + param1);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Headerh1</h1>");
		out.println("<h2>Headerh2</h2>");
		out.println("<h3>Headerh3</h3>");
		out.println("<b>POST: </b>" + param1);
		out.close();
	}

}
