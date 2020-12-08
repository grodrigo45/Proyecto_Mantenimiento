<%--Login v1.0 futuros cambios pueden ser realizados por el grupo--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Iniciar sesión</title>
    <link rel="stylesheet" href="./css/index.css">
</head>
<body>

<div class="container">

    <div class="loginImg">

        <img
                src="./img/k.png"
                alt="imagen"
        >

    </div>

    <div class="login slide-in-blurred-top">
        <h1 class="tituloLogin">¡Bienvenido!</h1>
        <h5 class="subtituloLogin">Ingresa tus datos para iniciar sesión</h5>
        <form action="Principal?accion=iniciarSesion" method="post" class="containerForm" onsubmit="return validate()">
            <input type="text" placeholder="Ingrese su nombre de usuario o correo" id="usuarioLogin"
                   name="usernameLogin" class="usuarioLogin">
            <input type="password" placeholder="Ingrese su contraseña" id="passwordLogin" name="passwordLogin"
                   class="passwordLogin">
            <input type="submit" value="Login" id="buttonEnviar" class="card-2">
        </form>

    </div>
</div>
<script src="js/index.js"></script>
</body>
</html>