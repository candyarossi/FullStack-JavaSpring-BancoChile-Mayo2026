<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Videojuego</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
   <h1>Agregar Videojuego</h1>
   <form action="/add" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre">

        <label for="descripcion">Descripcion:</label>
        <textarea name="descripcion"></textarea>

        <label for="portada">Portada:</label>
        <input type="url" name="portada">

        <label for="fecha_lanzamiento">Fecha de Lanzamiento:</label>
        <input type="date" name="fecha_lanzamiento">

        <label for="rating">Rating:</label>
        <input type="number" name="rating" min="0" max="5" step="0.5">

        <input type="submit" value="Crear Videojuego">
   </form>
   <a href="/getAll">Volver</a>
</body>
</html>