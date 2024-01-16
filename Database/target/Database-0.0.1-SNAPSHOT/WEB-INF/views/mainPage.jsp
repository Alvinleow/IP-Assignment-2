<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fitness Program Main Page</title>
    <!-- You can add CSS or JS here if needed -->
</head>
<body>
    <h1>Welcome to the Fitness Program Application</h1>
    <p>Select an action:</p>
    <ul>
        <li><a href="program/getAll">Get All Programs</a></li>
        <li><a href="views/FitnessProgram/programRequestPage.jsp?action=getById">Get Program by ID</a></li>
        <li><a href="views/FitnessProgram/programRequestPage.jsp?action=add">Add New Program</a></li>
        <li><a href="views/FitnessProgram/programRequestPage.jsp?action=update">Update a Program</a></li>
        <li><a href="views/FitnessProgram/programRequestPage.jsp?action=delete">Delete a Program</a></li>
    </ul>
</body>
</html>

