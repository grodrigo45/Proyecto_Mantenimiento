<%@page import="beans.ProveedoresBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProveedoresDao"%>
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
    <div class="link-1">
        <a href="Equipos.jsp">Regresar</a>
    </div>
    <a href=""><img src="https://www.flaticon.com/svg/static/icons/svg/3530/3530223.svg" alt="USER"></a>
</nav>

<div class="content">

    <h1 class="title"> Proveedores </h1>
<div class="table">
        <table>
            <tr class="col-t">
                <th>ID Proveedor</th>
                <th>Nombre Proveedor</th>
                <th>Direccion</th>
                <th>Telefono</th>
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
                ProveedoresDao dao = new ProveedoresDao();
                List<ProveedoresBean>list = dao.listarProveedores();
                Iterator<ProveedoresBean>iter=list.iterator();
                ProveedoresBean pro= null;
                while(iter.hasNext()){
                    pro=iter.next();
                
            %>
            <tr class="col-t">
                <td><%= pro.getIdProveedor()%></td>
                <td><%= pro.getNombreProveedor()%></td>
                <td><%= pro.getDireccion()%></td>
                <td><%= pro.getTelefono()%></td>
            </tr>
            <%}%>
        </table>

    </div>
</div>
</body>
</html>