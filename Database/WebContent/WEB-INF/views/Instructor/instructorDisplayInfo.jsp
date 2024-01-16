<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instructor Display Information</title>
    
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
    <h1>Instructor Information</h1>

    <c:choose>
        <c:when test="${action eq 'getAll'}">
		    <h2>All Instructors</h2>
		    <table>
		        <tr>
		            <th>ID</th>
		            <th>Name</th>
		            <th>Gender</th>
		            <th>Specialty</th>
		        </tr>
		        <c:forEach var="instructor" items="${instructors}">
		            <tr>
		                <td><c:out value="${instructor.id}"/></td>
		                <td><c:out value="${instructor.name}"/></td>
		                <td><c:out value="${instructor.gender}"/></td>
		                <td><c:out value="${instructor.specialty}"/></td>
		            </tr>
		        </c:forEach>
		    </table>
		</c:when>
        <c:when test="${action eq 'getById'}">
            <h2>Instructor Details</h2>
            <p>Instructor ID: <c:out value="${instructor.id}"/></p>
            <p>Instructor Name: <c:out value="${instructor.name}"/></p>
            <p>Gender: <c:out value="${instructor.gender}"/></p>
            <p>Specialty: <c:out value="${instructor.specialty}"/></p>
        </c:when>
        <c:when test="${action eq 'add'}">
            <h2>Instructor Added Successfully</h2>
            <p>Rows affected: <c:out value="${effectedRow}"/></p>
        </c:when>
        <c:when test="${action eq 'update'}">
            <h2>Instructor Updated Successfully</h2>
            <p>Rows affected: <c:out value="${effectedRow}"/></p>
        </c:when>
        <c:when test="${action eq 'delete'}">
            <h2>Instructor Deleted Successfully</h2>
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