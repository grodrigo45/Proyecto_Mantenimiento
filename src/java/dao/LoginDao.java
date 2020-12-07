package dao;

import beans.LoginBean;

import java.sql.*;

public class LoginDao {

    public String validar(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        String dbusername = "";
        String dbpassword = "";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password=1234;";//integratedSecurity=true;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("SELECT  * FROM Usuario where NombreUsuario=? and Contrasena=?");
            ps.setString(1, username);
            ps.setString(2, password    );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dbusername = rs.getString("NombreUsuario");
                dbpassword = rs.getString("Contrasena");

                if (username.equals(dbusername) && password.equals(dbpassword)) {
                    return "correcto";
                }
            }
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return "error en el proceso xd";
    }
}
