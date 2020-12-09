<%-- 
    Document   : Mantenimiento
    Created on : 12-08-2020, 12:02:45 AM
    Author     : marce
--%>

<%@page import="java.util.Iterator"%>
<%@page import="beans.MantenimientoBean"%>
<%@page import="java.util.List"%>
<%@page import="dao.MantenimientoDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista~Evento</title>
        <link rel="stylesheet" type="text/css" href="./css/crudUser.css">
    </head>
    <body>
        <nav class="navMenu bShadow-2">
            <img src="https://www.flaticon.com/svg/static/icons/svg/3571/3571518.svg" alt="ICON">

            <div class="link-1 ">
                <a href="#" onclick="regresar()">Regresar</a>
            </div>

            <div class="link-1 ">
                <a href="#">Actividades</a>
                <div class="calendar bShadow-3 ">
                    <a href="empleados.jsp">Inicio</a>
                    <a href="Principal?accion=registrar">Ingresar Evento</a>
                </div>
            </div>

            <div class="link-1">
                <a href="Equipos.jsp">Productos</a>
                <div class="calendar bShadow-3 ">
                    <a href="Equipos.jsp">Equipos</a>
                    <a href="#">Eliminar</a>
                    <a href="#">Actualizar</a>
                </div>
            </div>

            <div class="link-1">
                <a href="#">Clientes</a>
                <div class="calendar bShadow-3 ">
                    <a href="#">Agregar</a>
                    <a href="#">Eliminar</a>
                    <a href="#">Actualizar</a>
                </div>
            </div>

            <div class="link-1">
                <a href="#">Empleados</a>
                <div class="calendar bShadow-3">
                    <a href="#">Agregar</a>
                    <a href="#">Eliminar</a>
                    <a href="#">Actualizar</a>
                </div>
            </div>
            <a href=""><img src="https://www.flaticon.com/svg/static/icons/svg/3530/3530223.svg" alt="USER"></a>
        </nav>

        <!-- Java aqui -->

        <div class="table">
            <table>
                <tr class="col-t">
                    <th>IdMantenimineto</th>
                    <th>Descripcion</th>
                    <th>IdEmpleado</th>
                    <th>IdProducto</th>
                    <th>IdTipoMantenimiento</th>
                </tr>
                <tr></tr><tr></tr>
                <tr></tr><tr></tr>
                <tr></tr><tr></tr>
                <tr></tr><tr></tr>
                <tr></tr><tr></tr>
                <tr></tr><tr></tr>
                <%
                    MantenimientoDao dao = new MantenimientoDao();
                    List<MantenimientoBean> list = dao.listarMantenimiento();
                    Iterator<MantenimientoBean> iter = list.iterator();
                    MantenimientoBean mantto = new MantenimientoBean();
                    while (iter.hasNext()) {
                        mantto = iter.next();

                %>
                <tr class="col-t">
                    <td><%= mantto.getIdMantenimiento()%></td>
                    <td><%= mantto.getDescripcion()%></td>
                    <td><%= mantto.getIdEmpleado()%></td>
                    <td><%= mantto.getIdProducto()%></td>
                    <td><%= mantto.getIdTipoMantto()%></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>
    <script async src="js/js.js"></script>
</body>
