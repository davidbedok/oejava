package hu.qwaevisz.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.bookstore.domain.Book;
import hu.qwaevisz.bookstore.domain.BookCategory;
import hu.qwaevisz.bookstore.service.BookServiceImpl;
import hu.qwaevisz.bookstore.servlet.domain.Page;
import hu.qwaevisz.bookstore.servlet.domain.View;

@WebServlet("/" + Page.BOOK)
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter("isbn");
		if (isbn == null || "".equals(isbn)) {
			response.sendRedirect(Page.BOOKLIST);
		} else {
			Book book = null;
			boolean isNew = false;
			if ("-1".equals(isbn)) {
				book = new Book("-1", "", "", 0, 0, BookCategory.HISTORICAL);
				isNew = true;
			} else {
				book = BookServiceImpl.getInstance().getBook(isbn);
			}
			if (book != null) {
				final boolean editFlag = "1".equals(request.getParameter("edit"));
				this.forward(request, response, book, isNew, editFlag);
			} else {
				response.sendRedirect(Page.BOOKLIST);
			}
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, Book book, boolean isNew, boolean editFlag)
			throws ServletException, IOException {
		request.setAttribute("book", book);
		request.setAttribute("isnew", isNew);
		final RequestDispatcher view = request.getRequestDispatcher(View.BOOK.getPage(editFlag));
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter("isbn");
		final String author = request.getParameter("author");
		final String title = request.getParameter("title");
		final int numberOfPages = Integer.parseInt(request.getParameter("numberofpages"));
		final double price = Double.parseDouble(request.getParameter("price"));
		final BookCategory category = BookCategory.valueOf(request.getParameter("category"));
		Book book = BookServiceImpl.getInstance().saveBook(isbn, author, title, numberOfPages, price, category);
		this.forward(request, response, book, false, false);
	}

}
