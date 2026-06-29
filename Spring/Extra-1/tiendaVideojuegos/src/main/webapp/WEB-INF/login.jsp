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
			<form:input type="text" path="email" />
			<form:errors path="email" />
			
			<form:label path="password">Contraseña:</form:label>
			<form:input type="text" path="password" />
			<form:errors path="password" />
			
			<form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
			<form:input type="text" path="confirmarPassword" />
			<form:errors path="confirmarPassword" />
			
			<input type="submit" value="Registrarse" />
		</form:form>
		
		<form:form action="/login" method="POST" modelAttribute="usuarioLogin">
			<h2>Iniciar Sesión</h2>
			<form:label path="email">Correo Electrónico:</form:label>
			<form:input type="text" path="email" />
			<form:errors path="email" />
			
			<form:label path="password">Contraseña:</form:label>
			<form:input type="text" path="password" />
			<form:errors path="password" />
					
			<input type="submit" value="Iniciar Sesión">
		</form:form>
	</div>
</body>
</html>