<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trainee Request Page</title>
</head>
<body>
    <h1>Trainee Request</h1>

    <c:choose>
        <c:when test="${action eq 'getById'}">
            <c:url var="getByIdUrl" value="/trainee/getById">
                <c:param name="id" value="${param.id}" />
            </c:url>
            <form action="${getByIdUrl}" method="get">
                <label for="id">Enter Trainee ID:</label>
                <input type="text" id="id" name="id" required>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'add'}">
            <c:url var="addUrl" value="/trainee/add"/>
            <form action="${addUrl}" method="post">
                <label for="name">Trainee Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="gender">Weight:</label>
                <input type="text" id="weight" name="weight" required>
                <label for="specialty">Height:</label>
                <input type="text" id="height" name="height" required>
                <label for="specialty">BMI:</label>
                <input type="text" id="bmi" name="bmi" required>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'update'}">
            <c:url var="updateUrl" value="/trainee/update"/>
            <form action="${updateUrl}" method="post">
                <label for="id">Trainee ID:</label>
                <input type="text" id="id" name="id" required>
                <label for="name">New Name:</label>
                <input type="text" id="name" name="name">
                <label for="gender">New Weight:</label>
                <input type="text" id="weight" name="weight" required>
                <label for="specialty">New Height:</label>
                <input type="text" id="height" name="height" required>
                <label for="specialty">New BMI:</label>
                <input type="text" id="bmi" name="bmi" required>
				<input type="submit" value="Submit">
			</form>
		</c:when>
		<c:when test="${action eq 'delete'}">
			<c:url var="deleteUrl" value="/trainee/delete"/>
			<form action="${deleteUrl}" method="post">
				<label for="id">Trainee ID to Delete:</label>
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