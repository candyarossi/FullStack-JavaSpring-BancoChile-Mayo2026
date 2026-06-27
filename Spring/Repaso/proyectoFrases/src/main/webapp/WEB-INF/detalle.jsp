<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Frase</title>
</head>
<body>
    <ul>
        <li><a href="/favoritos">Mis Favoritos</a></li>
        <li><a href="/frases">Todas las Frases</a></li>
        <li><a href="/form/add">Agregar Frase</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>

    <h1>Frases</h1>
    <h2>"${frase.texto}"</h2>

    <ul>
        <li>¿Quién agregó esta frase? <b>${frase.creador.nombre} ${frase.creador.apellido}</b></li>
        <li>Autor de la frase: <b>${frase.autor}</b></li>
        <li>Categoría/tema de la frase: <b>${frase.categoria}</b></li>
        <li>Idioma de la frase: <b>${frase.idioma}</b></li>
    </ul>

    <form:form action="/delete/${frase.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE" />
        <input type="submit" value="Eliminar frase" />
    </form:form>

</body>
</html>