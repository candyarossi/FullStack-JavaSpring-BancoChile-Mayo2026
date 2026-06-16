<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

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
                </ul>
            </div>
        </div>
        <p>${videojuego.descripcion}</p>
        <a href="/getAll">Volver</a>
    </div>
</body>
</html>