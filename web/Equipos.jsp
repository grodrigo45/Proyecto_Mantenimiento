<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Conexion.ConexionMantto"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.EquiposBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.EquiposDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Equipos</title>
        <link rel="stylesheet" type="text/css" href="./css/crudUser.css">
    </head>
    <body>

        <nav class="navMenu bShadow-2">
            <img src="https://www.flaticon.com/svg/static/icons/svg/3571/3571518.svg" alt="ICON">
            <div class="link-1 ">
                <a href="Principal?accion=mostrar">Actividades</a>
                <div class="calendar bShadow-3 ">
                    <a href="calendario.jsp">Agregar</a>
                </div>
            </div>

            <div class="link-1">
                <a href="Equipos.jsp">Productos</a>
                <div class="calendar bShadow-3 ">
                    <a href="Principal?accion=insertar">Agregar Producto</a>
                    <a href="Principal?accion=eliminar">Eliminar Producto</a>
                    <a href="Principal?accion=modificar">Actualizar Producto</a>
                    <a href="Proveedor.jsp">Proveedores</a>
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
                <a href="empleados.jsp">Empleados</a>
                <div class="calendar bShadow-3">
                    <a href="Principal?accion=insertarEmpleado">Agregar</a>
                    <a href="Principal?accion=eliminarEmpleado">Eliminar</a>
                    <a href="Principal?accion=actualizarEmpleado">Actualizar</a>
                </div>
            </div>

            <div class="link-1">
                <a href=""><img src="https://www.flaticon.com/svg/static/icons/svg/3530/3530223.svg" alt="USER"></a>
                <div class="calendar bShadow-3">
                    <a href="perfil.jsp">Configuracion</a>
                    <a href="AcercaDe.jsp">A cerca de</a>
                    <a href="#">Cerrar sesion</a>
                </div>
            </div>

        </nav>

        <div class="content">

            <h1 class="title"> Productos </h1>

            <div class="menu-box">
                <div class="box1 bShadow-2 bShadow-5h">
                    <div class="boxTxt">
                        <% Connection con;
                            ConexionMantto cn = new ConexionMantto();
                            con = cn.getConnection();
                            EquiposBean equipo = null;
                            //mostrar el total de registros
                            String sql = "SELECT COUNT(*) AS Total FROM Productos";
                            Statement statement = con.createStatement();
                            ResultSet rs = statement.executeQuery(sql);

                            if (rs.next()) {
                                int total = rs.getInt("Total");
                                equipo = new EquiposBean(total);
                            } else {
                                System.out.println("Ningun resultado encontrado");
                            }
                            con.close();
                            rs.close();
                        %>
                        <p>Total de equipos</p>
                        <h2><%= equipo.getTotal()%></h2>
                    </div>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>
            </div>
            <div class="table">
                <table>
                    <tr class="col-t">
                        <th>ID Producto</th>
                        <th>Nombre Producto</th>
                        <th>Descripcion</th>
                        <th>Id Proveedor</th>
                    </tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr><tr></tr>
                    <tr></tr>
                    <%
                        EquiposDao dao = new EquiposDao();
                        List<EquiposBean> list = dao.listarEquipos();
                        Iterator<EquiposBean> iter = list.iterator();
                        EquiposBean equipos = null;
                        while (iter.hasNext()) {
                            equipos = iter.next();

                    %>
                    <tr class="col-t">
                        <td><%= equipos.getIdProducto()%></td>
                        <td><%= equipos.getNombreProd()%></td>
                        <td><%= equipos.getDescripcion()%></td>
                        <td><%= equipos.getIdProveedor()%></td>
                    </tr>
                    <%}%>
                </table>

            </div>
        </div>
    </body>
</html>