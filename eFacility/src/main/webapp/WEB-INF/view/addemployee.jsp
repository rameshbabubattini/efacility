<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="add.html" modelAttribute="e" method="POST">
		<div id="employee" style="width:'100%';height:100;">
			<div>
				<div>Employee ID</div>
				<div><form:input path="id"/></div>
			</div>
			<div>
				<div>Employee Name</div>
				<div><form:input path="name"/></div>
			</div>
			<div>
				<div><input value="Submit" type="Submit"/></div>
			</div>
			<div>
				<h1>${message}</h1>
			</div>			
		</div>
	</form:form>
</body>
</html>