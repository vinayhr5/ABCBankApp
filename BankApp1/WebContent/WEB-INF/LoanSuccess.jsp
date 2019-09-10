<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session= request.getSession();

out.println("Dear "+session.getAttribute("name")+ " thank you for showing interest on loan from ABC BANK");
out.println("our executive will contact you soon. ");
out.println("you will get all updates on your email mentioned below");
out.println(session.getAttribute("email"));
%>

</body>
</html>