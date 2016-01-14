
<% String pageTitle="My ideas", userType="user"; %>
<%@include file="../partials/header.jsp"%>

<%@page import="bean.Idea"%>
<%@page import="java.util.List"%>

<%
out.println("obj1");
	Object obj = request.getAttribute("ideaList");
	
	if(obj!=null){
 		out.println("beofre");
 		List<Idea> li = (List<Idea>)obj;
 		out.println("list");
 		for(Idea i : li){
 			out.println(i.getName());
		}
	}
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
		<tr>
			<td>Firstname</td>
			<td>Familly Name</td>
			<td>Email</td>
			<td>Address</td>
			<td class="actions"><a href="#"
				class="hidden on-editing save-row"><i class="fa fa-save"></i></a> <a
				href="#" class="hidden on-editing cancel-row"><i
					class="fa fa-times"></i></a> <a href="#" class="on-default edit-row"><i
					class="fa fa-pencil"></i></a> <a href="#" class="on-default remove-row"><i
					class="fa fa-trash-o"></i></a></td>
		</tr>
	</tbody>
</table>

<jsp:include page="../partials/footer.jsp" />
