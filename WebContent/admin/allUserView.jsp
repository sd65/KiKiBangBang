<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="bean.NormalUser" %>
<%@ page import="bean.User" %>
<%@ page import="bean.ProposalIdea" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
List user :
<%
	List<NormalUser> lnu = (List<NormalUser>) request.getAttribute("userList");
	for (NormalUser nu : lnu){
		out.println(nu.getEmail() + "<br />");
	}
%>

User N°5 :
<%
	NormalUser n = (NormalUser) request.getAttribute("usr");
	out.println(n.getId() + " " + n.getEmail() + " " + n.getAddress()); 
%>
<br />
User N°5 by ID :
<%
	NormalUser n2 = (NormalUser) request.getAttribute("usr2");
	if (n2.getEmail()==null){
		out.println("USER NULL");
	}
	else {
		out.println(n2.getId() + " " + n2.getEmail() + " " + n2.getAddress()); 
	}
	
%>
<br />
User N°5 by email :
<%
	NormalUser n3 = (NormalUser) request.getAttribute("usr3");
	if (n3.getEmail()==null){
		out.println("USER NULL");
	}
	else {
		out.println(n3.getId() + " " + n3.getEmail() + " " + n3.getAddress()); 
	}
	
%>
<br />
User N°5 by email :
<%
	User usr = n3;
	out.println(n3.getFunds());
	out.println(usr.getClass().getName());
	NormalUser nu = (NormalUser) usr;
	out.println(nu.getFunds());
	
	out.println(ProposalIdea.class.getName());
%>

</body>
</html>