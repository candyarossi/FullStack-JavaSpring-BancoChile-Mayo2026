<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <ul>
        <li><a href="/">Login</a></li>
        <li><a href="/form/registro">Registro</a></li>
    </ul>

    <h1>Frases</h1>
    <h2>Login</h2>

    <form:form action="/login" method="POST" modelAttribute="usuarioLogin">

        <form:label path="correo">Correo Electrónico:</form:label>
        <form:input path="correo" type="text" />
        <form:errors path="correo" />

        <form:label path="password">Contraseña:</form:label>
        <form:input path="password" type="text" />
        <form:errors path="password" />

        <input type="submit" value="Login" />
    </form:form>
</body>
</html>