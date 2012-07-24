<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		// This is a scriptlet.  Notice that the "date"
		// variable we declare here is available in the
		// embedded expression later on.
		System.out.println("Evaluating date now");
		java.util.Date date = new java.util.Date();
	%>

	Hello! The time is now
	<%=new java.util.Date()%><br /> Hello! The time is now
	<%=date%>
	Hello! The time is now
	<%
		// This scriptlet generates HTML output
		out.println(String.valueOf(date));
	%>
	<TABLE BORDER=2>
		<%
			for (int i = 0; i < 10; i++) {
		%>
		<TR>
			<TD>Number</TD>
			<TD><%=i + 1%></TD>
		</TR>
		<%
			}
		%>
	</TABLE>

	<br />
	<br /> Going to include hello.jsp...
	<BR>
	<%@ include file="inc.jsp"%>

	<br />
	<br /> JSP Declarations
	<br />
	<%! //The date will be the same, no matter how often you reload the page.  This is because these are declarations, and will only be evaluated once when the page is loaded!
	Date theDate = new Date();

	Date getDate() {
		System.out.println("In getDate() method");
		return theDate;
	}%>
	Hello! The time is now
	<%=getDate()%>

</body>
</html>