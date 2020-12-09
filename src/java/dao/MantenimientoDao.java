/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.ConexionMantto;
import beans.MantenimientoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class MantenimientoDao {
    // listar todos los eventos
    public static List<MantenimientoBean> listarMantenimiento()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<MantenimientoBean> listaMantto = new ArrayList<MantenimientoBean>();
        String sql = "SELECT * FROM Mantenimiento";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int idMantenimiento = resulSet.getInt("IdMantenimiento");
            String descripcion = resulSet.getString("Descripcion");
            int idEmpleado = resulSet.getInt("IdEmpleado");
            int idProducto = resulSet.getInt("IdProducto");
            int idTipoMantto = resulSet.getInt("IdTipoMantenimiento");
            int idCliente = resulSet.getInt("IdCliente");

         MantenimientoBean mantenimientoBean =
                    new MantenimientoBean(idMantenimiento,
                            descripcion,
                            idEmpleado,
                            idProducto,
                            idTipoMantto,
                            idCliente);
            listaMantto.add(mantenimientoBean);
        }
        return listaMantto;
    }
}
