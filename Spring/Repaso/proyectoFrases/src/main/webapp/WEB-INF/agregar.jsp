<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Frase</title>
</head>
<body>
    <ul>
        <li><a href="/favoritos">Mis Favoritos</a></li>
        <li><a href="/frases">Todas las Frases</a></li>
        <li><a href="/form/add">Agregar Frase</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>

    <h1>Frases</h1>
    <h2>Agregar Frase</h2>

    <form:form action="/add" method="POST" modelAttribute="frase">
    
        <form:label path="texto">Frase:</form:label>
        <form:input path="texto" type="text" />
        <form:errors path="texto" />

        <form:label path="autor">Autor original:</form:label>
        <form:input path="autor" type="text" />
        <form:errors path="autor" />

        <form:label path="categoria">Categoría/tema:</form:label>
        <form:input path="categoria" type="text" />
        <form:errors path="categoria" />

        <form:label path="idioma">Idioma:</form:label>
        <form:input path="idioma" type="text" />
        <form:errors path="idioma" />

        <input type="hidden" value="${idUsuario}" name="creador" />

        <input type="submit" value="Agregar" />
    </form:form>
</body>
</html>
