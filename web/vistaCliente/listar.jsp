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
        <a href="#">Actividades</a>
        <div class="calendar bShadow-3 ">
            <a href="#">Agregar</a>
            <a href="#">Eliminar</a>
            <a href="#">Actualizar</a>
        </div>
    </div>

    <div class="link-1">
        <a href="Equipos.jsp">Productos</a>
        <div class="calendar bShadow-3 ">
            <a href="#">Agregar</a>
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

<div class="content">

    <div>
        <h1 class="title"> Clientes </h1>
    </div>
    <br>
    <div class="menu-box">
        <div class="box1 bShadow-2 bShadow-5h">
            <div class="boxTxt">
                <p>Total de equipos</p>
                <h2>100</h2>
            </div>
            <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
        </div>

        <div class="box2 bShadow-2 bShadow-5h">
            <h2>50%</h2>
            <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
        </div>

        <div class="box3 bShadow-2">
            <h2>500</h2>
            <img src="https://www.flaticon.com/svg/static/icons/svg/3330/3330972.svg" alt="">
        </div>

        <div class="box4 bShadow-2 bShadow-5h">
            <h2>100%</h2>
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
                    ClienteDAO dao=new ClienteDAO();
                    List<ClienteBean>list=dao.listar();
                    Iterator<ClienteBean>iter=list.iterator();
                    ClienteBean cl=null;
                    while(iter.hasNext()){
                        cl=iter.next();
                    
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
