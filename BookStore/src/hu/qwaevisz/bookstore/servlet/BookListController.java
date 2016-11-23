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
import hu.qwaevisz.bookstore.service.BookService;
import hu.qwaevisz.bookstore.service.BookServiceImpl;

@WebServlet("/BookList")
public class BookListController extends HttpServlet {

	private static final long serialVersionUID = -1977646750178615187L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceImpl.getInstance();
		List<Book> books = service.getBooks();
		request.setAttribute("books", books);
		request.setAttribute("category", "-1");
		final RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String category = request.getParameter("category");
		BookService service = BookServiceImpl.getInstance();
		List<Book> books = null;
		if ("-1".equals(category)) {
			books = service.getBooks();
		} else {
			books = service.getBooks(BookCategory.valueOf(category));
		}
		request.setAttribute("books", books);
		request.setAttribute("category", category);
		final RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);
	}

}
