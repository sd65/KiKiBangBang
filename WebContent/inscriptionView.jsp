<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utilisateur Inscrit</title>
</head>
<body>
Resultat de la requête :
	<% out.println(request.getAttribute("result")); %>
	<br />
	
Pour l'utilisateur 
	<% out.println(request.getAttribute("email")); %>
</body>
</html>