<%@page import="java.io.IOException"%>
<%@ page import="javax.servlet.jsp.JspWriter" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/calculator.css" />
<title>calculator</title>
</head>
<body>  
<!-- Tomcat 7 (calc.war) -->
<!-- http://localhost:8080/calc/ -->
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

	double calcResult(int operandLeft, String operation, int operandRight ) { 
		double result = 0;
		if ( operation.equals("summation") ) {
			result = operandLeft + operandRight;
		} else if ( operation.equals("subtraction") ) {
			result = operandLeft - operandRight;
		} else if ( operation.equals("multiplication") ) {
			result = operandLeft * operandRight;
		} else if ( operation.equals("division") ) {
			if ( operandRight != 0 ) {
				result = (double)operandLeft / operandRight;
			}
		}
		return result;
	}
%>
<%
	int operandLeft = convertParameter(request.getParameter("operandleft"), 20, out);
	int operandRight = convertParameter(request.getParameter("operandright"), 22, out);
	String operation = request.getParameter("operation");
	if ( operation == null ) {
		operation = "summation";
	}
	double result = calcResult(operandLeft, operation, operandRight);
%>
<h1>Simple calculator web application</h1>
<form id="calcformid" name="calcform" action="index.jsp" method="get">
	<fieldset>
		<legend>Operands</legend>
		<table id="outer">
			<tr>
				<td>
					<table id="inner">
						<tr>
							<td><input name="operandleft" type="number" value="<%= operandLeft %>" /></td>
							<td>
								<select name="operation">
									<option value="summation" <% if ( operation.equals("summation") ) { out.print("selected=\"selected\""); } %>>+</option>
									<option value="subtraction" <% if ( operation.equals("subtraction") ) { out.print("selected=\"selected\""); } %>>-</option>
									<option value="multiplication" <% if ( operation.equals("multiplication") ) { out.print("selected=\"selected\""); } %>>*</option>
									<option value="division" <% if ( operation.equals("division") ) { out.print("selected=\"selected\""); } %>>/</option>
								</select>			
							</td>
							<td><input name="operandright" type="number" value="<%= operandRight %>" /></td>
							<td>=</td>
							<td><%= result %></td>
						</tr>
						<tr>
							<td colspan="5">
								<input type="submit" value="Calculate">
							</td>
						</tr>
					</table>				
				</td>
				<td class="toright">
					<img id="calcimg" src="images/calculator.png" alt="calculator web application" />
				</td>
			</tr>
		</table>
	</fieldset>
</form>
</body>
</html>