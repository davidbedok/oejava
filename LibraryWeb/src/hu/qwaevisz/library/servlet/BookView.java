package hu.qwaevisz.library.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.library.domain.Book;
import hu.qwaevisz.library.domain.BookCategory;
import hu.qwaevisz.library.holder.Library;

@WebServlet("/Book")
public class BookView extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;

	private static final String PARAM_ISBN = "isbn";
	private static final String PARAM_EDIT_FLAG = "edit";
	private static final String PARAM_CATEGORY = "category";
	private static final String PARAM_PRICE = "price";
	private static final String PARAM_NUMBER_OF_PAGES = "numberofpages";
	private static final String PARAM_TITLE = "title";
	private static final String PARAM_AUTHOR = "author";

	private static final String ATTRIBUTE_BOOK = "book";

	private static final String TRUE_VALUE = "1";

	private static final String VIEW_PAGE = "book.jsp";
	private static final String EDIT_PAGE = "book-edit.jsp";

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter(PARAM_ISBN);
		final boolean editFlag = TRUE_VALUE.equals(request.getParameter(PARAM_EDIT_FLAG));
		final Book book = Library.getInstance().find(isbn);
		this.forward(request, response, editFlag, book);
	}

	private void forward(final HttpServletRequest request, final HttpServletResponse response, final boolean editFlag, final Book book)
			throws ServletException, IOException {
		request.setAttribute(ATTRIBUTE_BOOK, book);
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? EDIT_PAGE : VIEW_PAGE);
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter(PARAM_ISBN);
		final String author = request.getParameter(PARAM_AUTHOR);
		final String title = request.getParameter(PARAM_TITLE);
		final int numberOfPages = Integer.parseInt(request.getParameter(PARAM_NUMBER_OF_PAGES));
		final double price = Double.parseDouble(request.getParameter(PARAM_PRICE));
		final BookCategory category = BookCategory.valueOf(request.getParameter(PARAM_CATEGORY));

		final Book book = Library.getInstance().find(isbn);
		book.setAuthor(author);
		book.setTitle(title);
		book.setNumberOfPages(numberOfPages);
		book.setPrice(price);
		book.setCategory(category);
		this.forward(request, response, false, book);
	}

}
