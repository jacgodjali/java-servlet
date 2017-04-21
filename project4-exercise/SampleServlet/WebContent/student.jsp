<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Student</h3>
	<form action="Servlet2" method="post">
		<br> Name : <input type ="text" name="name" /> <br>
		<br> <input type="submit" value="add" />
		</form>
<% int counter = 1; %>
<% for(String data : (ArrayList<String>) session.getAttribute("connector")) { %>
<form action="Servlet2"> <p>
		<%= counter %>. &nbsp; <%= data %> <br>
		  <input type ="submit" value="remove" />
		<br> <input type="text" value="<%= counter %>" name="deleted" hidden/>
</p>
</form>
<% counter++; %>
<% } %>

</body> 
</html>