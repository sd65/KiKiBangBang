<% String pageTitle="Users management page", userType="admin"; %>
<%@include file="../partials/header.jsp"%>
 

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
    <tr>
        <td>Firstname</td>
        <td>Familly Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Phone</td>
        <td>Creation Date</td>
        <td class="actions">
            <a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>
            <a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
            <a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
            <a href="#" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
        </td>
    </tr>		
</tbody>
</table>

<jsp:include page="../partials/footer.jsp"/>
