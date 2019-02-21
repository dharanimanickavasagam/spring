<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>

		<!--  Embedding java code inside HTML  -->
		Method 1 <br> Request :
		<%=request.getAttribute("name")%>

		<br>
		<!-- good practice -->
		<br>Method 2 <br> Request using EL : ${name}




	</h1>
</body>
</html>