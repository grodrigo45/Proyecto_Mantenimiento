<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap" rel="stylesheet">
    <title>Insertar</title>
</head>
<body>
<section class="content">
    <div class="container">
        <h2 class="container__title">Ingrese los datos de el nuevo producto</h2>
        <form action="Principal?accion=insertar" class="container__form" method="post">
            <input class="input" type="text"name="txtnombre" placeholder="NombreProducto" >
            <input class="input" type="text" name="txtdes" placeholder="Descripcion">
            <input class="input" type="text" name="txtpro" placeholder="IdProveedor">
            <div class="container__button">
                <section class="container__button1">
                    <input  class="button" type="submit" value="Insertar">
                </section>
                <input class="button" type="button" value="Regresar" onclick="regresar()">
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
    background: #e8e8e8;
    font-family: 'Lato' , sans-serif;
}

.content{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding-top: 120px;
    font-size: 16px;
}

.container{
    padding-top: 2px;
    border: 2px solid #495464 ;
    border-radius: 40px;
    min-height:400px;
    width: 500px;
}

.container__title{
    margin-bottom: 20%;
    text-align: center;
}

.container__form{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
}

.input{
    padding-bottom: 10px;
    width: 300px;
    background: transparent;
    font-family: 'Lato' , sans-serif;
    border-bottom: 2px solid #495464;
    margin-bottom: 25px;
    outline: none;
    border-top: 0;
    border-left: 0;
    border-right: 0;
}

.container__button{
    display: flex;
    flex-direction: row ;
    white-space: 2px;
}


.button {
    height: 50px;
    width: 200px;
    border-radius: 20px;
    outline: none;
    border: 0.5px solid #495464;
    font-family: 'Lato' , sans-serif;
}

.container__button1{
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