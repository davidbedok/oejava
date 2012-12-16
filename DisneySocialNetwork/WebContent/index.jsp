<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/network.css" />
<title>:: Disney ::</title>
</head>
<body>
<jsp:include page="list.jsp">
 	<jsp:param name="memberUnid" value="-1" />
</jsp:include>
</body>
</html>