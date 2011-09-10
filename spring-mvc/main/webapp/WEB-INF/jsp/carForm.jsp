<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="welcome.title" /></title>
</head>
<body>
	<form:form method="POST" commandName="carInsert">
		<form:errors path="*"></form:errors>
		<table>
			<tr>
				<td>Brand</td>
				<td><form:input path="brand" />
				</td>
				<td><form:errors path="brand" />
				</td>
			</tr>
			<tr>
				<td>Model</td>
				<td><form:input path="name" />
				</td>
				<td><form:errors path="name" />
				</td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" />
				</td>
				<td><form:errors path="price" />
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>