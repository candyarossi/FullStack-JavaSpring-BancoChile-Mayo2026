<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videojuegos</title>
</head>
<body>
   
   <%--<p>
        <c:out value="${mensaje}"/>
   </p>
   <p>
        ${mensaje}
   </p>

   <c:if test="${numero > 0}">
        <p>El número es positivo.</p>
   </c:if>

   <ul>
        <c:forEach var="item" items="${lista}">
            <li>${item.nombre}</li>
        </c:forEach>
   </ul>--%>

   <h1>Videojuegos</h1>

   <ul>
        <c:forEach var="videojuego" items="${videojuegos}">
            <li>Nombre: <b>${videojuego.nombre}</b>, Fecha de Lanzamiento: <b>${videojuego.fecha_lanzamiento}</b></li>
        </c:forEach>
   </ul>
</body>
</html>