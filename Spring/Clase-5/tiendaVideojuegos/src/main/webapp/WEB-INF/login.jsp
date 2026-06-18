<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h2>Registrarse</h2>
	<form action="/register" method="POST">
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre">
		
		<label for="apellido">Apellido:</label>
		<input type="text" name="apellido">
		
		<label for="email">Correo Electrónico:</label>
		<input type="email" name="email">
		
		<label for="password">Contraseña:</label>
		<input type="text" name="password">
		<span>${errorPassword1}</span>
		
		<input type="submit" value="Registrarse">
	</form>
	
	<h2>Iniciar Sesión</h2>
	<form action="/login" method="POST">
		<label for="email">Correo Electrónico:</label>
		<input type="email" name="email">
				
		<label for="password">Contraseña:</label>
		<input type="text" name="password">
		<span>${errorPassword2}</span>
				
		<input type="submit" value="Iniciar Sesión">
	</form>
</body>
</html>