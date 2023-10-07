<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Вход</title>
<link rel="stylesheet" type="text/css" href="registration.css">
<meta charset="UTF-8">

</head>
<body>
	<div class="container">
		<h2>Вход</h2>
		<form action="/web/login" method="post">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Пароль:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<button type="submit">Войти</button>
			<div class="login-link">
				<a href="/web/registration">Регистрация</a>
			</div>
		</form>
	</div>
</body>
</html>
