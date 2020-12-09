<%--
  Created by IntelliJ IDEA.
  User: marce
  Date: 5/11/2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calendario - Developer</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="bower/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/calendario.css">
</head>
<body>

    <nav class="navMenu bShadow-2">
        <img src="https://www.flaticon.com/svg/static/icons/svg/3571/3571518.svg" alt="ICON">
        <div class="link-1 ">
            <a href="#" onclick="regresar()">Regresar</a>
        </div>
        
        <a href=""><img src="https://www.flaticon.com/svg/static/icons/svg/3530/3530223.svg" alt="USER"></a>
    </nav>

    <div class="calendar disable-selection" id="calendar">
        <div class="left-side">
            <!-- mostrar dia lado izq-->
            <div class="current-day text-center">
                <h1 class="calendar-left-side-day"></h1>
                <div class="calendar-left-side-day-of-week"></div>
            </div>
            <div class="current-day-events">
                <div>Lista de Actividades:</div>
                <!-- lista de eventos guardados -->
                <ul class="current-day-events-list"></ul>
            </div>
            <!-- agregar enventos -->
            <div class="add-event-day">
                <form action="Principal?accion=registrar" method="post">
                    <input type="text" name="" class="add-event-day-field" placeholder="Titulo Actividad">
                    <input type="text" name="fechaRecibido" 
                           class="add-event-day-field" placeholder="Fecha Recibido aaaa/mm/dd">
                    <input type="text" name="fechaEntrega" 
                           class="add-event-day-field" placeholder="Fecha Entrega aaaa/mm/dd">
                    <input type="text" name="estado" 
                           class="add-event-day-field" placeholder="Estado">
                    <input type="number" name="idMantenimiento" 
                           class="add-event-day-field" placeholder="ID Mantenimiento(5000)">
                    <input type="text" name="nombreUsuario" 
                           class="add-event-day-field" placeholder="Nombre usuario">
                    <input class="fa fa-plus-circle cursor-pointer add-event-day-field-btn"
                           type="submit" name="agregar" value="Agregar">
                    <span class="fa fa-plus-circle cursor-pointer add-event-day-field-btn"></span>
                </form>
            </div>
        </div>
        <div class="right-side">
            <div class="text-right calendar-change-year">
                <div class="calendar-change-year-slider">
                    <span class="fa fa-caret-left cursor-pointer calendar-change-year-slider-prev"></span>
                    <span class="calendar-current-year"></span>
                    <span class="fa fa-caret-right cursor-pointer calendar-change-year-slider-next"></span>
                </div>
            </div>
            <div class="calendar-month-list">
                <ul class="calendar-month"></ul>
            </div>
            <div class="calendar-week-list">
                <ul class="calendar-week"></ul>
            </div>
            <div class="calendar-day-list">
                <!--crea los dias del bucle-->
                <ul class="calendar-days"></ul>
                <!--si hay eventos muestra un punto-->
            </div>
        </div>
    </div>

<script async src="js/js.js"></script>
</body>
</html>