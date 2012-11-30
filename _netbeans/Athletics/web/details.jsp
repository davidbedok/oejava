<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="hu.qwaevisz.athletics.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>:: Athletics ::</title>
    </head> 
    <body>  
        <%
            String studentName = request.getParameter("student");
            Student student = StudentCatalog.getInstance().find(studentName);
        %>
        <h1><% out.print(student.getName());%></h1>
        <table border="1">
            <tr>
                <td><b>Sex</b></td>
                <td><% out.print(student.getSex());%></td>
            </tr>
            <tr>
                <td><b>Date of birth</b></td>
                <td><% out.print(student.getBirthDate());%></td>
            </tr>
        </table>
        <% if (student.resultCount() > 0) {%>
        <br/>
        <table border="1">
            <thead>
                <tr>
                    <th>sport</th>
                    <th>result</th>
                </tr>
            </thead>
            <tbody>
                <% for (Sport sport : student.sports()) {%>
                <tr>
                    <td><% out.print(sport);%></td>
                    <td><% out.print(student.getResult(sport));%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
        <% }%>
        <br/>
        <a href="list.jsp">back</a>
    </body>
</html>