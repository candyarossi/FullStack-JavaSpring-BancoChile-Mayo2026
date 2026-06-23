<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Videojuegos</title>
</head>
<body>
    <h1>¡Hola Mundo!</h1>

    <%! 
        double descuento = 0.1;

        double aplicarDescuento(double precio){
            return precio * descuento;
        }

        double precioFinal = aplicarDescuento(12.0);
    %>

    <p> <%= precioFinal %> </p>

    <ul>
        <% for(int i = 0; i < 10; i++){ %>
            <li> <%= i %> </li>
        <% } %>
    </ul>
</body>
</html>