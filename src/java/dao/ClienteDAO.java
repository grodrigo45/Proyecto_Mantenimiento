package dao;

import Conexion.ConexionMantto;
import beans.CalendarioBean;
import beans.ClienteBean;
import beans.PersonaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    ConexionMantto cn= new ConexionMantto();
    Connection con;
    PreparedStatement ps;
    PreparedStatement sp;
    ResultSet rs;
    ClienteBean cl=new ClienteBean();
    PersonaBean per= new PersonaBean();


    public boolean insertarP(ClienteBean c)
            throws SQLException {
        Connection con;
        ConexionMantto cnm = new ConexionMantto();

        String sqlCl = "INSERT INTO Cliente (IdCliente, Nombre_C, " +
                "Apellido_C, Edad,Direccion,DUI,Telefono) " +
                "VALUES (?, ?, ?,?,?,?,?)";

        con = cnm.getConnection();
        PreparedStatement statement = con.prepareStatement(sqlCl);
        statement.setInt(1, cl.getIdCliente());
        statement.setString(2, cl.getNombre());
        statement.setString(3, cl.getApellido());
        statement.setInt(4, cl.getEdad());
        statement.setString(5, cl.getDireccion());
        statement.setString(6, cl.getDui());
        statement.setString(7, cl.getTelefono());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.close();
        return rowInserted;
    }
    
    public List listar() {
        ArrayList<ClienteBean>list=new ArrayList<>();
        String sql="select * from Cliente";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                ClienteBean clb=new ClienteBean();
                clb.setIdCliente(rs.getInt("IdCliente"));
                clb.setNombre(rs.getString("Nombre_C"));
                clb.setApellido(rs.getString("Apellido_C"));
                clb.setEdad(rs.getInt("Edad"));  
                clb.setDireccion(rs.getString("Direccion"));
                clb.setDui(rs.getString("DUI"));
                clb.setTelefono(rs.getString("Telefono"));
                list.add(clb);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public boolean add(ClienteBean clb) {
       String sql="insert into Cliente (Nombre_C,Apellido_C,Edad,Direccion,DUI,Telefono)" +
                    "values ('"+clb.getNombre()+"','"+clb.getApellido()+"','"+clb.getEdad()+"','"+clb.getDireccion()+"','"+clb.getDui()+"','"+clb.getTelefono()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    
    public ClienteBean list(int id) {
        String sql="select * from Cliente where IdCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                cl.setIdCliente(rs.getInt("IdCliente"));
                cl.setNombre(rs.getString("Nombre_C"));
                cl.setApellido(rs.getString("Apellido_C"));
                cl.setEdad(rs.getInt("Edad"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setDui(rs.getString("DUI"));
                cl.setTelefono(rs.getString("Telefono"));
                
            }
        } catch (Exception e) {
        }
        return cl;
    }
    
    public boolean modificar(ClienteBean clb) {
        String sql="update Cliente set Nombre_C='"+clb.getNombre()+"',Apellido_C='"+clb.getApellido()+"',Edad='"+clb.getEdad()+"',Direccion='"+clb.getDireccion()+"',DUI='"+clb.getDui()+"',Telefono='"+clb.getTelefono()+"'where Id="+clb.getIdCliente();

        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean eliminar(int id) {
        String sql="delete from Cliente where IdCliente="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}

