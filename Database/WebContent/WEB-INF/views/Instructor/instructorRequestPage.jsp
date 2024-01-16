<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instructor Request Page</title>
</head>
<body>
    <h1>Instructor Request</h1>

    <c:choose>
        <c:when test="${action eq 'getById'}">
            <c:url var="getByIdUrl" value="/instructor/getById">
                <c:param name="id" value="${param.id}" />
            </c:url>
            <form action="${getByIdUrl}" method="get">
                <label for="id">Enter Instructor ID:</label>
                <input type="text" id="id" name="id" required>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'add'}">
            <c:url var="addUrl" value="/instructor/add"/>
            <form action="${addUrl}" method="post">
                <label for="name">Instructor Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="gender">Gender:</label>
                <input type="text" id="gender" name="gender" required>
                <label for="specialty">Specialty:</label>
                <input type="text" id="specialty" name="specialty" required>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'update'}">
            <c:url var="updateUrl" value="/instructor/update"/>
            <form action="${updateUrl}" method="post">
                <label for="id">Instructor ID:</label>
                <input type="text" id="id" name="id" required>
                <label for="name">New Name:</label>
                <input type="text" id="name" name="name">
                <label for="gender">New Gender:</label>
                <input type="text" id="gender" name="gender">
                <label for="specialty">New Specialty:</label>
                <input type="text" id="specialty" name="specialty">
				<input type="submit" value="Submit">
			</form>
		</c:when>
		<c:when test="${action eq 'delete'}">
			<c:url var="deleteUrl" value="/instructor/delete"/>
			<form action="${deleteUrl}" method="post">
				<label for="id">Instructor ID to Delete:</label>
				<input type="text" id="id" name="id" required>
				<input type="submit" value="Delete">
			</form>
		</c:when>
		<c:otherwise>
			<p>Invalid action specified.</p>
		</c:otherwise>
</c:choose>

</body>
</html>