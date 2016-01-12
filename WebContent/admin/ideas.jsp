
<% String pageTitle="Ideas management page", userType="admin"; %>
<%@include file="../partials/header.jsp"%>


<table id="demo-foo-filtering"
	class="table table-striped toggle-circle m-b-0" data-page-size="7">
	<thead>
		<tr>
			<th data-toggle="true">First Name</th>
			<th>Last Name</th>
			<th data-hide="phone">Job Title</th>
			<th data-hide="phone, tablet">DOB</th>
			<th data-hide="phone, tablet">Status</th>
		</tr>
	</thead>
	<div class="form-inline m-b-20">
		<div class="row">
			<div class="col-sm-6 text-xs-center">
				<div class="form-group">
					<label class="control-label m-r-5">Status</label> <select
						id="demo-foo-filter-status" class="form-control input-sm">
						<option value="">Show all</option>
						<option value="active">Active</option>
						<option value="disabled">Disabled</option>
						<option value="suspended">Suspended</option>
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
		<tr>
			<td>Isidra</td>
			<td>Boudreaux</td>
			<td>Traffic Court Referee</td>
			<td>22 Jun 1972</td>
			<td><span class="label label-table label-success">Active</span></td>
		</tr>
		<tr>
			<td>Shona</td>
			<td>Woldt</td>
			<td>Airline Transport Pilot</td>
			<td>3 Oct 1981</td>
			<td><span class="label label-table label-inverse">Disabled</span></td>
		</tr>
		<tr>
			<td>Granville</td>
			<td>Leonardo</td>
			<td>Business Services Sales Representative</td>
			<td>19 Apr 1969</td>
			<td><span class="label label-table label-danger">Suspended</span></td>
		</tr>
		<tr>
			<td>Easer</td>
			<td>Dragoo</td>
			<td>Drywall Stripper</td>
			<td>13 Dec 1977</td>
			<td><span class="label label-table label-success">Active</span></td>
		</tr>
		<tr>
			<td>Maple</td>
			<td>Halladay</td>
			<td>Aviation Tactical Readiness Officer</td>
			<td>30 Dec 1991</td>
			<td><span class="label label-table label-danger">Suspended</span></td>
		</tr>
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
