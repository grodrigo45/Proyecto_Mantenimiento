/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.ConexionMantto;
import beans.ProveedoresBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresDao {
    public static List<ProveedoresBean> listarProveedores()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<ProveedoresBean> listaProveedores = new ArrayList<ProveedoresBean>();
        String sql = "SELECT * FROM Proveedor";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int idProveedor = resulSet.getInt("idProveedor");
            String NombreProveedor = resulSet.getString("NombreProveedor");
            String Direccion = resulSet.getString("Direccion");
            String Telefono = resulSet.getString("Telefono");

            ProveedoresBean proveedorBean =
                new ProveedoresBean(idProveedor,
                    NombreProveedor,
                    Direccion,
                    Telefono);
            listaProveedores.add(proveedorBean);
        }
        return listaProveedores;
    } 
}
