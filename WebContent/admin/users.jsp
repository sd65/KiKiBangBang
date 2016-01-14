<% String pageTitle="Users management page", userType="admin"; %>
<%@include file="../partials/header.jsp"%>
 <%@page import="bean.User"%>
 <%@page import="bean.NormalUser"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	Object obj = request.getAttribute("usersList");
	
	
%>
<table class="table table-striped" id="datatable-editable">
<thead>
    <tr>
        <th>Firstname</th>
        <th>Familly Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Creation Date</th>
        <th>Actions</th>
    </tr>
</thead>
<tbody>
<% 
		if(obj!=null){
 		List<NormalUser> li = (List<NormalUser>)obj;
 		for(User u : li){
	
	%>
    <tr>
        <td><%= u.getFirstName() %> </td>
        <td><%= u.getFamilyName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getAddress() %></td>
        <td><%= u.getTelephone() %></td>
        <td><% SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); out.print(formatter.format(u.getCreationDate()) ); %> </td>
        <td class="actions">
            <a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>
            <a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
            <a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
            <a href="#" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
        </td>
    </tr>		
    <%  } } %>
</tbody>
</table>

<jsp:include page="../partials/footer.jsp"/>
