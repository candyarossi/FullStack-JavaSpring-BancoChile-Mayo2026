<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle Videojuego</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div id="detalle">
        <div>
            <img src="${videojuego.portada}">
            <div>
                <h1>${videojuego.nombre}</h1>
                <ul>
                    <li>Rating: <b>${videojuego.rating}</b><span>&#9733;</span></li>
                    <li>Fecha de Lanzamiento: <b>${videojuego.fecha_lanzamiento}</b></li>
                    <c:if test="${videojuego.creador.id != null}">
                        <li>Creador: <b>${videojuego.creador.nombre} ${videojuego.creador.apellido}</b></li>
                    </c:if>
                </ul>
            </div>
        </div>
        <p>${videojuego.descripcion}</p>

        <c:if test="${fn:length(videojuego.resenas) > 0}">
            <h4>Reseñas:</h4>
            <ul class="resenas">
                <c:forEach var="resena" items="${videojuego.resenas}">
                    <li>${resena.mensaje}</li>
                </c:forEach>
            </ul>
        </c:if>

        <form:form action="/comment" method="POST" modelAttribute="resena">
            <input type="hidden" value="${videojuego.id}" name="videojuego" />

            <form:label path="mensaje">Escribe tu reseña:</form:label>
            <form:textarea path="mensaje"></form:textarea>
            <form:errors path="mensaje" />

            <input type="submit" value="Enviar" />
        </form:form>

        <a href="/getAll?page=1">Volver</a>
    </div>
</body>
</html>