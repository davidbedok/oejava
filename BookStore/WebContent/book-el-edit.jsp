<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<%@ page import="hu.qwaevisz.bookstore.domain.BookCategory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Edit (el) ::</title>
</head>
<body>
	<div class="frame">
		<form method="post" action="Book">
			<div>
				<input class="inputheader" type="text" name="author" value="${requestScope.book.author}" />:
				<input class="inputheader" type="text" name="title" value="${requestScope.book.title}" />
				<br/><br/>
			</div>
			<div>
				<label>ISBN: </label>
				<c:choose>
                     <c:when test="${requestScope.isnew}">
                        <input type="text" name="isbn" value="" />
                     </c:when>
                     <c:otherwise>
                        <span>${requestScope.book.isbn}</span>
                        <input type="hidden" name="isbn" value="${requestScope.book.isbn}" />
                     </c:otherwise>
                </c:choose>				
			</div>
			<div>
				<label for="category">Category: </label>
				<select name="category" id="category">
					<c:forEach items="<%= BookCategory.values() %>" var="category">
						<option value="${category.name}" ${category eq requestScope.book.category ? "selected=\"selected\"" : ""}>${category.name}</option>
					</c:forEach>					
				</select>
			</div>			
			<div>
				<label for="price">Price: </label>
				<input type="number" name="price" id="price" value="${requestScope.book.price}" /> Ft
			</div>
			<div>
				<label for="numberofpages">Number of pages: </label>
				<input type="number" name="numberofpages" id="numberofpages" value="${requestScope.book.numberOfPages}" />
			</div>			
			<br/><br/>
			<div>
				<input type="submit" value="Save" />&nbsp;
				<c:choose>
                     <c:when test="${requestScope.isnew}">
                        <a href="BookList">cancel</a>
                     </c:when>
                     <c:otherwise>
                        <a href="Book?isbn=${requestScope.book.isbn}">cancel</a>
                     </c:otherwise>
                </c:choose>
			</div>
		</form>
	</div>
</body>
</html>