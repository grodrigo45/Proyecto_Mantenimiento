<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="./css/insertarCliente.css" rel="stylesheet" type="text/css"/>
        <title>Insertar Cliente</title>
        <style>
            .container{
    padding-top: 2px;
    border: 2px solid #495464;
    border-radius: 40px;
    min-height: 500px;
    width: 500px;
    }

    .container__form{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    .container__button{
        margin-left: 25px;
                display: flex;
                flex-direction: row ;
                white-space: 2px;
            }
    .container__button--button1{
                padding-right: 40px;
            }
            .insertar{
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                padding-top: 130px;
            }
    
    .button {
                height: 50px;
                width: 200px;
                border-radius: 20px;
                outline: none;
                border: 0.5px solid #495464;
                font-family: 'Lato' , sans-serif;
            }
            a{text-decoration: none;color: black}
            .button2 {
                height: 50px;
                width: 200px;
                border-radius: 20px;
                outline: none;
                border: 0.5px solid #495464;
                font-family: 'Lato' , sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
            }
    .button:hover{
                background-color: #16697a;
                cursor: pointer;
                border: none;
            }
    .button2:hover{
    background-color: #16697a;
    cursor: pointer;
    border: none;
            }
        </style>
    </head>
    <body>
        
        <section class="insertar">
            <div class="container">
            <form class="container__form" action="Cliente" id="form">
              <h1>Nuevo Cliente</h1>
        <div class="form">
            
            <div class="grupo">
                <input type="text" name="txtNom" id="name" required><span class="barra"></span>
                <label for="">Nombre</label>
            </div>
            <div class="grupo">
                <input type="text" name="txtApe" id="email" required><span class="barra"></span>
                <label for="">Apellido</label>
            </div>
            <div class="grupo">
                <input type="text" name="txtedad" id="email" required><span class="barra"></span>
                <label for="">Edad</label>
            </div>
            <div class="grupo">
                <input type="text" name="txtdir" id="email" required><span class="barra"></span>
                <label for="">Direccion</label>
            </div>
            <div class="grupo">
                <input type="text" name="txtdui" id="email" required><span class="barra"></span>
                <label for="">DUI</label>
            </div>
            <div class="grupo">
                <input type="text" name="txttel" id="email" required><span class="barra"></span>
                <label for="">Teléfono</label>
            </div>
            <div class="container__button">
                <section class="container__button--button1">
                    <input class="button" type="submit" name="accion" value="Agregar">
                </section>
                <a class="button2" href="Cliente?accion=listar">Regresar</a>
            </div>
        </div>
        </form>
        </div>
        </section>
    </body>
</html>
