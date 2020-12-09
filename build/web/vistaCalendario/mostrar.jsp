<%--
  Created by IntelliJ IDEA.
  User: marce
  Date: 29/11/2020
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexion.ConexionMantto"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.CalendarioDao"%>
<%@page import="beans.CalendarioBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lista~Evento</title>
        <link rel="stylesheet" type="text/css" href="./css/crudUser.css">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
                     <a href="Mantenimiento.jsp">Mantenimiento</a>
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
                <a href="Cliente?accion=listar">Clientes</a>
                <div class="calendar bShadow-3 ">
                    <a href="Cliente?accion=add">Agregar</a>
                    <a href="Cliente?accion=eliminarCliente">Eliminar</a>
                    <a href="Cliente?accion=modificarCliente">Actualizar</a>
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
            <div class="link-1">
                <a href="empleados.jsp">Empleados</a>
                <div class="calendar bShadow-3">
                    <a href="Principal?accion=insertarEmpleado">Agregar</a>
                    <a href="Principal?accion=eliminarEmpleado">Eliminar</a>
                    <a href="Principal?accion=actualizarEmpleado">Actualizar</a>
                </div>
            </div>
        </nav>

        <div class="content">

            <h1 class="title"> Calendario de Eventos </h1>

            <div class="menu-box">
                <div class="box1 bShadow-2 bShadow-5h">
                    <div class="boxTxt">
                        <p>Eventos Totales</p>

                        <% Connection con;
                            ConexionMantto cn = new ConexionMantto();
                            con = cn.getConnection();
                            CalendarioBean calendario = null;
                            //mostrar el total de registros
                            String sql = "SELECT COUNT(*) AS Total FROM Calendario_Actividades";
                            Statement statement = con.createStatement();
                            ResultSet rs = statement.executeQuery(sql);

                            if (rs.next()) {
                                int total = rs.getInt("Total");
                                calendario = new CalendarioBean(total);
                            } else {
                                System.out.println("Ningun resultado encontrado");
                            }
                            con.close();
                            rs.close();
                        %>
                        <h2><%= calendario.getTotal()%></h2>
                    </div>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>

                <div class="box2 bShadow-2 bShadow-5h">
                    <p>Eventos Finalizados</p>
                    <% Connection conF;
                        ConexionMantto cnF = new ConexionMantto();
                        conF = cnF.getConnection();

                        //mostrar el total de registros de eventos finalizados
                        String sqlF = "SELECT COUNT(*) AS Finalizado FROM Calendario_Actividades "
                                + "WHERE Estado='Finalizado' ";
                        Statement statementF = conF.createStatement();
                        ResultSet rsF = statementF.executeQuery(sqlF);

                        if (rsF.next()) {
                            int Finalizado = rsF.getInt("Finalizado");
                            calendario.setFinalizado(Finalizado);
                        } else {
                            System.out.println("Ningun resultado encontrado");
                        }
                        conF.close();
                        rsF.close();
                    %>
                    <h2><%= calendario.getFinalizado()%></h2>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>

                <div class="box3 bShadow-2">
                    <p>Eventos Sin Iniciar</p>
                    <% Connection conS;
                        ConexionMantto cnS = new ConexionMantto();
                        conS = cnS.getConnection();

                        //mostrar el total de registros sin comenzar
                        String sqlS = "SELECT COUNT(*) AS Sin_Iniciar FROM Calendario_Actividades "
                                + "WHERE Estado='Sin iniciar' ";
                        Statement statementS = conS.createStatement();
                        ResultSet rsS = statementS.executeQuery(sqlS);

                        if (rsS.next()) {
                            int sinIniciar = rsS.getInt("Sin_Iniciar");
                            calendario.setSinIniciar(sinIniciar);
                        } else {
                            System.out.println("Ningun resultado encontrado");
                        }
                        conS.close();
                        rsS.close();
                    %>
                    <h2><%= calendario.getSinIniciar()%></h2>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>

                <div class="box4 bShadow-2 bShadow-5h">
                    <p>Eventos En Proceso</p>
                    <% Connection conP;
                        ConexionMantto cnP = new ConexionMantto();
                        conP = cnP.getConnection();

                        //mostar los registros que estan en proceso
                        String sqlE = "SELECT COUNT(*) AS Proceso FROM Calendario_Actividades "
                                + "WHERE Estado='Proceso' ";
                        Statement statementP = conP.createStatement();
                        ResultSet rsE = statementP.executeQuery(sqlE);

                        if (rsE.next()) {
                            int proceso = rsE.getInt("Proceso");
                            calendario.setEnProceso(proceso);
                        } else {
                            System.out.println("Ningun resultado encontrado");
                        }
                        conP.close();
                        rsE.close();
                    %>
                    <h2><%= calendario.getEnProceso()%></h2>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>
            </div>

            <div class="table">

                <table>
                    <tr class="col-t">
                        <th>IdCalendario</th>
                        <th>Fecha Recibido</th>
                        <th>Fecha Entregado</th>
                        <th>Estado</th>
                        <th>Codigo Mantenimiento</th>
                        <th>Usuario</th>
                        <th colspan=2>ACCIONES</th>
                    </tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <c:forEach var="calendario" items="${lista}">
                        <tr class="col-t">
                            <td><c:out value="${calendario.idCalendario}"/></td>
                            <td><c:out value="${calendario.fechaRecibido}"/></td>
                            <td><c:out value="${calendario.fechaEntregado}"/></td>
                            <td><c:out value="${calendario.estado}"/></td>
                            <td><c:out value="${calendario.idMantenimiento}"/></td>
                            <td><c:out value="${calendario.nombreUsuario}"/></td>
                            <td><a class="btn btn-warning" href="Principal?accion=showedit&id=<c:out value="${calendario.idCalendario}"/>">Editar</a></td>
                            <td><a class="btn btn-danger" href="Principal?accion=eliminarCalendario&id=<c:out value="${calendario.idCalendario}"/>">Eliminar</a> </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <script async src="js/js.js"></script>
    </body>
</html>
