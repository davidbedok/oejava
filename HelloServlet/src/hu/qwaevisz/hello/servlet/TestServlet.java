package hu.qwaevisz.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 4678131951377472233L;

	private int counter;

	public TestServlet() {
		this.counter = 0;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.counter++;

		PrintWriter out = response.getWriter();
		out.println(Integer.valueOf(this.counter).toString());
		out.close();
	}

}
