<%String pageTitle = "Submit an idea", userType="user";%>
<%@include file="../partials/header.jsp"%>


			<form id="basic-form" action="SubmitIdeaServlet" method="post">
				<div>
					<h3>Basic info</h3>
					<section>
						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="title">Title</label>
							<div class="col-lg-10">
								<input class="form-control required" id=""
									name="title" type="text">
							</div>
						</div>
						<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="description">Description
								</label>
							<div class="col-lg-10">
								<input id="" name="description" type="text"
									class="required form-control">

							</div>
						</div>

					</section>
<!-- 					<h3>Aims</h3> -->
<!-- 					<section> -->
<!-- 						<div class="form-group clearfix"> -->

<!-- 							<label class="col-lg-2 control-label" for="name"> Application field</label> -->
<!-- 							<div class="col-lg-10"> -->
<!-- 								<input id="name" name="applicationField" type="text" -->
<!-- 									class="required form-control"> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="form-group clearfix"> -->
<!-- 							<label class="col-lg-2 control-label " for="surname">Targeted market</label> -->
<!-- 							<div class="col-lg-10"> -->
<!-- 								<input id="surname" name="targetedMarket" type="text" -->
<!-- 									class="required form-control"> -->

<!-- 							</div> -->
<!-- 						</div> -->

<!-- 					</section> -->
					<h3>Money</h3>
					<section>
					
					<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="fundingRequested">Funding requested</label>
							<div class="col-lg-10">
								<input id="" name="fundingRequested" type="text"
									class="required form-control">

							</div>
						</div>
						
					</section>
					<h3>Terms of use agreement</h3>
					<section>
					<div class="form-group clearfix">
							<label class="col-lg-2 control-label " for="termsOfUse">Terms and
										Conditions</label>
							<div class="col-lg-10">
								<textarea  
									class="required form-control">
Et hanc quidem praeter oppida multa duae civitates exornant Seleucia opus Seleuci regis, et Claudiopolis quam deduxit coloniam Claudius Caesar. Isaura enim antehac nimium potens, olim subversa ut rebellatrix interneciva aegre vestigia claritudinis pristinae monstrat admodum pauca.

Et quia Montius inter dilancinantium manus spiritum efflaturus Epigonum et Eusebium nec professionem nec dignitatem ostendens aliquotiens increpabat, qui sint hi magna quaerebatur industria, et nequid intepesceret, Epigonus e Lycia philosophus ducitur et Eusebius ab Emissa Pittacas cognomento, concitatus orator, cum quaestor non hos sed tribunos fabricarum insimulasset promittentes armorum si novas res agitari conperissent.

Nec minus feminae quoque calamitatum participes fuere similium. nam ex hoc quoque sexu peremptae sunt originis altae conplures, adulteriorum flagitiis obnoxiae vel stuprorum. inter quas notiores fuere Claritas et Flaviana, quarum altera cum duceretur ad mortem, indumento, quo vestita erat, abrepto, ne velemen quidem secreto membrorum sufficiens retinere permissa est. ideoque carnifex nefas admisisse convictus inmane, vivus exustus est.
								</textarea>

							</div>
						</div>
						<div class="form-group clearfix">
							<div class="col-lg-12">
								<div class="checkbox checkbox-primary">
									<input id="checkbox-h" name="termsOfUseCheckbox" type="checkbox"> <label
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
