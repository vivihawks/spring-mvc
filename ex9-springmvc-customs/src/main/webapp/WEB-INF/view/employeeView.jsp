<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Submitted Employee Information</h2>
	<h3>${msg}</h3>
	<table>
		<tr>
			<td>Name :</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>ID :</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Contact Number :</td>
			<td>${contactNumber}</td>
		</tr>
	</table>

<h4><u>List of Employees</u></h4>
	<c:forEach var="employee" items="${employees}"> 
<ul>
    	<li><c:out value="${employee.key}" /></li>
    	<li><c:out value="${employee.value.name}" /></li>
    	
</ul>
	</c:forEach>
</body>
</html>