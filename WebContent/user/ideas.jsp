
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
			<th>Creation date</th>
			<th>Funds required</th>
			<th>Short description</th>
		</tr>
	</thead>
	<tbody>
		<%
			if (obj != null) {
				List<Idea> li = (List<Idea>) obj;
				for (Idea i : li) {
		%>
		<tr>
			<td><%=i.getName()%></td>
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

		</tr>
		<%
			}
			}
		%>
	</tbody>
</table>

<jsp:include page="../partials/footer.jsp" />
