<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Создание проекта</title>
    <link rel="stylesheet" type="text/css" href="createProjectForm.css">
</head>
<body>
    <h1>Созадние проекта</h1>
    <form action="/web/createproject" method="post">
        <label for="name">Название:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="description">Описание:</label>
        <textarea id="description" name="description" required></textarea><br>

        <label for="date">Крайний срок:</label>
        <input type="date" id="date" name="date" required><br>
        
		<label for=responsible>Ответственный:</label>
		
		 <form action="processForm" method="post">
        <select name="responsible">
            <c:forEach items="${usersFullNamesList}" var="user">
                <option value="${user}">${user}</option>
            </c:forEach>
        </select>
        <button href= "web/projects">Создать проект</button>
     	
    </form>
</body>
</html>