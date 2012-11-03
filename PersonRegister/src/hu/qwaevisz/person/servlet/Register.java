package hu.qwaevisz.person.servlet;

import hu.qwaevisz.person.holder.Person;
import hu.qwaevisz.person.holder.PersonCatalog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	// Tomcat 7 (pr.war)
	// http://localhost:8080/pr/registerpage.html

	private static final long serialVersionUID = -4138617877339469130L;

	private static final String PARAM_NAME = "name";
	private static final String PARAM_PASS = "password";
	private static final String PARAM_PASS_AGAIN = "passwordagain";
	private static final String PARAM_EMAIL = "email";

	private static final int MIN_NAME_LENGTH = 5;

	private static final String HTML5_HEADER = "<!DOCTYPE html>";
	private static final String HTML_FRAME = "<html><head>{head}</head><body>{body}</body></html>";

	private static final String META_CONTENT = "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter(Register.PARAM_NAME);
		String password = request.getParameter(Register.PARAM_PASS);
		String repassword = request.getParameter(Register.PARAM_PASS_AGAIN);
		String email = request.getParameter(Register.PARAM_EMAIL);

		List<String> errors = this.checkParams(name, password, repassword,
				email);
		if (errors.isEmpty()) {
			PersonCatalog.getInstance().addPerson(name, password, email);
		}

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(this.responseContent(errors));
		out.close();
	}

	private List<String> checkParams(String name, String password,
			String repassword, String email) {
		List<String> errors = new ArrayList<String>();
		if (name == null) {
			errors.add("Name is empty.");
		} else if (name.length() < Register.MIN_NAME_LENGTH) {
			errors.add("Name is too short (min: " + Register.MIN_NAME_LENGTH
					+ ").");
		}
		if ((password == null) || (repassword == null)) {
			errors.add("Password(s) is/are empty.");
		} else if (!password.equals(repassword)) {
			errors.add("Passwords are not equals.");
		}
		if (email == null) {
			errors.add("E-mail is empty.");
		} else if (!email.contains("@")) {
			errors.add("E-mail address is not valid.");
		}
		return errors;
	}

	private String responseContent(List<String> errors) {
		String head = Register.META_CONTENT;
		head += "<title>People</title>";

		String body = this.errorsHtml(errors) + "<br/>";
		body += this.peopleHtml();

		String frame = Register.HTML5_HEADER + Register.HTML_FRAME;
		frame = frame.replace("{head}", head);
		frame = frame.replace("{body}", body);
		return frame;
	}

	private String errorsHtml(List<String> errors) {
		StringBuilder errorSb = new StringBuilder();
		errorSb.append("<ul>");
		for (String error : errors) {
			errorSb.append("<li>").append(error).append("</li>");
		}
		errorSb.append("</ul>");
		return errorSb.toString();
	}

	private String peopleHtml() {
		StringBuilder table = new StringBuilder();
		table.append("<table border=\"1\">");
		table.append("<thead>");
		table.append("<tr>");
		table.append("<th>Name</th>");
		table.append("<th>Password</th>");
		table.append("<th>E-mail</th>");
		table.append("</tr>");
		table.append("</thead>");
		table.append("<tbody>");
		for (Person person : PersonCatalog.getInstance().getPeople()) {
			table.append("<tr>");
			table.append("<td>" + person.getName() + "</td>");
			table.append("<td>" + person.getPassword() + "</td>");
			table.append("<td>" + person.getEmail() + "</td>");
			table.append("</tr>");
		}
		table.append("</tbody>");
		table.append("</table>");
		return table.toString();
	}

}
