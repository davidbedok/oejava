<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: ${requestScope.book.title} (el) ::</title>
<fmt:setLocale value="hu_HU"/>
</head>
<body>
    <h1>${requestScope.book.author}: ${requestScope.book.title}</h1>
    <div><label>ISBN: </label><span>${requestScope.book.isbn}</span></div>
    <div><label>Category: </label><span>${requestScope.disk.category.label}</span></div>
    <div><label>Price: </label><span><fmt:formatNumber type="currency" value="${requestScope.book.price}" /></span></div>
    <div><label>Number of pages: </label><span>${requestScope.book.numberOfPages}</span></div>
    <br/><br/>
    <div> 
        <a href="BookList">back</a>
        <a href="Book?isbn=${requestScope.book.isbn}&edit=1">edit</a>
    </div>
</body>
</html>