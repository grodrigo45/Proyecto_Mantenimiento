<%--
  Created by IntelliJ IDEA.
  User: rodri
  Date: 4/11/2020
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap" rel="stylesheet">
    <title>Eliminar</title>
</head>
<body>
<section class="Delete">
    <div class="container">
        <h2 class="container__title">Eliminar Datos</h2>
        <form action="Principal?accion=eliminarEmpleadoForm" class="container__form" method="post">
            <input class="input" type="number" placeholder="Ingrese el ID" name="idTxt">
            <div class="container__button">
                <section class="container__button--button1">
                    <input class="button" type="submit" value="Eliminar">
                </section>
                <input class="button" type="button" value="Regresar">
            </div>
        </form>
    </div>
</section>
<style>

    body{
        margin: 0;
        background: #e8e8e8;
        font-family: 'Lato' , sans-serif;
    }

    .Delete{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        padding-top: 130px;
    }

    .container{
        padding-top: 2px;
        border: 2px solid #495464 ;
        border-radius: 40px;
        min-height: 400px;
        width: 500px;
    }

    .container__title{
        margin-bottom: 20%;
        text-align: center;
    }

    .container__form{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .input{
        background: transparent;
        padding-bottom: 10px;
        width: 300px;
        border-bottom: 2px solid #495464;
        margin-bottom: 80px;
        border-left: 0;
        border-right: 0;
        border-top: 0;
        outline: none;
    }

    .container__button{
        display: flex;
        flex-direction: row ;
    }

    .button {
        height: 50px;
        width: 200px;
        border-radius: 20px;
        outline: none;
        border: 0.5px solid #495464;
        font-family: 'Lato' , sans-serif;
    }

    .container__button--button1{
        padding-right: 40px;
    }

    .button:hover{
        background-color: #16697a;
        cursor: pointer;
        border: none;
    }
</style>
</body>
</html>
