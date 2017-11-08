package hu.qwaevisz.bookstore.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/" + Page.BOOKLIST)
public class BookListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = BookServiceImpl.getInstance().getBooks();
		this.forward(request, response, books, "-1");
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, List<Book> books, String category) throws ServletException, IOException {
		request.setAttribute("books", books);
		request.setAttribute("category", category);
		final RequestDispatcher view = request.getRequestDispatcher(View.LIST.getPage());
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String category = request.getParameter("category");
		List<Book> books = null;
		if ("-1".equals(category)) {
			books = BookServiceImpl.getInstance().getBooks();
		} else {
			books = BookServiceImpl.getInstance().getBooks(BookCategory.valueOf(category));
		}
		this.forward(request, response, books, category);
	}

}
