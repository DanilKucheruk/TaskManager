<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${projectName}</title>
<link href="showProject.css" rel="stylesheet" type="text/css">
</head>
<body>
	<p>Имя проекта : ${projectName}</p>
	<p>Описание : ${projectDesc}</p>
	<p>Крайний срок проека : ${deadline}</p>
	<div class="create-task">
		<div class="create-task-button">
			<a href="/web/createtask">Создать задачу</a>
		</div>
	</div>
	<div class="task-menu">
		<c:forEach items="${tasks}" var="entry">
			<div class="task">
				<p>
					<c:out value="${entry.getTitle()}" />
				</p>
				<c:out value="${entry.getDeadline()}" />
				</p>
				<form action="/web/deletetask" method="post">
					<input type="hidden" name="taskId" value="${entry.getId()}" /> <input
						type="hidden" name="projectId" value="${projectId}" />
					<button>Удалить задачу</button>
				</form>
			</div>
		</c:forEach>
	</div>
	<form action="/web/deleteproject" method="post">
		<input type="hidden" name="projectId" value="${projectId}" />
		<button>УДАЛИТЬ ПРОЕКТ</button>
	</form>
</body>
</html>
