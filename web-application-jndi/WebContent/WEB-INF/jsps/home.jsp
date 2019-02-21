<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>


	<!--  Embedding java code inside HTML  -->
	Method 1
	<br> Request :
	<%=request.getAttribute("name")%>

	<br>
	<!-- good practice -->
	<br>Method 2
	<br> Request using EL : ${name}


	<!--  Add javax.servlet jstl dependency in pom.xml -->
	<br>
	<br>Method 3
	<br> Request using JSTL :
	<c:out value="${name}"></c:out>
	<br>
	
	<br> <u>Connecting to database</u> <br>
	<sql:query var="rs" dataSource="jdbc/spring">
		select ID,Name,Email,Text from offers
	</sql:query>

	<c:forEach var="row" items="${rs.rows}">
	    ID : ${row.ID}<br />
	    Name : ${row.Name}<br />
	    Email : ${row.Email}<br />
	    Text  : ${row.Text}<br />
		<br />
	</c:forEach>

</body>
</html>