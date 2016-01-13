<% String baseUrl="http://localhost:8080/KikiBangBang/"; %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <link rel="shortcut icon" href="assets/images/favicon_1.ico">

        <title>KiKiBangBang - <%= pageTitle %></title>

        <!--Morris Chart CSS -->
		 <link rel="stylesheet" href="<%= baseUrl %>/assets/plugins/morris/morris.css">

        <link href="<%= baseUrl %>/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="<%= baseUrl %>/assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="<%= baseUrl %>/assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="<%= baseUrl %>/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="<%= baseUrl %>/assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="<%= baseUrl %>/assets/css/responsive.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="<%= baseUrl %>/assets/plugins/magnific-popup/dist/magnific-popup.css" />
        <link rel="stylesheet" href="<%= baseUrl %>/assets/plugins/jquery-datatables-editable/datatables.css" />
        

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
		<base href="<%= baseUrl %>/">
        <script src="assets/js/modernizr.min.js"></script>
		
		<!-- jQuery  -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

    </head>


    <body class="fixed-left">
    
           <!-- Begin page -->
        <div id="wrapper">

            <!-- Top Bar Start -->
            <div class="topbar">

                <!-- LOGO -->
                <div class="topbar-left">
                    <div class="text-center">
                        <a href="index.html" class="logo"><i class="icon-magnet icon-c-logo"></i><span>Ub<i class="md md-album"></i>ld</span></a>
                    </div>
                </div>

                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left">
                                <button class="button-menu-mobile open-left">
                                    <i class="ion-navicon"></i>
                                </button>
                                <span class="clearfix"></span>
                            </div>

                            <form role="search" class="navbar-left app-search pull-left hidden-xs">
			                     <input type="text" placeholder="Search..." class="form-control">
			                     <a href=""><i class="fa fa-search"></i></a>
			                </form>


                            <ul class="nav navbar-nav navbar-right pull-right">
                            
                                <li class="hidden-xs">
                                    <a href="#" id="btn-fullscreen" class="waves-effect waves-light"><i class="icon-size-fullscreen"></i></a>
                                </li>

                                <li class="dropdown">
                                    <a href="" class="dropdown-toggle profile" data-toggle="dropdown" aria-expanded="true"><img src="assets/images/users/avatar-1.jpg" alt="user-img" class="img-circle"> </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="javascript:void(0)"><i class="ti-user m-r-5"></i> Profile</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-lock m-r-5"></i> Lock screen</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->

            <div class="left side-menu">
                <div class="sidebar-inner slimscrollleft">
                    <!--- Divider -->
                    <div id="sidebar-menu">
                        <ul>
                        
                        	<% if (pageTitle!="Login page")  { %>

                        	

                            <% if (userType=="admin")  { %>
                            
                            	
                            <li class="has_sub"title>
                                <a href="admin/dashboard.jsp" class="waves-effect <% if (pageTitle.startsWith("Dashboard")) out.print("active");%>"><i class="ti-home"></i> <span> Dashboard </span> </a>  
                            </li>
                            
                            <li class="has_sub"title>
                                <a href="admin/users.jsp" class="waves-effect <% if (pageTitle.startsWith("Users")) out.print("active");%>"><i class="ti-user"></i> <span> Users </span> </a>  
                            </li>
                            
                             <li class="has_sub"title>
                                <a href="admin/ideas.jsp" class="waves-effect <% if (pageTitle.startsWith("Ideas")) out.print("active");%>"><i class="ti-light-bulb"></i> <span> Ideas </span> </a>  
                            </li>
                            
                            <% } else { %>
                            
                            <li class="has_sub"title>
                                <a href="user/submitIdea.jsp" class="waves-effect <% if (pageTitle.startsWith("Submit")) out.print("active");%>"><i class="ti-pencil-alt"></i> <span> Submit an idea </span> </a>  
                            </li>
                            
                            <li class="has_sub"title>
                                <a href="user/myIdeas.jsp" class="waves-effect <% if (pageTitle.startsWith("My")) out.print("active");%>"><i class="ti-light-bulb"></i> <span> My ideas <span class="label label-success pull-right">3</span></span> </a>  
                            </li>
                            
                            <li class="has_sub"title>
                                <a href="user/ideas.jsp" class="waves-effect <% if (pageTitle.startsWith("Ideas")) out.print("active");%>"><i class="ti-bar-chart"></i> <span> Ideas </span> <span class="label label-pink pull-right">11</span></a>  
                            </li>
                            
                            
                            <% } } %>

                            

                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <!-- Left Sidebar End -->


      <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">
                    
                    <div class="row">
	<div class="col-sm-12">
		<div class="card-box">
			<h4 class="m-t-0 header-title"><b><%= pageTitle %></b></h4>
			
			
			
			