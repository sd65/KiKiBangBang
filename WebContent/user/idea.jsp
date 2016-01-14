
<%
	String pageTitle = "Idea details of", userType = "user";
%>
<%@include file="../partials/header.jsp"%>
<%@page import="bean.Idea"%>
<%@page import="bean.Question"%>
<%@page import="bean.NormalUser"%>
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
	<li class="tab active"><a href="#Discussion" data-toggle="tab"
		aria-expanded="true"> <span class="visible-xs"><i
				class="fa fa-home"></i></span> <span class="hidden-xs">Discussion</span>
	</a></li>
	<li class="tab"><a href="#Redaction" data-toggle="tab"
		aria-expanded="false"> <span class="visible-xs"><i
				class="fa fa-user"></i></span> <span class="hidden-xs">Redaction</span>
	</a></li>
	<li class="tab"><a href="#Evaluation" data-toggle="tab"
		aria-expanded="false"> <span class="visible-xs"><i
				class="fa fa-envelope-o"></i></span> <span class="hidden-xs">Evaluation</span>
	</a></li>
	<li class="tab"><a href="#Funding" data-toggle="tab"
		aria-expanded="false"> <span class="visible-xs"><i
				class="fa fa-cog"></i></span> <span class="hidden-xs">Funding</span>
	</a></li>
	<li class="tab"><a href="#Production" data-toggle="tab"
		aria-expanded="false"> <span class="visible-xs"><i
				class="fa fa-cog"></i></span> <span class="hidden-xs">Production</span>
	</a></li>
</ul>
<div class="tab-content">
	<div class="tab-pane active" id="Discussion">
		<form class="form-horizontal" role="form" method="post" action="">

			<div class="form-group">
				<label class="col-md-2 control-label">Title</label>
				<div class="col-md-10">
					<input class="form-control" readonly=""
						value="<%=idea.getName()%>" type="text">
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
		
		<form class="form-horizontal" role="form" method="post">

			<div class="form-group">
				<label class="col-md-2 control-label">Your question:</label>
				<div class="col-md-10">
					<textarea type="text" id="" name="newQuestion" class="form-control input-lg"></textarea>
				</div>
			</div>
			<button style="float: right;" type="submit" class="btn btn-purple waves-effect waves-light">Ask</button>
		</form>
<br /><br /><br />
		
			<div class="col-md-6 col-md-offset-3">
				
				<% for(Question q : idea.getDiscussionQuestions()) { %>
				
				<div class="panel panel-border panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title"><%= q.getUser().getFirstName() %> <%= q.getUser().getFamilyName() %> <small>on <%
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							out.print(formatter.format(q.getDate()));
				%></small></h3>
					</div>
					<div class="panel-body">
						<p><%= q.getQuestion() %></p>
					</div>
				</div>
				
				<% } %>
				

			</div>
		</div>
		

		<h2>Questions</h2>
		
		<div class="row">
		
		<form class="form-horizontal" role="form" method="post">

			<div class="form-group">
				<label class="col-md-2 control-label">Your question:</label>
				<div class="col-md-10">
					<textarea type="text" id="" name="newQuestion" class="form-control input-lg"></textarea>
				</div>
			</div>
			<button style="float: right;" type="submit" class="btn btn-purple waves-effect waves-light">Ask</button>
		</form>
<br /><br /><br />
		
			<div class="col-md-6 col-md-offset-3">
				
				<% for(Question q : idea.getDiscussionQuestions()) { %>
				
				<div class="panel panel-border panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title"><%= q.getUser().getFirstName() %> <%= q.getUser().getFamilyName() %> <small>on <%
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
							out.print(formatter.format(q.getDate()));
				%></small></h3>
					</div>
					<div class="panel-body">
						<p><%= q.getQuestion() %></p>
					</div>
				</div>
				
				<% } %>
				

			</div>
		</div>
	</div>
	<div class="tab-pane" id="Redaction">
		<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
			arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.
			Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras
			dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend
			tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
			ac, enim.</p>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
			Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
			penatibus et magnis dis parturient montes, nascetur ridiculus mus.
			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
			Nulla consequat massa quis enim.</p>
	</div>
	<div class="tab-pane" id="Evaluation">
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
			Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
			penatibus et magnis dis parturient montes, nascetur ridiculus mus.
			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
			Nulla consequat massa quis enim.</p>
		<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
			arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.
			Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras
			dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend
			tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
			ac, enim.</p>
	</div>
	<div class="tab-pane" id="Funding">
		<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
			arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.
			Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras
			dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend
			tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
			ac, enim.</p>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
			Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
			penatibus et magnis dis parturient montes, nascetur ridiculus mus.
			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
			Nulla consequat massa quis enim.</p>
	</div>
	<div class="tab-pane" id="Production">
		<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
			arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.
			Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras
			dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend
			tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend
			ac, enim.</p>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
			Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
			penatibus et magnis dis parturient montes, nascetur ridiculus mus.
			Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
			Nulla consequat massa quis enim.</p>
	</div>
</div>


<jsp:include page="../partials/footer.jsp" />