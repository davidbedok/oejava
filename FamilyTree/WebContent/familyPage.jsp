<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hu.qwaevisz.familytree.*" %>   
<%@ page import="javax.servlet.jsp.JspWriter" %>  
<%@page import="java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/family.css" />
<%! 
	int convertParameter( String paramStr, int defaultValue, JspWriter out ) throws IOException {
		int result = defaultValue;
		if ( paramStr != null ) {
			try {
				result = Integer.parseInt(paramStr);
			} catch ( NumberFormatException e) {
				out.println(e.getMessage());
			}
		}
		return result;
	}
%>
<%
	int memberUnid = convertParameter(request.getParameter("unid"), 10, out);
	Person person = FamilyTree.getInstance().find(memberUnid);
%>
<title>:: <% out.print(person.getName()); %> ::</title>
</head>
<body>
<h1><% out.print(person.getName()); %></h1>
<hr/>
<div>
	<label>Gender: </label><span><% out.print(person.getGender().getLabel()); %></span>
</div>
<div>
	<label>Age: </label><span><% out.print(person.getAge()); %></span>
</div> 
<div>
	<label>Birth: </label><span><% out.print(person.getBirthYear()); %></span>
</div>
<% if ( person.getDeathYear() != null ) { %>
	<div>
		<label>Death: </label><span><% out.print(person.getDeathYear()); %></span>
	</div>
<% } %>
<% if ( person.getMother() != null ) { %>
	<div>
		<label>Mother: </label><a href="familyPage.jsp?unid=<%= person.getMother().getUnid() %>"><% out.print(person.getMother().getName()); %></a>
	</div> 
<% } %>
<% if ( person.getFather() != null ) { %>
	<div>
		<label>Father: </label><a href="familyPage.jsp?unid=<% out.print(person.getFather().getUnid()); %>"><% out.print(person.getFather().getName()); %></a>
	</div>
<% } %>
<% if ( !person.getChildren().isEmpty() ) { %>
	<br/>
	<div>Child/Children</div>
	<table class="childrentable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<% for ( Person child : person.getChildren()) { %>
				<tr>
					<td><a href="familyPage.jsp?unid=<% out.print(child.getUnid()); %>"><% out.print(child.getName()); %></a></td>
					<td><% out.print(child.getAge()); %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
<% } %>
</body>
</html>