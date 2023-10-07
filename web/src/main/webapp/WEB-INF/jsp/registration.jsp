<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Регистрация</title>
<link rel="stylesheet" type="text/css" href="registration.css">
<meta charset="UTF-8">

</head>
<body>
	<div class="container">
		<h2>Регистрация</h2>
		<form action="/web/registration" method="post">
			<div class="form-group">
				<label for="name">Имя:</label> <input type="text" id="name"
					name="name" required>
			</div>
			<div class="form-group">
				<label for="last_name">Фамилия:</label> <input type="text"
					id="last-name" name="last-name" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="role">Роль:</label> <select name="role" id="role">
					<option value=${requestScope.roles[0]}>
						${requestScope.roles[0]}</option>
					<option value=${requestScope.roles[1]}>${requestScope.roles[1]}</option>
				</select></br>
			</div>
			<div class="form-group">
				<label for="department-code">Код отдела: </label> <input type="text"
					id="department-code" name="department-code" required>
			</div>
			<div class="form-group">
				<label for="password">Пароль:</label> <input type="password"
					id="password" name="password" required>
			</div>

			<button type="submit">Зарегистрироваться</button>
			<div class="login-link">
				<a href="/web/login">Войти</a>
			</div>
		</form>
	</div>
</body>
</html>
