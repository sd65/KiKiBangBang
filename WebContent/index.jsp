<% String pageTitle="Login page"; %>
<%@include file="partials/header.jsp"%>
 


<form class="form-horizontal" role="form"> 	
 <div class="form-group">
    <label class="col-md-2 control-label" for="example-email">Email</label>
    <div class="col-md-10">
        <input type="email" id="example-email" name="example-email" class="form-control" placeholder="Email">
    </div>
</div>

<div class="form-group">
    <label class="col-md-2 control-label">Password</label>
    <div class="col-md-10">
        <input type="password" class="form-control">
    </div>
</div>
<button type="submit" class="btn btn-purple waves-effect waves-light">Submit</button>
</form>
						
        
<jsp:include page="partials/footer.jsp"/>
