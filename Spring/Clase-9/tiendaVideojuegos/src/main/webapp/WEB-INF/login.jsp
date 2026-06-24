<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
	<div class="content">
		<form:form action="/register" method="POST" modelAttribute="usuario">
			<h2>Registrarse</h2>
			<form:label path="nombre">Nombre:</form:label>
			<form:input type="text" path="nombre" />
			<form:errors path="nombre" />
			
			<form:label path="apellido">Apellido:</form:label>
			<form:input type="text" path="apellido" />
			<form:errors path="apellido" />
			
			<form:label path="email">Correo Electrónico:</form:label>
			<form:input type="email" path="email" />
			<form:errors path="email" />
			
			<form:label path="password">Contraseña:</form:label>
			<form:input type="text" path="password" />
			<form:errors path="password" />
			
			<form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
			<form:input type="text" path="confirmarPassword" />
			<form:errors path="confirmarPassword" />
			
			<input type="submit" value="Registrarse" />
		</form:form>
		
		<form action="/login" method="POST">
			<h2>Iniciar Sesión</h2>
			<label for="email">Correo Electrónico:</label>
			<input type="email" name="email">
					
			<label for="password">Contraseña:</label>
			<input type="text" name="password">
			<span>${errorPassword2}</span>
					
			<input type="submit" value="Iniciar Sesión">
		</form>
	</div>
</body>
</html>