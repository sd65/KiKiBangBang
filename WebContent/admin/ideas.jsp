
<% String pageTitle="Ideas management page", userType="admin"; %>
<%@include file="../partials/header.jsp"%>
<%@page import="bean.Idea"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	Object obj = request.getAttribute("ideaList");
%>

<table id="demo-foo-filtering"
	class="table table-striped toggle-circle m-b-0" data-page-size="7">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Creation date</th>
			<th>Funds required</th>
			<th>Short description</th>
			<th>Phase</th>
			<th>Actions</th>
		</tr>
	</thead>
	<div class="form-inline m-b-20">
		<div class="row">
			<div class="col-sm-6 text-xs-center">
				<div class="form-group">
					<label class="control-label m-r-5">Phases</label> <select
						id="demo-foo-filter-status" class="form-control input-sm">
						<option value="">Show all</option>
						<option value="Discussion">Discussion</option>
						<option value="Production">Production</option>
						<option value="Funding">Funding</option>
						<option value="Redaction">Redaction</option>
						<option value="Proposal">Proposal</option>
					</select>
				</div>
			</div>
			<div class="col-sm-6 text-xs-center text-right">
				<div class="form-group">
					<input id="demo-foo-search" type="text" placeholder="Search"
						class="form-control input-sm" autocomplete="on">
				</div>
			</div>
		</div>
	</div>
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
			<td class="actions">
	            <a href="#" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
        	</td>

		</tr>
		
		<%
			}
			}
		%>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">
				<div class="text-right">
					<ul class="pagination pagination-split m-t-30 m-b-0"></ul>
				</div>
			</td>
		</tr>
	</tfoot>
</table>

	<!--Footable-->
		<link href="assets/plugins/footable/css/footable.core.css" rel="stylesheet">
		<link href="assets/plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
		<!--FooTable-->
		<script src="assets/plugins/footable/js/footable.all.min.js"></script>
		
		<script src="assets/plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>

		<!--FooTable Example-->
		<script src="assets/pages/jquery.footable.js"></script>
<jsp:include page="../partials/footer.jsp" />
