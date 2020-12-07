package dao;

import beans.EmpleadosBean;
import Conexion.ConexionMantto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadosDao {

    ConexionMantto cn=new ConexionMantto();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    EmpleadosBean equipos=new EmpleadosBean();

    public static List<EmpleadosBean> listarEmpleados()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<EmpleadosBean> listaDeEmpleados = new ArrayList<EmpleadosBean>();
        String sql = "SELECT * FROM Empleado";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int idEmpleado = resulSet.getInt("IdEmpleado");
            String tipoEmpleado = resulSet.getString("TipoEmpleado");
            String rangoEstudio = resulSet.getString("RangoEstudio");
            String trabajosHechos = resulSet.getString("TrabajosEchos");

            EmpleadosBean empleadosBean =
                    new EmpleadosBean( idEmpleado, tipoEmpleado, rangoEstudio, trabajosHechos);
            listaDeEmpleados.add(empleadosBean);
        }
        return listaDeEmpleados;
    }

}
