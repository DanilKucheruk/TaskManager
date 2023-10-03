<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Проекты</title>
    <link rel="stylesheet" type="text/css" href="createProject.css">
</head>
<body>
	<div class = "create-project">
		<c:if test = "${sessionScope.user.getRole() eq 'ADMIN'}">
           <div class="create-project-button">
             <a href="/web/createproject">Создать проект</a>
             </div>
        </div>
		</c:if>
	</div>
</body>

</html>
