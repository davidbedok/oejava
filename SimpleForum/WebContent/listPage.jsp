<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="hu.qwaevisz.forum.holder.Forum" %>
<%@page import="hu.qwaevisz.forum.holder.ForumEntry" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>:: forum ::</title>
</head> 
<body>  
<%
	List<ForumEntry> posts = Forum.getInstance().getPosts();
%>
<h1>List forum entries</h1>
<table border="1">
	<thead>
		<tr>
			<th>nick</th>
			<th>message</th>
		</tr>
	</thead>
	<tbody>
	<% if (posts != null) { %>
		<% for ( ForumEntry entry : posts) { %>
			<tr>
				<td><% out.print(entry.getNick()); %></td>
				<td><% out.print(entry.getMessage()); %></td>
			</tr>
		<% } %>
	<% } %>
	</tbody>
</table>
<br/>
<% if ( session.getAttribute("username") != null ) { %>
	<form action="newentry" method="POST">
		<fieldset>
			<legend>New message</legend>
			<table>
				<tr>
					<td><textarea name="message"></textarea>
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