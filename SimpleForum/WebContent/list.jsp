<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="hu.qwaevisz.forum.holder.Forum" %>
<%@page import="hu.qwaevisz.forum.holder.ForumEntry" %>
<%@page import="hu.qwaevisz.forum.common.ListAttribute" %>
<%@page import="hu.qwaevisz.forum.common.ListField" %>
<%@page import="hu.qwaevisz.forum.common.SessionAttribute" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>:: Forum ::</title>
</head> 
<body>  
<% List<ForumEntry> entries = (List<ForumEntry>) request.getAttribute(ListAttribute.ENTRIES); %>
<h1>List forum entries</h1>
<table border="1">
	<thead>
		<tr>
			<th>nick</th>
			<th>message</th>
		</tr>
	</thead>
	<tbody>
	<% if (entries != null) { %>
		<% for ( ForumEntry entry : entries) { %>
			<tr>
				<td><% out.print(entry.getNick()); %></td>
				<td><% out.print(entry.getMessage()); %></td>
			</tr>
		<% } %>
	<% } %>
	</tbody>
</table>
<br/>
<% if ( session.getAttribute(SessionAttribute.USER) != null ) { %>
	<form action="list" method="POST">
		<fieldset>
			<legend>New message</legend>
			<table>
				<tr>
					<td><textarea name="<%= ListField.ENTRY %>"></textarea>
				</tr>
				<tr>
					<td><input type="submit" value="Send" /></td>
				</tr>
				<tr>
					<td><a href="logout">logout</a></td>
				</tr>
			</table>
		</fieldset>
	</form>
<% } else { %>
	Go to <a href="login">login</a> page!
<% } %>
</body>
</html>