<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="hu.qwaevisz.bookstore.domain.Book" %>
<% Book book = (Book) request.getAttribute("book"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: <%= book.getTitle() %> ::</title>
</head>
<body>
    <h1><%= book.getAuthor() %>: <%= book.getTitle() %></h1>
    <div><label>ISBN: </label><span><%= book.getIsbn() %></span></div>
    <div><label>Number of pages: </label><span><%= book.getNumberOfPages() %></span></div>
    <div><label>Price: </label><span><%= book.getPrice() %> Ft</span></div>
    <div><label>Category: </label><span><%= book.getCategory().getLabel() %></span></div>
    <br/><br/>
    <div>
        <a href="BookList">back</a>
        <a href="Book?isbn=<%= book.getIsbn() %>&edit=1">edit</a>
    </div>
</body>
</html>