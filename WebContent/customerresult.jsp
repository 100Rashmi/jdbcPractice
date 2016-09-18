<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.List"%>
<%@ page import="beans.Customer"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		List<Customer> liOfCustomers = (List<Customer>) request.getAttribute("result");
	%>

	<table border=1 align="center" width="80%"   class="w3-table w3-striped">
	    
	    <tr>  
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Address</th>
		<th>store</th>
		<th>date</th>
		
		</tr>

		<%
			for (Customer c : liOfCustomers) {
		%>
		<tr>
			<td><%=c.getId()%></td>
			<td><%=c.getFirstName() %></td>
			<td><%=c.getLastName()%></td>
			<td><%=c.getEmail()  %></td>
			<td><%=c.getAddress() %></td>
			<td><%=c.getStore_id()  %></td>
			<td><%=c.getCreatedate()  %></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>