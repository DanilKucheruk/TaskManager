<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="header.css">
</head>
<body>
    <div class="header">
        <button class="profile-button">Профиль</button>
        <div class="search-bar">
            <input type="text" placeholder="Поиск">
            <button class="search-button">Найти</button>
        </div>
        <form action="/web/logout" method="post">
            <button class="logout-button">Выход</button>
        </form>
    </div>
</body>
</html>


