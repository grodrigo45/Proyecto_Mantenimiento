
<%@page import="beans.LoginBean"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beans.UsuarioBean" %>
<%@ page import="dao.UsuarioDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Conexion.ConexionMantto" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="./css/perfil.css">
    </head>
    <body>


        <%
            Connection con;
            ConexionMantto cn = new ConexionMantto();
            con = cn.getConnection();
            UsuarioBean usuario = new UsuarioBean();
            LoginBean usuarioLogin = new LoginBean();
         String sqlMostrarUsuario = "SELECT Nombre, Apellido, Edad, Direccion, Telefono FROM Persona WHERE NombreUsuario=' "+usuarioLogin.getUsername()+" '";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlMostrarUsuario);
            if (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String edad = rs.getString("Edad");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                usuario = new UsuarioBean(nombre, apellido, edad, direccion, telefono);
            } else {
                System.out.println("Ningun resultado encontrado");
            }
            con.close();
            rs.close();
%>


        <div class="container">
            <nav class="verticalMenu">


                <div class="menu-item">
                    <img src="./img/user.png" alt="IMG">
                    <a href="#">Información</a>
                </div>

                <div class="menu-item">
                    <img src="./img/settings.png" alt="img">
                    <a href="#">Configuración</a>
                </div>

                <div class="menu-item">
                    <img src="./img/logout.png" alt="img">
                    <a href="">Cerrar sesión</a>
                </div>
            </nav>
            <div class="userInfo">
                <div class="dataUser">
                    <img src="https://www.flaticon.es/svg/static/icons/svg/2086/2086569.svg" alt="perfil-icon"
                         class="bShadow-1">
                    <div class="description">
                        <p class="name"><%=usuario.getNombre()%></p>
                        <p class="city"><%=usuario.getDireccionUsuario()%></p>
                    </div>
                </div>
                <div class="editUserData">
                    <div class="data1">

                        <div class="handleInput">
                            <label for="name">Nombre</label>
                            <input type="text" id="name" readonly value="<%=usuario.getNombre()%>">
                        </div>

                        <div class="handleInput">
                            <label for="lastname">Apellido</label>
                            <input type="text" id="lastname" readonly value="<%=usuario.getApellido()%>">
                        </div>
                        <div class="handleInput">
                            <label for="lastname">Telefono</label>
                            <input type="text" id="telefono" readonly value="<%=usuario.getTelefonoUsuario()%>">
                        </div>

                    </div>
                    <div class="data2">

                        <div class="handleInput">
                            <label for="name">E-mail</label>
                            <input type="text" id="email" readonly>
                        </div>

                        <div class="handleInput">
                            <label for="name">Direccion</label>
                            <input type="text" id="direccion" readonly value="<%=usuario.getDireccionUsuario()%>">
                        </div>

                        <div class="handleInput">
                            <label for="name">debug: <%=usuarioLogin.getUsername()%></label>
                            <input type="text" id="edad" readonly value="<%=usuario.getEdadUsuario()%>">
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
