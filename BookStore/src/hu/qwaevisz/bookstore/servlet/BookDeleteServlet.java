package hu.qwaevisz.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.bookstore.service.BookService;
import hu.qwaevisz.bookstore.service.BookServiceImpl;

@WebServlet("/BookDelete")
public class BookDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 74534137280934999L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter("isbn");
		BookService service = BookServiceImpl.getInstance();
		service.removeBook(isbn);
		response.sendRedirect("BookList");
	}

}
