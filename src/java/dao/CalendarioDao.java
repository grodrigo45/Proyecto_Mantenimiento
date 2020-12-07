package dao;

import beans.CalendarioBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import Conexion.ConexionMantto;
import java.text.ParseException;
import java.text.SimpleDateFormat;

    public class CalendarioDao {

    // listar todos los eventos
    public static List<CalendarioBean> listarCalendario()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<CalendarioBean> listaCalendario = new ArrayList<CalendarioBean>();
        String sql = "SELECT * FROM Calendario_Actividades";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int idCalendario = resulSet.getInt("IdCalendario");
            String fechaRecibido = resulSet.getString("FechaRecibido");
            String fechaEntregado = resulSet.getString("FechaEntrega");
            String estado = resulSet.getString("Estado");
            int idMantenimiento = resulSet.getInt("IdMantenimiento");
            String usuario = resulSet.getString("NombreUsuario");

            CalendarioBean calendarioBean =
                    new CalendarioBean(idCalendario,
                            fechaRecibido,
                            fechaEntregado,
                            estado,
                            idMantenimiento,
                            usuario);
            listaCalendario.add(calendarioBean);
        }
        return listaCalendario;
    }

    // obtener por id
    public CalendarioBean obtenerPorId(int id)
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();
        
        CalendarioBean calendarioBean = new CalendarioBean();
        String sql = "SELECT * FROM Calendario_Actividades WHERE IdCalendario= ? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            calendarioBean = new CalendarioBean(res.getInt("idCalendario"),
                    res.getString("fechaRecibido"),
                    res.getString("fechaEntrega"),
                    res.getString("estado"),
                    res.getInt("idMantenimiento"),
                    res.getString("nombreUsuario"));
        }
        res.close();
        conn.close();

        return calendarioBean;
    }

    //eliminar
    public boolean eliminar(CalendarioBean calendarioBean)
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        boolean rowEliminar = false;
        String sql = "DELETE FROM Calendario_Actividades WHERE IdCalendario=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, calendarioBean.getIdCalendario());

        rowEliminar = statement.executeUpdate() > 0;
        
        conn.close();
        statement.close();

        return rowEliminar;
    }
}
