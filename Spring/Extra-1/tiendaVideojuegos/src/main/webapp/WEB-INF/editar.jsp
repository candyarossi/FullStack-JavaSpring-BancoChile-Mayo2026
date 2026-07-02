<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Videojuego</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h1>Editar Videojuego</h1>
    <div class="content">
        <div id="imgEdit">
            <img src="${videojuego.portada}" />
        </div>
        <form:form action="/edit" method="POST" modelAttribute="videojuego">
                <input type="hidden" name="_method" value="PUT" />

                <input type="hidden" value="${videojuego.id}" name="id" />
                <input type="hidden" value="${videojuego.precio}" name="precio" />

                <form:label path="nombre">Nombre:</form:label>
                <form:input type="text" path="nombre"/>
                <form:errors class="error" path="nombre"/>

                <form:label path="descripcion">Descripcion:</form:label>
                <form:textarea path="descripcion"></form:textarea>
                <form:errors class="error" path="descripcion"/>

                <form:label path="portada">Portada:</form:label>
                <form:input type="text" path="portada"/>
                <form:errors class="error" path="portada"/>

                <form:label path="fecha_lanzamiento">Fecha de Lanzamiento:</form:label>
                <form:input type="date" path="fecha_lanzamiento"/>
                <form:errors class="error" path="fecha_lanzamiento"/>

                <form:label path="rating">Rating:</form:label>
                <form:input type="number" path="rating" step="0.5"/>
                <form:errors class="error" path="rating"/>

                <input type="hidden" value="${usuario.id}" name="creador" />

                <input type="submit" value="Editar Videojuego">
        </form:form>
    </div>
    <a href="/getAll?page=1">Volver</a>
</body>
</html>