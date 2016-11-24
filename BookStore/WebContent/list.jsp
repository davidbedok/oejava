<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<%@ page import="hu.qwaevisz.bookstore.domain.BookCategory" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Books ::</title>
</head>
<body>
	<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
    <h1>List of Books</h1> 
	<form method="post" action="BookList">
		<div>
			<label for="category">Category: </label>
			<select name="category" id="category">
			    <% String categoryName = (String) request.getAttribute("category"); %>
				<option value="-1" <% out.print( "-1".equals(categoryName) ? "selected=\"selected\"" : "" ); %>>-</option>
			    <% for ( BookCategory category : BookCategory.values() ) { %>
					<option value="<%= category.name() %>" <%= category.name().equals(categoryName) ? "selected=\"selected\"" : "" %>>
						<%= category.getLabel() %>
					</option>
				<% } %>
			</select>
			<input type="submit" value="Filter" />
		</div>
	</form>
	<br/><br/><br/>    
    <table class="bookstable">
        <thead>
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Category</th>
                <th>Price</th>
                <th>Number of pages</th>
                <th>&nbsp;</th>
            </tr>
        </thead>
        <tbody>
            <% for ( Book book : books ) { %>
                <tr>
                    <td><%= book.getAuthor() %></td>
                    <td><a href="Book?isbn=<%= book.getIsbn() %>"><%= book.getTitle() %></a></td>
                    <td><%= book.getCategory().getLabel() %></td>
                    <td><%= book.getPrice() %> Ft</td>
                    <td><%= book.getNumberOfPages() %></td>
                    <td><a href="BookDelete?isbn=<%= book.getIsbn() %>">delete</a></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <br/><br/>
	<div>
	    <a href="Book?isbn=-1&edit=1">Create</a> a brand new book.
	</div>
</body>
</html>