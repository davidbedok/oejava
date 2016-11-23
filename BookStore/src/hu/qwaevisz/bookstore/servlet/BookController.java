package hu.qwaevisz.bookstore.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.bookstore.domain.Book;
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
			BookService service = BookServiceImpl.getInstance();
			Book book = service.getBook(isbn);
			if (book != null) {
				request.setAttribute("book", book);
				final RequestDispatcher view = request.getRequestDispatcher("book.jsp");
				view.forward(request, response);
			} else {
				response.sendRedirect("BookList");
			}
		}
	}

}
