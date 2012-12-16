<%@page import="java.util.Set" %>
<%@page import="hu.qwaevisz.disney.service.SocialNetwork" %>  
<%@page import="hu.qwaevisz.disney.model.Member" %>
<%
	int memberUnid = Integer.parseInt( request.getParameter("memberUnid") );

	Set<Member> members = null;
	if ( memberUnid == -1 ) {
		members = SocialNetwork.getInstance().getMembers();
	} else {
		members = SocialNetwork.getInstance().find(memberUnid).getFriends();
	}
%>
<table class="networktable">
	<thead>
		<tr>
			<th>Name</th>
			<th>Movie</th>
		</tr>
	</thead>
	<tbody>
		<% if (members != null) { %>
			<% for ( Member member : members) { %>
				<tr>
					<td><a href="member.jsp?unid=<% out.print(member.getUnid()); %>"><% out.print(member.getName()); %></a></td>
					<td><% out.print(member.getMovie()); %></td>
				</tr>
			<% } %>
		<% } %>
	</tbody>
</table>