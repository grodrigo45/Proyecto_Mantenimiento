
package dao;

import beans.PersonaBean;
import Conexion.ConexionMantto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PersonaDao {
    
    ConexionMantto cn=new ConexionMantto();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    PersonaBean equipos=new PersonaBean();

    public static List<PersonaBean> listarPersona()
            throws SQLException {
        Connection conn;
        ConexionMantto cn = new ConexionMantto();
        conn = cn.getConnection();

        List<PersonaBean> listaDePersona = new ArrayList<PersonaBean>();
        String sql = "SELECT Nombre, Apellido FROM Persona";
        Statement statement = conn.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
    
            String nombrePersona = resulSet.getString("Nombre");
            String apellidoPersona = resulSet.getString("Apellido");
            
            PersonaBean personaBean =
                    new PersonaBean(nombrePersona, apellidoPersona);
        }
        return listaDePersona;
    }
    
    
    
    
    
    
}
