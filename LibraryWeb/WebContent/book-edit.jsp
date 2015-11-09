<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.qwaevisz.library.domain.Book" %> 
<%@ page import="hu.qwaevisz.library.domain.BookCategory" %> 
<% Book book = (Book) request.getAttribute("book"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Edit book ::</title>
</head>
<body>
	<div class="frame">
		<form method="post" action="Book">
			<div>
				<input class="inputheader" type="text" name="author" value="<% out.print(book.getAuthor()); %>" />: 
				<input class="inputheader" type="text" name="title" value="<% out.print(book.getTitle()); %>" />
				<br/><br/>
			</div>
			<div>
				<label>ISBN: </label>
				<span><% out.print(book.getIsbn()); %></span>
				<input type="hidden" name="isbn" value="<%= book.getIsbn() %>" />
			</div>
			<div>
				<label for="numberofpages">Number of pages: </label>
				<input type="number" name="numberofpages" id="numberofpages" value="<% out.print(book.getNumberOfPages()); %>" />
			</div>
			<div>
				<label for="price">Price: </label>
				<input type="number" name="price" id="price" value="<% out.print(book.getPrice()); %>" /> Ft
			</div>
			<div>
				<label for="category">Category: </label>
				<select name="category" id="category">
					<% for ( BookCategory category : BookCategory.values()) { %>
						<option value="<% out.print(category.name()); %>" <% out.print( category == book.getCategory() ? "selected=\"selected\"" : "" ); %> ><% out.print(category.getLabel()); %></option>
					<% } %>
				</select>
			</div>	
			<br/><br/>
			<div>
				<input type="submit" value="Save" />&nbsp;
				<a href="Book?isbn=<% out.print(book.getIsbn()); %>">cancel</a>
			</div>
		</form>
	</div>
</body>
</html>