package hu.qwavisz.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.library.domain.Book;
import hu.qwaevisz.library.domain.BookCategory;
import hu.qwaevisz.library.holder.Library;

@WebServlet("/BookList")
public class BookListView extends HttpServlet {

	private static final long serialVersionUID = 6795352961757251493L;

	private static final String PARAM_CATEGORY = "category";
	private static final String VALUE_CATEGORY_ALL = "-1";
	private static final String ATTRIBUTE_BOOKS = "books";
	private static final String ATTRIBUTE_CATEGORY_VALUE = "category";

	private static final String PAGE = "list.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final List<Book> books = Library.getInstance().getBooks();
		request.setAttribute(ATTRIBUTE_BOOKS, books);
		request.setAttribute(ATTRIBUTE_CATEGORY_VALUE, VALUE_CATEGORY_ALL);

		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = null;
		String categoryName = request.getParameter(PARAM_CATEGORY);
		if (categoryName.equals(VALUE_CATEGORY_ALL)) {
			books = Library.getInstance().getBooks();
		} else {
			books = Library.getInstance().getBooks(BookCategory.valueOf(categoryName));
		}
		request.setAttribute(ATTRIBUTE_BOOKS, books);
		request.setAttribute(ATTRIBUTE_CATEGORY_VALUE, categoryName);

		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
