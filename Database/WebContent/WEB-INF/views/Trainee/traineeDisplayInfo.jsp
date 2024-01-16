<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trainee Display Information</title>
    
    <style>
    	table {
    		border-collapse: collapse;
    	}
    	
    	table, td, th {
		  border: 1px solid black;
		  padding: 15px;
		}
    </style>
    
</head>
<body>
    <h1>Trainee Information</h1>

    <c:choose>
		<c:when test="${action eq 'getAll'}">
		    <h2>All Trainees</h2>
		    <table>
		        <tr>
		            <th>ID</th>
		            <th>Name</th>
		            <th>Weight</th>
		            <th>Height</th>
		            <th>BMI</th>
		        </tr>
		        <c:forEach var="trainee" items="${trainees}">
		            <tr>
		                <td><c:out value="${trainee.id}"/></td>
		                <td><c:out value="${trainee.name}"/></td>
		                <td><c:out value="${trainee.weight}"/></td>
		                <td><c:out value="${trainee.height}"/></td>
		                <td><c:out value="${trainee.bmi}"/></td>
		            </tr>
		        </c:forEach>
		    </table>
		</c:when>
        <c:when test="${action eq 'getById'}">
            <h2>Trainee Details</h2>
            <p>Trainee ID: <c:out value="${trainee.id}"/></p>
            <p>Trainee Name: <c:out value="${trainee.name}"/></p>
            <p>Weight: <c:out value="${trainee.weight}"/></p>
            <p>Height: <c:out value="${trainee.height}"/></p>
            <p>BMI: <c:out value="${trainee.bmi}"/></p>
        </c:when>
        <c:when test="${action eq 'add'}">
            <h2>Trainee Added Successfully</h2>
            <p>Rows affected: <c:out value="${effectedRow}"/></p>
        </c:when>
        <c:when test="${action eq 'update'}">
            <h2>Trainee Updated Successfully</h2>
            <p>Rows affected: <c:out value="${effectedRow}"/></p>
        </c:when>
        <c:when test="${action eq 'delete'}">
            <h2>Trainee Deleted Successfully</h2>
            <p>Rows affected: <c:out value="${effectedRow}"/></p>
        </c:when>
        <c:when test="${action eq 'noData'}">
            <h2>No Data Found</h2>
            <p><c:out value="${message}"/></p>
        </c:when>
        <c:when test="${action eq 'error'}">
            <h2>Error</h2>
            <p><c:out value="${message}"/></p>
        </c:when>
        <c:otherwise>
            <h2>Unknown Action</h2>
            <p>No information is available for the action performed.</p>
        </c:otherwise>
	</c:choose>
</body>
</html>