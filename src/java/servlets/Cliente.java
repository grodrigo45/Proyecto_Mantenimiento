package servlets;

import beans.ClienteBean;
import dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cliente extends HttpServlet {
    String listar="/vistaCliente/listar.jsp";
    String add="/vistaCliente/insertar.jsp";
    String edit="/vistaCliente/modificar.jsp";
    ClienteBean cl=new ClienteBean();
    ClienteDAO dao=new ClienteDAO();
    String acceso="";
    int id;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            int edad=Integer.parseInt(request.getParameter("txtedad"));
            String direccion=request.getParameter("txtdir");
            String dui=request.getParameter("txtdui");
            String tel=request.getParameter("txttel");

            cl.setNombre(nom);
            cl.setApellido(ape);
            cl.setEdad(edad);
            cl.setDireccion(direccion);
            cl.setDui(dui);
            cl.setTelefono(tel);
            dao.add(cl);
            acceso=listar;
        }
        else if(action.equals("eliminarCliente")){
            if(request.getSession().getAttribute("exito")!=null){
                request.setAttribute("exito",request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
                
            }
            request.getRequestDispatcher("/vistaCliente/eliminar.jsp").forward(request,response);
        }
        else if(action.equals("modificarCliente")){
            if(request.getSession().getAttribute("exito")!=null){
                request.setAttribute("exito",request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
                
            }
            request.getRequestDispatcher("/vistaCliente/modificar.jsp").forward(request,response);
            
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("accion");
        if(action.equals("eliminarCliente")){
            eliminarCliente(request, response);
            response.sendRedirect(request.getContextPath() + "/Cliente?accion=eliminarCliente");
        }else if(action.equals("modificarCliente")){
            modificarCliente(request, response);
            response.sendRedirect(request.getContextPath() + "/Cliente?accion=modificarCliente");
        }
        
    }
    
    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response){
        int IdCliente=Integer.parseInt(request.getParameter("txtid"));
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try(Connection con = DriverManager.getConnection(url)){
            String sqlDelete = "DELETE FROM Cliente WHERE IdCliente = ?";
            PreparedStatement ps = con.prepareStatement(sqlDelete);
            ps.setInt(1,IdCliente);
            int filas = ps.executeUpdate();
        }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void modificarCliente(HttpServletRequest request, HttpServletResponse response){
            int id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtNom");
            String ape=request.getParameter("txtApe");
            int edad=Integer.parseInt(request.getParameter("txtedad"));
            String direccion=request.getParameter("txtdir");
            String dui=request.getParameter("txtdui");
            String tel=request.getParameter("txttel");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try(Connection con = DriverManager.getConnection(url)){
                String sqlUpdate = "UPDATE Cliente SET Nombre_C = ?, Apellido_C=?, Edad=?,Direccion=?,DUI=?,Telefono=? WHERE IdCliente = ?";
                PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
                pstmt.setString(1, nom);
                pstmt.setString(2, ape);
                pstmt.setInt(3, edad);
                pstmt.setString(4, direccion);
                pstmt.setString(5, dui);
                pstmt.setString(6, tel);
                pstmt.setInt(7, id);
                int filas = pstmt.executeUpdate();
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
