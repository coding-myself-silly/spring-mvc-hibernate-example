<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of Automobiles</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Automobiles</h2>	
	<table>
		<tr>
			<td>NAME</td><td>Model</td><td>Year</td><td>Country Of Origin</td><td></td>
		</tr>
		<c:forEach items="${automobiles}" var="automobile">
			<tr>
			<td>${automobile.name}</td>
			<td>${automobile.model}</td>
			<td>${automobile.year}</td>
			<td>${automobile.countryOfOrigin}</td>
			<td><a href="<c:url value='/edit-${automobile.id}-automobile' />">${automobile.name} ${automobile.model} ${automobile.year} </a></td>
			<td><a href="<c:url value='/delete-${automobile.id}-automobile' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Add New Automobile</a>
</body>
</html>