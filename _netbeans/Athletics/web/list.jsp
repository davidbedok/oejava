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
            String action = request.getParameter("action");
            String error = "";
            List<Student> compareResult = new ArrayList<Student>();
            if ("compare".equals(action)) {

                Sex sex = Sex.valueOf(request.getParameter("sex"));
                String direction = request.getParameter("direction");
                Sport sport = Sport.valueOf(request.getParameter("sport"));
                Student student = StudentCatalog.getInstance().find(request.getParameter("student"));

                if (student.getResult(sport) != null) {
                    
                    compareResult = StudentCatalog.getInstance().compare(sex, direction, sport, student);
                    
                } else {
                    error = student.getName() + " hasn't got result in " + sport + ". The comparison is not possible.";
                }

            }


            List<Student> students = StudentCatalog.getInstance().getStudents();
        %>
        <h1>Students</h1>
        <% out.print(error);%>
        <table border="1">
            <thead>
                <tr>
                    <th>name</th>
                    <th>sex</th>
                    <th>birth date</th>
                    <th>result count</th>
                </tr>
            </thead>
            <tbody>
                <% if (students != null) {%>
                <% for (Student student : students) {%>
                <tr>
                    <td>
                        <a href="details.jsp?student=<% out.print(student.getName());%>"> 
                            <% if ( compareResult.contains(student) ) { out.print("<b>"); } %>
                                <% out.print(student.getName());%>
                            <% if ( compareResult.contains(student) ) { out.print("</b>"); } %>
                        </a>
                    </td>
                    <td><% out.print(student.getSex());%></td>
                    <td><% out.print(student.getBirthDate());%></td>
                    <td><% out.print(student.resultCount());%></td>
                </tr>
                <% }%>
                <% }%>
            </tbody>
        </table>
        <br/>
        <form action="details.jsp" method="POST">
            <fieldset>
                <legend>Details</legend>
                <table>
                    <tr>
                        <td>
                            <select name="student">
                                <% for (Student student : students) {%>
                                <option value="<% out.print(student.getName());%>"><% out.print(student.getName());%></option>
                                <% }%>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Go" /></td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <br/>
        <form action="list.jsp" method="POST">
            <input type="hidden" name="action" value="compare" />
            Who 
            <select name="sex">
                <option value="<% out.print(Sex.MAN);%>"><% out.print(Sex.MAN);%></option>
                <option value="<% out.print(Sex.WOMAN);%>"><% out.print(Sex.WOMAN);%></option>
            </select>
            <select name="direction">
                <option value="better">better</option>
                <option value="worse">worse</option>
            </select>
            in
            <select name="sport">
                <option value="<% out.print(Sport.FLAT_RACE);%>"><% out.print(Sport.FLAT_RACE);%></option>
                <option value="<% out.print(Sport.LONG_JUMP);%>"><% out.print(Sport.LONG_JUMP);%></option>
                <option value="<% out.print(Sport.SMALL_BALL_THROWING);%>"><% out.print(Sport.SMALL_BALL_THROWING);%></option>
            </select>
            than
            <select name="student">
                <% for (Student student : students) {%>
                <option value="<% out.print(student.getName());%>"><% out.print(student.getName());%></option>
                <% }%>
            </select>
            ?   
            <input type="submit" value="Go" />
        </form>
    </body>
</html>