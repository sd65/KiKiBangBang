<% String pageTitle="Login page",userType="none"; %>
<%@include file="partials/header.jsp"%>
 


<form class="form-horizontal" role="form" method="post" action="login"> 	
 <div class="form-group">
    <label class="col-md-2 control-label" for="example-email">Email</label>
    <div class="col-md-10">
        <input type="email" id="email" name="email" class="form-control" placeholder="Email">
    </div>
</div>

<div class="form-group">
    <label class="col-md-2 control-label">Password</label>
    <div class="col-md-10">
        <input type="password" id="pwd" name="pwd" class="form-control">
    </div>
</div>
<button type="submit" class="btn btn-purple waves-effect waves-light">Submit</button>
</form>
		<br/>
<a href="signIn.jsp">Sign up!</a>				
        
<jsp:include page="partials/footer.jsp"/>
