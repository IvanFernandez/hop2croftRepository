<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcome.title"/></title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${cars}" var="car">
			<tr>		
				<td>${car.brand}</td>
				<td>${car.name}</td>
				<td>${car.price}</td>
			<tr>
		</c:forEach>
	</table>
	
	Tiempo de respuesta : ${timeResponse} ms
	<br>
	Locale:	${pageContext.response.locale}
</body>
</html>