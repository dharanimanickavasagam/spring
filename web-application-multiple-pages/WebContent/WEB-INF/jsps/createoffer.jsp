<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="${pageContext.request.contextPath}/staticresources/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<form method="post"
		action="${pageContext.request.contextPath}/docreate">
		<table class="formtable">
			<tr>
				<td class="label">Name</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td class="label">Email</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td class="label">Text</td>
				<td><textarea name="text" rows=10></textarea></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" action=""></td>
			</tr>
		</table>
	</form>
</body>
</html>