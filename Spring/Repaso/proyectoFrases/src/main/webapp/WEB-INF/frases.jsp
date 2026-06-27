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
    <title>Frases</title>
</head>
<body>
    <ul>
        <li><a href="/favoritos">Mis Favoritos</a></li>
        <li><a href="/frases">Todas las Frases</a></li>
        <li><a href="/form/add">Agregar Frase</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>

    <h1>Frases</h1>
    <h2>Bienvenido de vuelta ${nombreCompletoUsuario}</h2>

    <table border="1">
        <thead>
            <th>Frase Motivacional</th>
            <th>Detalle</th>
            <th>Modificar</th>
            <th>Me Gusta</th>
        </thead>
        <tbody>
            <c:forEach var="frase" items="${frases}">
                <tr>
                    <td>${frase.texto}</td>
                    <td><a href="/detail/${frase.id}">Ver</a></td>
                    <td>
                        <c:if test="${idUsuario == frase.creador.id}">
                            <a href="/form/edit/${frase.id}">Editar</a>
                        </c:if>
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>