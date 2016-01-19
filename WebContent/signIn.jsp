<%	String pageTitle = "Sign In", userType = "none"; %>
<%@include file="partials/header.jsp"%>

<form id="fbla" class="form-horizontal" role="form" method="post">

    <div class="form-group">
        <div class="form-group">
            <label class="col-md-2 control-label" for="email">Adresse email <span class="requis">*</span></label>
            <div class="col-md-10">
                <input class="form-control" type="text" id="email" name="email"
                    value="" size="20" maxlength="60" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="motdepasse">Mot de passe <span class="requis">*</span></label>
            <div class="col-md-10">
                <input class="form-control" type="password" id="motdepasse"
                    name="motdepasse" value="" size="20" maxlength="20" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="confirmation">Confirmation du mot de passe <span
                class="requis">*</span></label>
            <div class="col-md-10">
                <input class="form-control" type="password" id="confirmation"
                    name="confirmation" value="" size="20" maxlength="20" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="familyName">Family name</label>
            <div class="col-md-10">
                <input class="form-control" type="text" id="familyName"
                    name="familyName" value="" size="20" maxlength="20" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="firstName">First name</label>
            <div class="col-md-10">
                <input class="form-control" type="text" id="firstName"
                    name="firstName" value="" size="20" maxlength="20" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="address">Address</label>
            <div class="col-md-10">
                <input class="form-control" type="text" id="address" name="address"
                    value="" size="20" maxlength="20" />
            </div>
        </div>



        <div class="form-group">
            <label class="col-md-2 control-label" for="phone">Phone</label>
            <div class="col-md-10">
                <input class="form-control" type="text" id="phone" name="phone"
                    value="" size="20" maxlength="20" />
            </div>
        </div>
        
        <img style="margin-left: 272px;display:block;" src="http://image.captchas.net?client=demo&amp;random=RandomZufall" alt="CAPTCHA Picture" id="captcha_pic">
        
        <button id="blas"  class="btn btn-pink waves-effect waves-light">Submit</button>
</form>

<br/>

<div id="ok" style="display:none" class="alert alert-success" role="alert">Success! Redirecting you...</div>

<div id="ko" style="display:none" class="alert alert-danger" role="alert">Errors! Check your inputs!</div>

<script>

$('#fbla').submit(function( event ) {
	event.preventDefault();
    $.ajax({
        url: 'inscription',
        type: 'post',
        data: $('#fbla').serialize(),
    })  .done(function( data ) {
    	$("#ko").hide();
    	$("#ok").hide();
    		if (data=="KO") 
            	$("#ko").show();
    		else {
    			$("#ok").show();
    			window.setTimeout( function(){
                    window.location = "http://localhost:8080/KikiBangBang/";
                }, 3000 );
    		}
    			
          })
});


</script>


<jsp:include page="partials/footer.jsp" />
