<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
</head>
<body>
    <ul>
        <li><a href="/">Login</a></li>
        <li><a href="/form/registro">Registro</a></li>
    </ul>

    <h1>Frases</h1>
    <h2>Registrarse</h2>

    <form:form action="/registro" method="POST" modelAttribute="usuario">

        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre" type="text" />
        <form:errors path="nombre" />

        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido" type="text" />
        <form:errors path="apellido" />

        <form:label path="correo">Correo Electrónico:</form:label>
        <form:input path="correo" type="text" />
        <form:errors path="correo" />

        <form:label path="password">Contraseña:</form:label>
        <form:input path="password" type="text" />
        <form:errors path="password" />

        <form:label path="confirmarPassword">Confirmar contraseña:</form:label>
        <form:input path="confirmarPassword" type="text" />
        <form:errors path="confirmarPassword" />

        <input type="submit" value="Registrarse" />
    </form:form>
</body>
</html>
