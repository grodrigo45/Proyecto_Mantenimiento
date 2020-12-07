package dao;

import beans.UsuarioBean;
import Conexion.ConexionMantto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public UsuarioDao() {
//        constructor vacío
    }

    public static List<UsuarioBean> listarUsuario()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<UsuarioBean> listaInformacion = new ArrayList<UsuarioBean>();
        String sqlMostrarUsuario = "SELECT Nombre, Apellido, Edad, Direccion, Telefono FROM Persona WHERE Nombre='Edgardo'";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sqlMostrarUsuario);

        while (resulSet.next()) {
            String nombreUsuario = resulSet.getString("Nombre");
            String apellidoUsuario = resulSet.getString("Apellido");
            String edadUsuario = resulSet.getString("Edad");
            String direccionUsuario = resulSet.getString("Direccion");
            String telefonoUsuario = resulSet.getString("Telefono");

            UsuarioBean usuarioBean =
                    new UsuarioBean(nombreUsuario, apellidoUsuario, edadUsuario, direccionUsuario, telefonoUsuario);
            listaInformacion.add(usuarioBean);
        }
        return listaInformacion;
    }

}
