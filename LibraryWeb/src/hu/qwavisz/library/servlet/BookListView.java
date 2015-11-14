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
	private static final String ATTRIBUTE_CATEGORY = "category";

	private static final String PAGE = "list.jsp";

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final List<Book> books = Library.getInstance().getBooks();
		this.forward(request, response, books, VALUE_CATEGORY_ALL);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = null;
		final String categoryName = request.getParameter(PARAM_CATEGORY);
		if (categoryName.equals(VALUE_CATEGORY_ALL)) {
			books = Library.getInstance().getBooks();
		} else {
			books = Library.getInstance().getBooks(BookCategory.valueOf(categoryName));
		}
		this.forward(request, response, books, categoryName);
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final List<Book> books, final String categoryName)
			throws ServletException, IOException {
		request.setAttribute(ATTRIBUTE_BOOKS, books);
		request.setAttribute(ATTRIBUTE_CATEGORY, categoryName);

		final RequestDispatcher view = request.getRequestDispatcher(PAGE);
		view.forward(request, response);
	}

}
