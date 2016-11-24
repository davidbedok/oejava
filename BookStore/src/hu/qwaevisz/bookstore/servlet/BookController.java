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
import hu.qwaevisz.bookstore.service.BookService;
import hu.qwaevisz.bookstore.service.BookServiceImpl;

@WebServlet("/Book")
public class BookController extends HttpServlet {

	private static final long serialVersionUID = -4068275526750462197L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter("isbn");
		if (isbn == null || "".equals(isbn)) {
			response.sendRedirect("BookList");
		} else {
			Book book = null;
			boolean isNew = false;
			if ("-1".equals(isbn)) {
				book = new Book("-1", "", "", 0, 0, BookCategory.HISTORICAL);
				isNew = true;
			} else {
				BookService service = BookServiceImpl.getInstance();
				book = service.getBook(isbn);
			}
			if (book != null) {
				request.setAttribute("book", book);
				request.setAttribute("new", isNew);
				final boolean editFlag = "1".equals(request.getParameter("edit"));
				final RequestDispatcher view = request.getRequestDispatcher(editFlag ? "book-edit.jsp" : "book.jsp");
				view.forward(request, response);
			} else {
				response.sendRedirect("BookList");
			}
		}
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceImpl.getInstance();

		final String isbn = request.getParameter("isbn");
		final String author = request.getParameter("author");
		final String title = request.getParameter("title");
		final int numberOfPages = Integer.parseInt(request.getParameter("numberofpages"));
		final double price = Double.parseDouble(request.getParameter("price"));
		final BookCategory category = BookCategory.valueOf(request.getParameter("category"));
		Book book = service.saveBook(isbn, author, title, numberOfPages, price, category);

		request.setAttribute("book", book);
		request.setAttribute("new", false);
		final boolean editFlag = "1".equals(request.getParameter("edit"));
		final RequestDispatcher view = request.getRequestDispatcher(editFlag ? "book-edit.jsp" : "book.jsp");
		view.forward(request, response);
	}

}
