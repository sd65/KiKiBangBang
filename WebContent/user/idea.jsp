
<%
	String pageTitle = "Idea details of", userType = "user";
%>
<%@include file="../partials/header.jsp"%>
<%@page import="bean.Idea"%>
<%@page import="bean.Question"%>
<%@page import="bean.NormalUser"%>
<%@page import="bean.Comment"%>
<%
	Object obj = request.getAttribute("idea");
	Idea idea = (Idea) obj;
%>
<%@page import="java.text.SimpleDateFormat"%>

<h1 style="display: inline;"><%=idea.getName()%></h1>
<h2 style="display: inline; float: right;">
	Funding: $<%=idea.getRaisedFunds()%>
	/ $<%=idea.getFundsRequired()%></h2>
<br />
<br />
<br />
<ul class="nav nav-tabs tabs">
	<li
		class="tab <%if (idea.getStepName() == "Discussion")
				out.print("active");%>"><a
		class="<%if (idea.getStepName() == "Discussion")
				out.print("active");%>"
		href="#Discussion" data-toggle="tab" aria-expanded="true"> <span
			class="visible-xs"><i class="fa fa-home"></i></span> <span
			class="hidden-xs">Discussion</span>
	</a></li>
	<li
		class="tab <%if (idea.getStepName() == "Redaction")
				out.print("active");%>"><a
		class="<%if (idea.getStepName() == "Redaction")
				out.print("active");%>"
		href="#Redaction" <%if (!idea.getStepName().matches("Discussion")) out.print("data-toggle='tab'"); else { out.print("onclick='return false'"); }%> aria-expanded="false"> <span
			class="visible-xs"><i class="fa fa-user"></i></span> <span
			class="hidden-xs">Redaction</span>
	</a></li>
	<li
		class="tab <%if (idea.getStepName() == "Evaluation")
				out.print("active");%>"><a
		class="<%if (idea.getStepName() == "Evaluation")
				out.print("active");%>"
		href="#Evaluation" <%if (!idea.getStepName().matches("Discussion|Redaction")) out.print("data-toggle='tab'"); else { out.print("onclick='return false'"); }%> aria-expanded="false"> <span
			class="visible-xs"><i class="fa fa-envelope-o"></i></span> <span
			class="hidden-xs">Evaluation</span>
	</a></li>
	<li
		class="tab <%if (idea.getStepName() == "Funding")
				out.print("active");%>"><a
		class="<%if (idea.getStepName() == "Funding")
				out.print("active");%>"
		href="#Funding" <%if (!idea.getStepName().matches("Discussion|Redaction|Evaluation")) out.print("data-toggle='tab'"); else { out.print("onclick='return false'"); }%> aria-expanded="false"> <span
			class="visible-xs"><i class="fa fa-cog"></i></span> <span
			class="hidden-xs">Funding</span>
	</a></li>
	<li
		class="tab <%if (idea.getStepName() == "Production")
				out.print("active");%>"><a
		class="<%if (idea.getStepName() == "Production")
				out.print("active");%>"
		href="#Production" <%if (!idea.getStepName().matches("Discussion|Redaction|Evaluation|Funding")) out.print("data-toggle='tab'"); else { out.print("onclick='return false'"); }%> aria-expanded="false"> <span
			class="visible-xs"><i class="fa fa-cog"></i></span> <span
			class="hidden-xs">Production</span>
	</a></li>
