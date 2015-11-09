<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.qwaevisz.library.domain.Book" %> 
<%@ page import="hu.qwaevisz.library.domain.BookCategory" %> 
<% 
	List<Book> books = (List<Book>) request.getAttribute("books"); 
	String categoryName = (String) request.getAttribute("category");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Books ::</title>
</head>
<body>
	<h1>List of Books</h1>
	<form method="post" action="BookList">
		<div>
			<label for="category">Category: </label>
			<select name="category" id="category">
				<option value="-1">-</option>
				<% for ( BookCategory category : BookCategory.values()) { %>
					<option value="<% out.print(category.name()); %>" <% out.print( category.name().equals(categoryName) ? "selected=\"selected\"" : "" ); %> ><% out.print(category.getLabel()); %></option>
				<% } %>
			</select>	
			<input type="submit" value="Filter" />
		</div>
	</form>
	<br/><br/><br/>
	<% if ( books.isEmpty() ) { %>
		<span>Book list is <strong>empty</strong>.</span>
	<% } else { %>
		<table class="bookstable">
			<thead>
				<tr>
					<th>Author</th>
					<th>Title</th>
					<th>Category</th>
					<th>Price</th>
					<th>Number of pages</th>
				</tr>
			</thead>
			<tbody>
				
				<% for ( Book book : books) { %>
					<tr>
						<td><% out.print(book.getAuthor()); %></td>
						<td><a href="Book?isbn=<% out.print(book.getIsbn()); %>"><% out.print(book.getTitle()); %></a></td>
						<td><% out.print(book.getCategory().getLabel()); %></td>
						<td><% out.print(book.getPrice()); %> Ft</td>
						<td><% out.print(book.getNumberOfPages()); %></td>
					</tr>
				<% } %>
			</tbody>
		</table>
	<% } %>
</body>
</html>