<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!--  Add the dependency JSTL in pom.xml -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring data Model</title>
</head>


<body>
	<h1>Welcome to Spring data model adventures!</h1>
	<%-- 	 Not a good practice to put the java code in JSP 
	So use SPEL to resolve this 

		Request : 
		<%=request.getAttribute("name")%>
		<p /> 
--%>
	Request (using Expression Language) : ${name}
	<p />

	Request using JSTL :
	<!--  Using JSTL  -->
	<c:out value="${name}"></c:out>


</body>
</html>