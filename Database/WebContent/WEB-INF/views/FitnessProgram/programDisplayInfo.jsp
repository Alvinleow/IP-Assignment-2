<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Program Display Information</title>
	
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
    <h1>Program Information</h1>
    
    <c:choose>
        <c:when test="${action eq 'getAll'}">
		    <h2>All Programs</h2>
		    <table>
		        <tr>
		            <th>Program ID</th>
		            <th>Program Name</th>
		            <th>Notes</th>
		        </tr>
		        <c:forEach var="program" items="${programs}">
		            <tr>
		                <td><c:out value="${program.id}"/></td>
		                <td><c:out value="${program.name}"/></td>
		                <td><c:out value="${program.note}"/></td>
		            </tr>
		        </c:forEach>
		    </table>
		</c:when>
        <c:when test="${action eq 'getById'}">
            <h2>Program Details</h2>
            <p>Program ID: <c:out value="${program.id}"/></p>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action eq 'add'}">
            <h2>Program Added Successfully</h2>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action eq 'update'}">
            <h2>Program Updated Successfully</h2>
            <p>Program ID: <c:out value="${program.id}"/></p>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action eq 'delete'}">
            <h2>Program Deleted Successfully</h2>
            <p>Deleted Program ID: <c:out value="${deletedProgramId}"/></p>
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