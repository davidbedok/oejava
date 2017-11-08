<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<%@ page import="hu.qwaevisz.bookstore.domain.BookCategory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Books (el) ::</title>
<fmt:setLocale value="hu_HU"/>
</head>
<body>
	<h1>List of Books</h1> 
	<form method="post" action="BookList">
		<div>
			<label for="category">Category: </label>
			<select name="category" id="category">
				<option value="-1" ${"-1" eq requestScope.category ? "selected=\"selected\"" : ""}>-</option>
				<c:forEach items="<%= BookCategory.values() %>" var="category">
					<option value="${category.name}" ${category.name eq requestScope.category ? "selected=\"selected\"" : ""}>${category.name}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Filter" />
		</div>
	</form>
	<br/>
	<c:choose>
	    <c:when test="${requestScope.books.isEmpty()}">
            <span>Book list is <strong>empty</strong>.</span>
        </c:when>
        <c:otherwise>
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
                    <c:forEach items="${requestScope.books}" var="book">
                        <tr>
                            <td>${book.author}</td>
                            <td><a href="Book?isbn=${book.isbn}">${book.title}</a></td>
                            <td>${book.category.label}</td>
                            <td><fmt:formatNumber type="currency" value="${book.price}" /></td>
                            <td>${book.numberOfPages}</td>
                            <td><a href="BookDelete?isbn=${book.isbn}">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
	</c:choose>	
    <br/>
	<div>
	    <a href="Book?isbn=-1&edit=1">Create</a> a brand new book.
	</div>
</body>
</html>