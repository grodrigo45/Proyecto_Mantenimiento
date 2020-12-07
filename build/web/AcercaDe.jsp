<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/AcercaDe.css">
        <title>Acerca De</title>
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
        <a href="empleados.jsp">Empleados</a>
        <div class="calendar bShadow-3">
            <a href="Principal?accion=insertarEmpleado">Agregar</a>
            <a href="Principal?accion=eliminarEmpleado">Eliminar</a>
            <a href="Principal?accion=actualizarEmpleado">Actualizar</a>
        </div>
    </div>
        <a href=""><img src="https://www.flaticon.com/svg/static/icons/svg/3530/3530223.svg" alt="USER"></a>
    </nav>

    <div class="AcercaDe">
        <div class="AcercaDe__img">
            <img src="./img/mantenimiento-web.png" alt="Mantenimiento">
        </div>
        <div class="AcercaDe__Contenido">
            <p>Mantenimiento de Equipos Informaticos 
            Proyecto realizado con fines educativos
            Este proyecto fue realizado por </p>
            <p>Edgardo Antonio Rodriguez Galicia</p>
            <p>Marcelo Ariel Mendez Castillo</p>
            <p>Alan Emilio Coto Zetino</p>
            <p>Rodrigo Oswaldo Hernandez Gonzalez</p>
            <p>Universidad de Sonsonate</p>
            <p>Desarrollo de Software &copy; 2020 &reg;</p>

        </div>
        <footer class="AcercaDe__footer">
            <img src="./img/java.png" alt="java">
            <img src="./img/simbolo-de-formato-de-archivo-jsp.png" alt="jsp">
            <img src="./img/sql-server.png" alt="sqlserver">
            <img src="./img/git.png" alt="git">
            <img src="./img/github.png" alt="github">
            <img src="./img/css.png" alt="css">
        </footer>
    </div>
    </body>
</html>
