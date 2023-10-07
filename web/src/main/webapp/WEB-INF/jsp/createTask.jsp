<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Создание задачи</title>
<link rel="stylesheet" type="text/css" href="createProjectForm.css">
</head>
<body>
	<h1>Созадние задачи</h1>
	<form action="/web/createtask" method="post">

		<label for="title">Задача:</label>
		<textarea id="title" name="title" required></textarea>
		<br> <label for="date">Крайний срок:</label> <input type="date"
			id="date" name="date" required><br>
		<button>Создать проект</button>
	</form>
</body>
</html>