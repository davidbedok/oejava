<%@page session="true" %>
<%@page import="hu.qwaevisz.forum.common.LoginAttribute" %>
<%@page import="hu.qwaevisz.forum.common.LoginField" %>
<!DOCTYPE html>
<html>
<head>
<title>:: Login ::</title>
</head> 
<body>  
<h1>Login</h1>
<% String error = (String) request.getAttribute(LoginAttribute.ERROR); %>
<form action="login" method="POST">
	<fieldset>
		<legend>Login</legend>
		<table>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input id="name" name="<%= LoginField.NAME %>" type="text" value=""/></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input id="password" name="<%= LoginField.PASSWORD %>" type="password" value=""/></td>
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