<%--
  Created by IntelliJ IDEA.
  User: marce
  Date: 29/11/2020
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./css/formularioCalendario.css">
    <title>Actualizar</title>
</head>
<body>

<section class="actualizar">
    <div class="container">
        <h2 class="container__title">Actualizar Evento</h2>
        <form class="container__form" action="Principal?accion=editar" method="post">
            <input class="input" type="text" name="id" readonly="readonly"
                   value="${calendario.idCalendario}">
            <input class="input" type="text" name="fechaRecibido"
                   value="${calendario.fechaRecibido}">
            <input class="input" type="text" name="fechaEntrega"
                       value="${calendario.fechaEntregado}">
            <input class="input" type="text" name="estado"
                       value="${calendario.estado}">
            <input class="input" type="text" name="idMantenimiento"
                       value="${calendario.idMantenimiento }">
            <input class="input" type="text" name="nombreUsuario"
                       value="${calendario.nombreUsuario }">
            <div class="container__button">
                <section class="container__button--button1">
                    <input class="button" type="submit" value="Actualizar Evento">
                </section>
            </div>
        </form>
    </div>
</section>
<script src="js/js.js"></script>
</body>
</html>
