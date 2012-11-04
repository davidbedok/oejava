<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>:: forum ::</title>
</head> 
<body>  
<h1>Login</h1>
<%
	String error = (String)session.getAttribute("error");
%>
<form action="login" method="POST">
	<fieldset>
		<legend>New message</legend>
		<table>
			<tr>
				<td><label for="nameid">Name:</label></td>
				<td><input id="nameid" name="name" type="text" value=""/></td>
			</tr>
			<tr>
				<td><label for="passwordid">Password:</label></td>
				<td><input id="passwordid" name="password" type="password" value=""/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</fieldset>
</form>
<% if ( error != null) { %>
	<b><%= error %></b>
<% } %>
</body>
</html>