<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    
    <style>
    	body {
    		background-color: #9ef2ff;
    	}
        .container {
            display: flex;
            justify-content: space-between;
        }
        .section {
            flex: 1;
            margin: 10px;
            padding: 10px;
            border: 2px solid black;
        }
    </style>
    
</head>
<body>
	<div class="container">
        <div class="section">
		    <h1>Fitness Program</h1>
		    <p>Select an action:</p>
		    <ul>
		        <li><a href="program/getAll">Get All Programs</a></li>
		        <li><a href="program/requestById">Get Program by ID</a></li>
		        <li><a href="program/requestAdd">Add New Program</a></li>
		        <li><a href="program/requestUpdate">Update a Program</a></li>
		        <li><a href="program/requestDelete">Delete a Program</a></li>
		    </ul>
		</div>
		
		<div class="section">
		    <h1>Intructor</h1>
		    <p>Select an action:</p>
		    <ul>
				<li><a href="instructor/getAll">Get All Instructor</a></li>
		        <li><a href="instructor/requestById">Get Instructor by ID</a></li>
		        <li><a href="instructor/requestAdd">Add New Instructor</a></li>
		        <li><a href="instructor/requestUpdate">Update an Instructor</a></li>
		        <li><a href="instructor/requestDelete">Delete an Instructor</a></li>
		    </ul>
		</div>
		
		<div class="section">
		    <h1>Trainee</h1>
		    <p>Select an action:</p>
		    <ul>
				<li><a href="trainee/getAll">Get All Trainee</a></li>
		        <li><a href="trainee/requestById">Get Trainee by ID</a></li>
		        <li><a href="trainee/requestAdd">Add New Trainee</a></li>
		        <li><a href="trainee/requestUpdate">Update an Trainee</a></li>
		        <li><a href="trainee/requestDelete">Delete an Trainee	</a></li>
		    </ul>
		</div>
	</div>
</body>
</html>

