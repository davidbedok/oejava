package hu.qwaevisz.familytree;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FamilyPage")
public class FamilyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FamilyPage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {

	}

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("familyPage.jsp");
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
	}

}
