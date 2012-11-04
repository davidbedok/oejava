package hu.qwaevisz.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	// Tomcat 7 (hello.war)
	// http://localhost:8080/hello/TestServlet

	private static final long serialVersionUID = 4678131951377472233L;

	private static final String HTML5_HEADER = "<!DOCTYPE html>";
	private static final String HTML_FRAME = "<html><head>{head}</head><body>{body}</body></html>";

	private static final String META_CONTENT = "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">";

	private int counter;

	public TestServlet() {
		this.counter = 0;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.counter++;

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(this.responseContent());
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private String responseContent() {
		String head = TestServlet.META_CONTENT;
		head += "<title>TestServlet</title>";

		String frame = TestServlet.HTML5_HEADER + TestServlet.HTML_FRAME;
		frame = frame.replace("{head}", head);
		frame = frame.replace("{body}", Integer.valueOf(this.counter)
				.toString());
		return frame;
	}

}