<%String pageTitle = "Profile", userType="user";%>
<%@include file="../partials/header.jsp"%>

<form class="form-horizontal" role="form" method="post" action="user/reload"> 	
 <div class="form-group">
    <label class="col-md-2 control-label" for="example-email">Current funds</label>
    <div class="col-md-10">
        <input disabled class="form-control" value="<%
        
 
		NormalUser usr = (NormalUser) session.getAttribute("userLogged");
    		out.print(usr.getFunds().toString());
        
        %>">
    </div>
</div>

<div class="form-group">
    <label class="col-md-2 control-label">Add money</label>
    <div class="col-md-10">
        <input type="number" placeholder="Enter your amount"  name="amount" class="form-control">
    </div>
</div>
<button type="submit" class="btn btn-pink waves-effect waves-light">Add money!</button>
</form>
		<br/>


<jsp:include page="../partials/footer.jsp" />
