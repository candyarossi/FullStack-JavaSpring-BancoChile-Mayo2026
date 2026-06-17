<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videojuegos</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
     <div class="nav">
		  <h3>&iexcl;Bienvenido ${usuario.nombre}&excl;</h3>
		  <h3 class="precio" id="coins">$ ${usuario.coins}</h3>
          <a href="/form/add">Crear Videojuego</a>
		  <a href="/logout">Salir</a>
     </div>

     <div class="content">
          <div class="vPlataforma">
               <h1>Mis Videojuegos</h1>
               <ul class="videojuegos">
               </ul>
          </div>

          <div class="vComunidad">
               <h1>Videojuegos de la Comunidad</h1>
               <ul class="videojuegos">
                    <c:forEach var="videojuego" items="${videojuegos}">
                         <li>
                              <img src="${videojuego.portada}">
                              <h3>${videojuego.nombre}</h3>
                              <a href="/detail/${videojuego.id}">Detalles</a>
                              <a class="precio" href="#">$ ${videojuego.precio}</a>
                         </li>
                    </c:forEach>
               </ul>
          </div>
     </div>
     <script src="/js/script.js"></script>
</body>
</html>