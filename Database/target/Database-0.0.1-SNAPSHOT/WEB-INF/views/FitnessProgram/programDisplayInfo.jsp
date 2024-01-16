<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Program Display Information</title>
</head>
<body>
    <h1>Program Information</h1>
    <c:choose>
        <c:when test="${action == 'getAll'}">
            <h2>All Programs</h2>
            <c:forEach var="program" items="${programs}">
                <!-- Display each program details -->
                <p>Program ID: <c:out value="${program.id}"/></p>
                <p>Program Name: <c:out value="${program.name}"/></p>
                <p>Notes: <c:out value="${program.note}"/></p>
            </c:forEach>
        </c:when>
        <c:when test="${action == 'getById'}">
            <h2>Program Details</h2>
            <p>Program ID: <c:out value="${program.id}"/></p>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action == 'add'}">
            <h2>Program Added Successfully</h2>
            <p>Program ID: <c:out value="${program.id}"/></p>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action == 'update'}">
            <h2>Program Updated Successfully</h2>
            <p>Program ID: <c:out value="${program.id}"/></p>
            <p>Program Name: <c:out value="${program.name}"/></p>
            <p>Notes: <c:out value="${program.note}"/></p>
        </c:when>
        <c:when test="${action == 'delete'}">
            <h2>Program Deleted Successfully</h2>
            <p>Deleted Program ID: <c:out value="${deletedProgramId}"/></p>
        </c:when>
        <c:otherwise>
            <h2>Unknown Action</h2>
            <p>No information is available for the action performed.</p>
    	</c:otherwise>
	</c:choose>
</body>
</html>