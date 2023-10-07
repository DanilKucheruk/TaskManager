<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Проекты</title>
    <link rel = "stylesheet" type="text/css" href="projects.css">
</head>
<body>
	<div class = "create-project">
		<c:if test = "${sessionScope.user.getRole() eq 'ADMIN'}">
           <div class="create-project-button">
             <a href="/web/createproject">Создать проект</a>
             </div>
		</c:if>
	</div>
	<div class="projects-menu">
		<c:forEach items="${projectIdAndNames}" var="entry" >
		    <a href="/web/project?projectId=${entry.key}">
		      <c:out value="${entry.value}" />
		    </a>
		</c:forEach>
	</div>

</body>

</html>
