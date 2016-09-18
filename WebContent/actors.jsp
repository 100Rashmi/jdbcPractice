<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.List"%>
<%@ page import="beans.Actor"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

<body>

<div id="one"> Hello </div>

	<%
		List<Actor> liOfActors = (List<Actor>) request.getAttribute("result");
	%>

	<table border=1 align="center" width="80%"   class="w3-table w3-striped">
		<td>Id</td>
		<td>first name</td>
		<td>last name</td>

		<%
			for (Actor a : liOfActors) {
		%>
		<tr>
			<td><%=a.getID()%></td>
			<td><%=a.getFirstName() %></td>
			<td><%=a.getLastName()%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>