<%--
  Created by IntelliJ IDEA.
  User: marce
  Date: 29/11/2020
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/css/reset.css" />
    <link rel="stylesheet" type="text/css" href="css/css/main.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/css/tabla.css" media="screen" />
    <style>
    #table01 td{ padding-top: 8px; cursor: pointer}
    </style>
    <title>Mantenimiento</title>
</head>
<body>
    <form action="Principal?accion=registrar">
                    <input type="text" name="" placeholder="Titulo Actividad">
                    <input type="date" name="fechaRecibido" 
                            placeholder="Fecha Recibido aaaa/mm/dd">
                    <input type="date" name="fechaEntrega" 
                           placeholder="Fecha Entrega aaaa/mm/dd">
                    <input type="text" name="estado" 
                           placeholder="Estado">
                    <input type="number" name="idMantenimiento" 
                            placeholder="ID Mantenimiento">
                    <input type="text" name="nombreUsuario" 
                           placeholder="Nombre usuario">
                    <input type="submit" name="agregar" value="Agregar">
                    <span class="fa fa-plus-circle cursor-pointer add-event-day-field-btn"></span>
                </form>
    </div>
</body>
</html>
