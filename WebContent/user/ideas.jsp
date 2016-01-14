
<%
	String pageTitle = "Ideas", userType = "user";
%>
<%@include file="../partials/header.jsp"%>

<%@page import="bean.Idea"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
	Object obj = request.getAttribute("ideaList");
%>


<table class="table table-striped" id="datatable-editable">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Creation date</th>
			<th>Funds required</th>
			<th>Short description</th>
			<th>Phase</th>
		</tr>
	</thead>
	<tbody>
		<%
			if (obj != null) {
				List<Idea> li = (List<Idea>) obj;
				for (Idea i : li) {
		%>
		<tr>
		
			<td><a href="user/idea?id=<%=i.getId()%>"><%=i.getName()%></a></td>
			<td><%=i.getProposer().getFirstName()%> <%=i.getProposer().getFamilyName()%></td>
			<td>
				<%
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							out.print(formatter.format(i.getCreationDate()));
				%>
			</td>
			<td><%=i.getFundsRequired()%></td>
			<td>
				<%
					out.print(i.getShortDescription());
				%>
			</td>
			<td><%=i.getStepName()%></td>

		</tr>
		
		<%
			}
			}
		%>
	</tbody>
</table>

<jsp:include page="../partials/footer.jsp" />
