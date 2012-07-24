<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" type="text/javascript" src="js/ajax.js"></script>
<script type="text/javascript" src="syntaxhighlighter_3.0.83/scripts/shCore.js"></script>
<script type="text/javascript" src="syntaxhighlighter_3.0.83/scripts/shBrushXml.js"></script>
<link type="text/css" rel="stylesheet" href="syntaxhighlighter_3.0.83/styles/shCoreDefault.css"/>
<script type="text/javascript">SyntaxHighlighter.all();</script>
<title>Insert title here</title>

<script type="text/javascript">
	function cb_ajaxText(value, param) {
		if (typeof (value) != 'undefined') {
			document.getElementById('ajaxresult').innerHTML = value;
			document.getElementById('callbacksource').innerHTML = value;
			if (typeof (param) != 'undefined') {
				document.getElementById('callbackparam').innerHTML = param;
			}
			SyntaxHighlighter.all();
		}
	}

	function tl_ajaxTest(id) {
		var url = 'AjaxServlet?q=1';
		url += '&param1='
				+ encodeURIComponent(document.getElementById('formfield1id').value);
		ajaxpage(url, 'cbf', cb_ajaxText, id);
	}
</script>

</head>
<body>
	<form name="testform" id="testformid">
		<label for="formfield1id">formfield1:</label> <input type="text"
			name="formfield1" id="formfield1id" value="alma" /> <input
			type="button" value="ajaxsend" onclick="tl_ajaxTest(123);" />
	</form>
	<div id="ajaxresult">no ajax result</div>
	<br />
	<br />
	<br />
	<div id="callbackparam">no call back param</div>
	<br />
	<pre id="callbacksource" class="brush: xml">
		 <?xml version="1.0" encoding="UTF-8"?>
<web-app id="FirstServletDemoID" version="2.4"
	xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<display-name>FirstServletDemo</display-name>
	<servlet>
		<description></description>
		<display-name>GreetingAgain</display-name>
		<servlet-name>GreetingAgain</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.GreetingAgain</servlet-class>
		<init-param>
			<param-name>name</param-name>
			<param-value>stranger</param-value>
		</init-param>
	</servlet>
	<servlet>
		<description></description>
		<display-name>GreetingWithHtml</display-name>
		<servlet-name>GreetingWithHtml</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.GreetingWithHtml</servlet-class>
	</servlet>
	<servlet>
		<description></description>
		<display-name>Login</display-name>
		<servlet-name>Login</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.Login</servlet-class>
	</servlet>
	<servlet>
		<description></description>
		<display-name>Work</display-name>
		<servlet-name>Work</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.Work</servlet-class>
	</servlet>
	<servlet>
		<description></description>
		<display-name>Logout</display-name>
		<servlet-name>Logout</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.Logout</servlet-class>
	</servlet>
	<servlet>
		<description></description>
		<display-name>AjaxServlet</display-name>
		<servlet-name>AjaxServlet</servlet-name>
		<servlet-class>hu.qwaevisz.servlet.AjaxServlet</servlet-class>
	</servlet>	
	<servlet-mapping>
		<servlet-name>GreetingAgain</servlet-name>
		<url-pattern>/GreetingAgain</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>GreetingWithHtml</servlet-name>
		<url-pattern>/GreetingWithHtml</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>Login</servlet-name>
		<url-pattern>/Login</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>Work</servlet-name>
		<url-pattern>/Work</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>Logout</servlet-name>
		<url-pattern>/Logout</url-pattern>
	</servlet-mapping>
	<servlet-mapping>
		<servlet-name>AjaxServlet</servlet-name>
		<url-pattern>/AjaxServlet</url-pattern>
	</servlet-mapping>
</web-app>
	</pre>
</body>
</html>