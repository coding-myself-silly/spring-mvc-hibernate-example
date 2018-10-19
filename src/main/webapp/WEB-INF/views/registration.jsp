<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Automobile Add/Edit Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2>Add/Edit Form</h2>
 
	<form:form method="POST" modelAttribute="automobile">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="name">Name: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="model">Model: </label> </td>
				<td><form:input path="model" id="model"/></td>
				<td><form:errors path="model" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="year">Year: </label> </td>
				<td><form:input path="year" id="year"/></td>
				<td><form:errors path="year" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td><label for="countryOfOrigin">Country Of Origin: </label> </td>
				<td><form:input path="countryOfOrigin" id="countryOfOrigin"/></td>
				<td><form:errors path="countryOfOrigin" cssClass="error"/></td>
		    </tr>
	
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Automobiles</a>
</body>
</html>