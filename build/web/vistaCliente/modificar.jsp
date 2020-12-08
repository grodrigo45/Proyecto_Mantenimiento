<%@page import="beans.ClienteBean"%>
<%@page import="dao.ClienteDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap" rel="stylesheet">
    <title>Actualizar</title>
</head>
<body>
<section class="actualizar">
    <div class="container">
        <h2 class="container__title">Modificar Datos</h2>
        <form class="container__form" action="Cliente?accion=modificarCliente" method="post">
            <input class="input" type="text" name="txtid" placeholder="Inserte el Código a modificar">
            <input class="input" type="text" name="txtNom"  placeholder="Nombre del Cliente">
            <input class="input" type="text" name="txtApe"   placeholder="Apellido del Cliente">
            <input class="input" type="text" name="txtedad" placeholder="Edad">
            <input class="input" type="text" name="txtdir" placeholder="Direccion">
            <input class="input" type="text" name="txtdui" placeholder="DUI">
            <input class="input" type="text" name="txttel" placeholder="Teléfono">
            
            <div class="container__button">
                <section class="container__button--button1">
                    <input class="button" type="submit" value="Actualizar Dato">
                </section>
                <a href="Cliente?accion=listar">Regresar</a>
            </div>
        </form>
    </div>
</section>
        <script>
        function regresar(){
            window.history.back();
        }
         </script>
<style>
body{
    margin: 0;
    padding: 0;
    font-family: 'Lato',sans-serif;
    background: #e8e8e8;
}

.actualizar{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: center;
    padding-top: 70px;
    font-size: 16px;
}

.container{
    padding-top: 2px;
    border: 2px solid #495464;
    border-radius: 40px;
    min-height: 500px;
    width: 500px;
}

.container__title{
    margin-bottom: 10%;
    text-align: center;
}

.container__form{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.input{
    padding-bottom: 10px;
    width: 400px;
    background: transparent;
    font-family: 'Lato',sans-serif;
    border-bottom: 2px solid #495464;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    outline: none;
    margin-bottom: 50px;
}

.container__button{
    display: flex;
    flex-direction: row;
}

.button{
    height: 40px;
    width: 180px;
    border-radius: 20px;
    outline: none;
    border: 0.5px solid #495464;
    font-family: 'Lato',sans-serif;
}

.container__button--button1{
    padding-right: 40px;
}

.button:hover{
    background-color: #16697a;
    border: none;
    cursor: pointer;
}


</style>
</body>
</html>
