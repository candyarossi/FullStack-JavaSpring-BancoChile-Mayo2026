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
		  <h3 class="precio" id="coins">$${usuario.coins}</h3>
            <c:if test="${miVideojuego == null}">
               <a href="/form/add">Crear Videojuego</a>
            </c:if>
		  <a href="/logout">Salir</a>
     </div>

     <div class="content">
          <div class="vPlataforma">
               <h1>Mis Videojuegos</h1>
               <ul class="videojuegos">
                    <c:forEach var="videojuego" items="${misComprados}">
                         <li>
                              <img src="${videojuego.portada}">
                              <h3>${videojuego.nombre}</h3>
                              <a href="/detail/${videojuego.id}">Detalles</a>
                              <c:if test="${videojuego.creador.id == usuario.id}">
                                   <a href="/form/edit/${videojuego.id}">Editar</a>
                                   <form action="/delete/${videojuego.id}" method="POST">
                                        <input type="hidden" name="_method" value="DELETE" />
                                        <button>Eliminar</button>
                                   </form>
                              </c:if>
                         </li>
                    </c:forEach>
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
                              <c:if test="${videojuego.creador.id != usuario.id}">
                                   <a class="precio" href="/buy/${videojuego.id}">$${videojuego.precio}</a>
                              </c:if>
                              <c:if test="${videojuego.creador.id == usuario.id}">
                                   <a href="/form/edit/${videojuego.id}">Editar</a>
                                   <form action="/delete/${videojuego.id}" method="POST">
                                        <input type="hidden" name="_method" value="DELETE" />
                                        <button>Eliminar</button>
                                   </form>
                              </c:if>
                         </li>
                    </c:forEach>
               </ul>
               <div class="paginador">
                    <c:forEach begin="1" end="${cantPaginas}" var="indice">
                         <a href="/getAll?page=${indice}">${indice}</a>
                    </c:forEach>
               </div>
          </div>
     </div>
     <script src="/js/script.js"></script>
</body>
</html>