package hu.qwavisz.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.library.domain.Book;
import hu.qwaevisz.library.holder.Library;

@WebServlet("/Book")
public class BookView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;

	private static final String PARAM_ISBN = "isbn";
	private static final String ATTRIBUTE_BOOK = "book";
	private static final String PAGE = "book.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter(PARAM_ISBN);
		Book book = Library.getInstance().find(isbn);
		request.setAttribute(ATTRIBUTE_BOOK, book);
		RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
