<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Program Request Page</title>
</head>
<body>
    <h1>Program Request</h1>

    <c:choose>
        <c:when test="${action eq 'getById'}">
            <c:url var="getByIdUrl" value="/program/getById">
                <c:param name="id" value="${param.id}" />
            </c:url>
            <form action="${getByIdUrl}" method="get">
                <label for="id">Enter Program ID:</label>
                <input type="text" id="id" name="id" required>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'add'}">
            <c:url var="addUrl" value="/program/add"/>
            <form action="${addUrl}" method="post">
                <label for="name">Program Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="note">Notes:</label>
                <textarea id="note" name="note"></textarea>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'update'}">
            <c:url var="updateUrl" value="/program/update"/>
            <form action="${updateUrl}" method="post">
                <label for="id">Program ID:</label>
                <input type="text" id="id" name="id" required>
                <label for="name">New Name:</label>
                <input type="text" id="name" name="name">
                <label for="note">New Notes:</label>
                <textarea id="note" name="note"></textarea>
                <input type="submit" value="Submit">
            </form>
        </c:when>
        <c:when test="${action eq 'delete'}">
            <c:url var="deleteUrl" value="/program/delete"/>
            <form action="${deleteUrl}" method="post">
                <label for="id">Program ID to Delete:</label>
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