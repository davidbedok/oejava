<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<HTML>
<BODY>
<%
    System.out.println( "Evaluating date now" );
    Date date2 = new Date();
%>
Hello!  The time is now <%= date2 %>
</BODY>
</HTML>