<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="hu.qwaevisz.disney.service.SocialNetwork" %>  
<%@page import="hu.qwaevisz.disney.model.Member" %>    
<%@page import="hu.qwaevisz.disney.model.Phone" %>  
<%@ page import="javax.servlet.jsp.JspWriter" %>  
<%@page import="java.io.IOException"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/network.css" />
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
	Member member = SocialNetwork.getInstance().find(memberUnid);
%>
<title>:: <% out.print(member.getName()); %> ::</title>
</head>
<body>
<table class="member">
	<tr>
		<td>
			<img src="images/<% out.print(member.getImage()); %>" />
		</td>
		<td>
			<table>
				<tr>
					<td><strong><% out.print(member.getName()); %></strong><br/></td>
				</tr>
				<tr>
					<td><em>in <% out.print(member.getMovie()); %></em></td>
				</tr>
				<tr>
					<td>
						<% if (!member.getPhones().isEmpty()) { %>
						<ul>
							<% for ( Phone phone : member.getPhones()) { %>
								<li><%= phone.getNumber() %> (<b><%= phone.getType().getLabel() %></b>)</li>
							<% } %>
						</ul>
						<% } else { %>
						<span>no phone</span>
						<% } %>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<jsp:include page="list.jsp">
			 	<jsp:param name="memberUnid" value="<%= member.getUnid() %>" />
			</jsp:include>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="index.jsp">back</a>
		</td>
	</tr>
</table>
</body>
</html>