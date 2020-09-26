<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Success</title>
</head>
<body>

	<h1>You Registered successfully</h1>

	<%-- JSP Expression Language --%>
	<ul>
		<li>Id : ${customer.id}</li>
		<li>Password : ${customer.password}</li>
		<li>Gender : ${customer.gender}</li>
		<li>Name : ${customer.name}</li>
		<li>Email : ${customer.email}</li>
	</ul>

	<%-- JSTL --%>
	<table>
		<c:forEach var="customer" items="${customerList}">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.password}</td>
				<td>${customer.gender}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/helloMVC/index.jsp">go to home page</a>

</body>
</html>

