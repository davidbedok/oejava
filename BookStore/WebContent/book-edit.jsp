<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<%@ page import="hu.qwaevisz.bookstore.domain.BookCategory" %>
<% 
	Book book = (Book) request.getAttribute("book"); 
	boolean isNew = (Boolean) request.getAttribute("new"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Edit ::</title>
</head>
<body>
	<div class="frame">
		<form method="post" action="Book">
			<div>
				<input class="inputheader" type="text" name="author" value="<%= book.getAuthor() %>" />:
				<input class="inputheader" type="text" name="title" value="<%= book.getTitle() %>" />
				<br/><br/>
			</div>
			<div>
				<label>ISBN: </label>
				<% if ( isNew ) {  %>     
					<input type="text" name="isbn" value="" />
                <% } else { %>
                    <span><%= book.getIsbn() %></span>
                    <input type="hidden" name="isbn" value="<%= book.getIsbn() %>" />
                <% } %>
			</div>
			<div>
				<label for="numberofpages">Number of pages: </label>
				<input type="number" name="numberofpages" id="numberofpages" value="<%= book.getNumberOfPages() %>" />
			</div>
			<div>
				<label for="price">Price: </label>
				<input type="number" name="price" id="price" value="<%= book.getPrice() %>" /> Ft
			</div>
			<div>
				<label for="category">Category: </label>
				<select name="category" id="category">
					<% for ( BookCategory category : BookCategory.values()) { %>
						<option value="<%= category.name() %>" <%= category == book.getCategory() ? "selected=\"selected\"" : "" %> ><%= category.getLabel() %></option>
					<% } %>
				</select>
			</div>
			<br/><br/>
			<div>
				<input type="submit" value="Save" />&nbsp;
				<a href="Book?isbn=<%= book.getIsbn() %>">cancel</a>
			</div>
		</form>
	</div>
</body>
</html>