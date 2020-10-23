<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add a New License</h2>
	<br>
	<form:form action="/licenses" method="post" modelAttribute="license">
		<p>
			<form:label path="person">Driver</form:label>
			<form:errors path="person"/>
			<form:select path="person">
				<c:forEach items=${"eligibles"} var="driver">
					<form:option value="${driver}">${driver.firstName} ${driver.lastName}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<p>
			<form:label path="expirationDate">Exp Date</form:label>
			<form:errors path="expirationDate"/>
			<form:input type="date" path="expirationDate"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>

</body>
</html>