<%String pageTitle = "Submit an idea", userType="user";%>
<%@include file="../partials/header.jsp"%>


			<form id="basic-form" action="#">
				<div>
					<h3>Account</h3>
					<section>
						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="userName">User
								name *</label>
							<div class="col-lg-10">
								<input class="form-control required" id="userName"
									name="userName" type="text">
							</div>
						</div>
						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="password">
								Password *</label>
							<div class="col-lg-10">
								<input id="password" name="password" type="text"
									class="required form-control">

							</div>
						</div>

						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="confirm">Confirm
								Password *</label>
							<div class="col-lg-10">
								<input id="confirm" name="confirm" type="text"
									class="required form-control">
							</div>
						</div>

					</section>
					<h3>Profile</h3>
					<section>
						<div class="form-group clearfix">

							<label class="col-lg-2 control-label" for="name"> First
								name *</label>
							<div class="col-lg-10">
								<input id="name" name="name" type="text"
									class="required form-control">
							</div>
						</div>
						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="surname">
								Last name *</label>
							<div class="col-lg-10">
								<input id="surname" name="surname" type="text"
									class="required form-control">

							</div>
						</div>

						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="email">Email
								*</label>
							<div class="col-lg-10">
								<input id="email" name="email" type="text"
									class="required email form-control">
							</div>
						</div>

						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="address">Address
								*</label>
							<div class="col-lg-10">
								<input id="address" name="address" type="text"
									class="form-control">
							</div>
						</div>

						<div class="form-group clearfix">
							<label class="col-lg-12 control-label ">(*) Mandatory</label>
						</div>

					</section>
					<h3>Hints</h3>
					<section>
						<div class="form-group clearfix">
							<div class="col-lg-12">
								<ul class="list-unstyled w-list">
									<li><b>First Name :</b> Jonathan</li>
									<li><b>Last Name :</b> Smith</li>
									<li><b>Emial:</b> jonathan@smith.com</li>
									<li><b>Address:</b> 123 Your City, Cityname.</li>
								</ul>
							</div>
						</div>
					</section>
					<h3>Finish</h3>
					<section>
						<div class="form-group clearfix">
							<div class="col-lg-12">
								<div class="checkbox checkbox-primary">
									<input id="checkbox-h" type="checkbox"> <label
										for="checkbox-h"> I agree with the Terms and
										Conditions. </label>
								</div>
							</div>
						</div>
					</section>
				</div>
			</form>


<!-- End row -->
		 <link rel="stylesheet" type="text/css" href="assets/plugins/jquery.steps/demo/css/jquery.steps.css" />
		 
        <!--Form Validation-->
        <script src="assets/plugins/bootstrapvalidator/dist/js/bootstrapValidator.js" type="text/javascript"></script>

        <!--Form Wizard-->
        <script src="assets/plugins/jquery.steps/build/jquery.steps.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>

        <!--wizard initialization-->
        <script src="assets/pages/jquery.wizard-init.js" type="text/javascript"></script>

<jsp:include page="../partials/footer.jsp" />