</ul>
<div class="tab-content">
	<div
		class="tab-pane <%if (idea.getStepName() == "Discussion")
				out.print("active");%>"
		id="Discussion">
		<form class="form-horizontal" role="form" method="post" action="">

			<div class="form-group">
				<label class="col-md-2 control-label">Title</label>
				<div class="col-md-10">
					<input class="form-control" readonly="" value="<%=idea.getName()%>"
						type="text">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">Funding</label>
				<div class="col-md-10">
					<input class="form-control" readonly=""
						value="<%=idea.getFundsRequired()%>" type="text">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">Description</label>
				<div class="col-md-10">
					<textarea class="form-control" readonly="" type="text"> <%=idea.getShortDescription()%></textarea>
				</div>
			</div>

		</form>

		<h2>User votes</h2>

		<div class="row">

			<h3>
				Score
				<%=idea.getDiscussionScore()%></h3>

			<form id="sdsd" class="form-horizontal" role="form" method="post">



				<label> <input type="radio" name="vote" id="optionsRadios1"
					value="up" checked> +
				</label> <label> <input type="radio" name="vote" id="optionsRadios2"
					value="down"> -
				</label>


				
				<% if (idea.getStepNumber() == 2) { %>
				<%
					if (!idea.userAlreadyVote(nu)) {
				%>
				<button style="float: right;" type="submit"
					class="btn btn-purple waves-effect waves-light">Vote</button>
				<%
					} else {
				%>
				<button style="float: right;" type="submitNot"
					class="btn btn-success waves-effect waves-light"
					onclick="return false">You have already voted !</button>
				<%
					}}
				%>
				
			</form>

		</div>

		<h2>Questions</h2>

		<div class="row">
			<% if (idea.getStepNumber() == 2) { %>
			<form class="form-horizontal" role="form" method="post">

				<div class="form-group">
					<label class="col-md-2 control-label">Your question:</label>
					<div class="col-md-10">
						<textarea type="text" id="" name="newQuestion"
							class="form-control input-lg"></textarea>
					</div>
				</div>
				<button style="float: right;" type="submit"
					class="btn btn-purple waves-effect waves-light">Ask</button>
			</form>
			<br /> <br /> <%
					}
				%><br />

			<div class="col-md-6 col-md-offset-3">

				<%
					for (Question q : idea.getDiscussionQuestions()) {
				%>

				<div class="panel panel-border panel-<% if(idea.getProposer().getId() == q.getUser().getId()) out.print("danger"); else  out.print("primary"); %>">
					<div class="panel-heading">
						<h3 class="panel-title"><%=q.getUser().getFirstName()%>
							<%=q.getUser().getFamilyName()%>
							<small>on <%
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
									out.print(formatter.format(q.getDate()));
							%></small>
						</h3>
					</div>
					<div class="panel-body">
						<p><%=q.getQuestion()%></p>
					</div>
				</div>

				<%
					}
				%>


			</div>

		</div>





	</div>
	<div
		class="tab-pane <%if (idea.getStepName() == "Redaction")
				out.print("active");%>"
		id="Redaction">

		<form class="form-horizontal" role="form" method="post">

			<div class="form-group">
				<label class="col-md-2 control-label">Enriched description</label>
				<div class="col-md-10">
					<textarea class="form-control" name="redactionEnrich"
						<%if (idea.getProposer().getId() != nu.getId()) {%> readonly=""
						<%}%> type="text"> <%=idea.getRedactionEnrich()%></textarea>
				</div>
			</div>

			<%
				if (idea.getProposer().getId() == nu.getId() && idea.getStepNumber() == 3) {
			%>
			<button style="float: right;" type="submit"
				class="btn btn-purple waves-effect waves-light">Submit</button>
			<%
				}
			%>
		</form>

		<h2>Comments</h2>

		<div class="row">
			
			<% if (idea.getStepNumber() == 3) { %>
			<form class="form-horizontal" role="form" method="post">

				<div class="form-group">
					<label class="col-md-2 control-label">Your comment:</label>
					<div class="col-md-10">
						<textarea type="text" id="" name="newComment"
							class="form-control input-lg"></textarea>
					</div>
				</div>
				<button style="float: right;" type="submit"
					class="btn btn-purple waves-effect waves-light">Post</button>
			</form>
			<br /> <br /> <% } %><br />

			<div class="col-md-6 col-md-offset-3">

				<%
					for (Comment c : idea.getRedactionComments()) {
				%>

				<div class="panel panel-border panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title"><%=c.getUser().getFirstName()%>
							<%=c.getUser().getFamilyName()%>
							<small>on <%
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
									out.print(formatter.format(c.getDate()));
							%></small>
						</h3>
					</div>
					<div class="panel-body">
						<p><%=c.getText()%></p>
					</div>
				</div>

				<%
					}
				%>


			</div>

		</div>


	</div>
	<div
		class="tab-pane <%if (idea.getStepName() == "Evaluation")
				out.print("active");%>"
		id="Evaluation">


		<h3>
			Vote score :
			<%=idea.getEvaluationScore()%></h3>
			
			<% if (idea.getStepNumber() == 4) { %>
		
		<%
				if (!idea.userAlreadyVoteEval(nu)) {
			%>
			
		<form class="form-horizontal" role="form" method="post">

			<label> Feasibility</label>
			<div class="radio radio-primary">

				<input name="voteFeasibility" value="up" type="radio">
				<label for=""> + </label> <br /> <input name="voteFeasibility"
					value="down"  type="radio"> <label for=""> - </label>
			</div>

			<label> Market interest</label>
			<div class="radio radio-primary">

				<input name="voteMarkeInterest" value="up"  type="radio">
				<label for=""> + </label> <br /> <input name="voteMarkeInterest"
					value="down"  type="radio"> <label for=""> - </label>
			</div>


			<label> Impact</label>
			<div class="radio radio-primary">

				<input name="voteImpact" value="up"  type="radio"> <label
					for=""> + </label> <br /> <input name="voteImpact" value="down"
					type="radio"> <label for=""> - </label>
			</div>




			
			<button style="float: right;" type="submit"
				class="btn btn-purple waves-effect waves-light">Vote</button>
			
		</form>
		
		<%
				} else {
			%>
			<button style="float: right;" 
				class="btn btn-success waves-effect waves-light"
				onclick="return false">You have already voted !</button>
			<%
				} }
			%>



	</div>
	<div
		class="tab-pane <%if (idea.getStepName() == "Funding")
				out.print("active");%>"
		id="Funding">

		<h3>
			Now funding $<%=idea.getRaisedFunds()%>
			of $<%=idea.getFundsRequired()%>
		</h3>
		<% if (idea.getStepNumber() == 5) { %>
		<form class="form-horizontal" role="form" method="post">

			<div class="form-group">
				<label class="col-md-2 control-label">Your donation</label>
				<div class="col-md-10">
					<input type="text" id="" name="newFund"
						class="form-control input-lg" />
				</div>
			</div>
			<button style="float: right;" type="submit"
				class="btn btn-purple waves-effect waves-light">Fund!</button>
		</form>
		
		<% } %>

	</div>
	<div
		class="tab-pane <%if (idea.getStepName() == "Production")
				out.print("active");%>"
		id="Production">
		
		Yipee !
		
		<br/><br/><br/><br/><br/>
		<div class="panel panel-border panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Congratulation</h3>
			</div>
			<div class="panel-body">
				<p>This idea is in production !</p>
			</div>
		</div>


	</div>
</div>


<jsp:include page="../partials/footer.jsp" />