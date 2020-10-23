<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>License No</th>
				<th>State</th>
				<th>Exp Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${drivers}" var="driver">
				<tr>
					<td><c:out value="${driver[0].firstName}"/> <c:out value="${driver[0].lastName}"/></td>
					<td><c:out value="${driver[1].number}"/></td>
					<td><c:out value="${driver[1].state}"/></td>
					<td><c:out value="${driver[1].expirationDate}"/></td>
				</tr>					
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="/people">Add Driver</a>
	<span>  |  </span>
	<a href="/licenses">Add License</a>
</body>
</html>