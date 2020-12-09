<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="beans.EquiposBean"%>
<%@page import="beans.EquiposBean"%>
<%@page import="Conexion.ConexionMantto"%>
<%@page import="Conexion.ConexionMantto"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="beans.ClienteBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/crudUser.css">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>CLIENTES</title>

        <style>
            #add{
                float:right;
            }
        </style>
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
            </div>        </nav>

        <div class="content">

            <div>
                <h1 class="title"> Clientes </h1>
            </div>
            <br>
            <div class="menu-box">
                <div class="box1 bShadow-2 bShadow-5h">
                    <div class="boxTxt">
                        <% Connection con;
                            ConexionMantto cn = new ConexionMantto();
                            con = cn.getConnection();
                            ClienteBean cliente = null;
                            //mostrar el total de registros
                            String sql = "SELECT COUNT(*) AS Total FROM Cliente;";
                            Statement statement = con.createStatement();
                            ResultSet rs = statement.executeQuery(sql);

                            if (rs.next()) {
                                int total = rs.getInt("Total");
                                cliente = new ClienteBean(total);
                            } else {
                                System.out.println("Ningun resultado encontrado");
                            }
                            con.close();
                            rs.close();
                        %>
                        <p>Total de equipos</p>
                        <h2><%= cliente.getTotalC()%></h2>
                    </div>
                    <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
                </div>
            </div>  
            <div class="table">
                <table >
                    <thead>
                        <tr>
                            <th class="text-center">Código</th>
                            <th class="text-center">Nombre</th>
                            <th class="text-center">Apellido</th>
                            <th class="text-center">Edad</th>
                            <th class="text-center">Direccion</th>
                            <th class="text-center">DUI</th>
                            <th class="text-center">Telefono</th>
                            <th class="text-center">Aciones</th>
                        </tr>
                    </thead>
                    <%
                        ClienteDAO dao = new ClienteDAO();
                        List<ClienteBean> list = dao.listar();
                        Iterator<ClienteBean> iter = list.iterator();
                        ClienteBean cl = null;
                        while (iter.hasNext()) {
                            cl = iter.next();

                    %>
                    <tbody>
                        <tr>
                            <td ><%= cl.getIdCliente()%></td>
                            <td class="text-center"><%= cl.getNombre()%></td>
                            <td class="text-center"><%= cl.getApellido()%></td>
                            <td class="text-center"><%= cl.getEdad()%></td>
                            <td class="text-center"><%= cl.getDireccion()%></td>
                            <td class="text-center"><%= cl.getDui()%></td>
                            <td class="text-center"><%= cl.getTelefono()%></td>
                            <td class="text-center">
                                <a class="btn btn-warning" href="Cliente?accion=modificarCliente">Editar</a>
                                <a class="btn btn-danger" href="Cliente?accion=eliminarCliente">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
    </body>
</html>
