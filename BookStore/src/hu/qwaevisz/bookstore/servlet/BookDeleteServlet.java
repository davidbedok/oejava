package hu.qwaevisz.bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.qwaevisz.bookstore.service.BookServiceImpl;
import hu.qwaevisz.bookstore.servlet.domain.Page;

@WebServlet("/" + Page.BOOKDELETE)
public class BookDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String isbn = request.getParameter("isbn");
		BookServiceImpl.getInstance().removeBook(isbn);
		response.sendRedirect(Page.BOOKLIST);
	}

}
