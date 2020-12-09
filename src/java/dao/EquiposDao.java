/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.ConexionMantto;
import beans.ProveedoresBean;
import beans.EquiposBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public class EquiposDao {
    ConexionMantto cn=new ConexionMantto();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    EquiposBean equipos=new EquiposBean();
    public static List<EquiposBean> listarEquipos()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<EquiposBean> listaEquipos = new ArrayList<EquiposBean>();
        String sql = "SELECT * FROM Productos";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int idProducto = resulSet.getInt("idProducto");
            String NombreProd = resulSet.getString("NombreProd");
            String Descripcion = resulSet.getString("Descripcion");
            int idProveedor = resulSet.getInt("idProveedor");

            EquiposBean equiposBean =
                new EquiposBean(idProducto,
                    NombreProd,
                    Descripcion,
                    idProveedor);
            listaEquipos.add(equiposBean);
        }
        return listaEquipos;
    }
    
   
}


