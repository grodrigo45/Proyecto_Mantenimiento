package servlets;

import Conexion.ConexionMantto;
import beans.EquiposBean;
import dao.EquiposDao;
import beans.LoginBean;
import dao.LoginDao;
import beans.CalendarioBean;
import beans.UsuarioBean;
import dao.CalendarioDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "servlets.Principal")
public class Principal extends HttpServlet {

    CalendarioDao calendarioDao = new CalendarioDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        String username = req.getParameter("usernameLogin");
        String password = req.getParameter("passwordLogin");

        if (accion.equals("iniciarSesion")) {
            LoginBean loginBean = new LoginBean();
            UsuarioBean usuario = new UsuarioBean();

            loginBean.setUsername(username);
            loginBean.setPassword(password);

            usuario.setUsuarioConfirmado(username);
            LoginDao loginDao = new LoginDao();
            String autorizacion = loginDao.validar(loginBean);

            if (autorizacion.equals("correcto")) {
                res.sendRedirect("empleados.jsp");

            } else {
                req.setAttribute("error", autorizacion);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.include(req, res);
            }

        } else if (accion.equals("insertar")) {
            insertarProducto(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=insertar");
        } else if (accion.equals("eliminar")) {
            eliminarProducto(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=eliminar");
        } else if (accion.equals("modificar")) {
            modificarProducto(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=modificar");
        } else if (accion.equals("insertarEmpleadoForm")) {
            insertarEmpleado(req, res);
            insertarPersona(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=insertarEmpleado");
        } else if (accion.equals("eliminarEmpleadoForm")) {
            eliminarEmpleado(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=eliminarEmpleado");

        } else if (accion.equals("modificarEmpleadoF")) {
            actualizarEmpleados(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=actualizarEmpleado");

        } else if (accion.equals("mostrar")) {
            try {
                mostrarCalendario(req, res);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            res.sendRedirect(req.getContextPath() + "/Principal?accion=mostrar");

        } else if (accion.equals("editar")) {
            editarCalendario(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=editar");
        } else if (accion.equals("registrar")) {
            registrarCalendario(req, res);
            res.sendRedirect(req.getContextPath() + "/Principal?accion=registrar");
        }
    }

    private void mostrarCalendario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaCalendario/mostrar.jsp");
        List<CalendarioBean> listaCalendario = CalendarioDao.listarCalendario();
        request.setAttribute("lista", listaCalendario);
        dispatcher.forward(request, response);
    }

    private void registrarCalendario(HttpServletRequest request, HttpServletResponse response) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        String fechaRecibido = request.getParameter("fechaRecibido");
        String fechaEntrega = request.getParameter("fechaEntrega");
        String estado = request.getParameter("estado");
        int idMantenimiento = Integer.parseInt(request.getParameter("idMantenimiento"));
        String nombreUsuario = request.getParameter("nombreUsuario");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlCalendario = "INSERT INTO Calendario_Actividades (FechaRecibido, FechaEntrega, "
                        + "Estado, IdMantenimiento, NombreUsuario) "
                        + "VALUES (?, ?, ?,?,?)";
                PreparedStatement statement = con.prepareStatement(sqlCalendario);
                statement.setString(1, fechaRecibido);
                statement.setString(2, fechaEntrega);
                statement.setString(3, estado);
                statement.setInt(4, idMantenimiento);
                statement.setString(5, nombreUsuario);
                int filas = statement.executeUpdate();
                if (filas > 0) {
                    request.getSession().setAttribute("exito", true); //Si se guardo la informacion
                } else {
                    request.getSession().setAttribute("exito", false); //Si no se guardo la informacion                   
                }
                mostrarCalendario(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            //mandamos un atributo para indicar que la conexion fue incorrecta
            //request.getSession().setAttribute("exito",false); //Si no se guardo la informacion
            ex.printStackTrace();
        }
    }

    private void showEditarCalendario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        CalendarioBean calendarioBean = calendarioDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("calendario", calendarioBean);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/vistaCalendario/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editarCalendario(HttpServletRequest request, HttpServletResponse response) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";

        int idCalendario = Integer.parseInt(request.getParameter("id"));
        String fechaRecibido = request.getParameter("fechaRecibido");
        String fechaEntrega = request.getParameter("fechaEntrega");
        String estado = request.getParameter("estado");
        int idMantenimiento = Integer.parseInt(request.getParameter("idMantenimiento"));
        String nombreUsuario = request.getParameter("nombreUsuario");

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlU = "UPDATE Calendario_Actividades "
                        + "SET FechaRecibido=?,FechaEntrega=?,Estado=?, IdMantenimiento=?, NombreUsuario=? "
                        + "WHERE IdCalendario=?";
                PreparedStatement statement = con.prepareStatement(sqlU);
                statement.setString(1, fechaRecibido);
                statement.setString(2, fechaEntrega);
                statement.setString(3, estado);
                statement.setInt(4, idMantenimiento);
                statement.setString(5, nombreUsuario);
                statement.setInt(6, idCalendario);
                int filas = statement.executeUpdate();
            }
            mostrarCalendario(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCalendario(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        CalendarioBean calendarioBean
                = calendarioDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        calendarioDao.eliminar(calendarioBean);
        mostrarCalendario(request, response);

    }

    public void insertarProducto(HttpServletRequest request, HttpServletResponse response) {
        String NombreProd = request.getParameter("txtnombre");
        String Descripcion = request.getParameter("txtdes");
        int idProveedor = Integer.parseInt(request.getParameter("txtpro"));
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sql = "INSERT INTO Productos (NombreProd,Descripcion,idProveedor) VALUES(?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, NombreProd);
                ps.setString(2, Descripcion);
                ps.setInt(3, idProveedor);
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
        int idProducto = Integer.parseInt(request.getParameter("txtid"));
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlDelete = "DELETE FROM Productos WHERE idProducto = ?";
                PreparedStatement ps = con.prepareStatement(sqlDelete);
                ps.setInt(1, idProducto);
                int filas = ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void modificarProducto(HttpServletRequest request, HttpServletResponse response) {
        int idProducto = Integer.parseInt(request.getParameter("txtid"));
        String NombreProd = request.getParameter("txtNombre");
        String Descripcion = request.getParameter("txtdes");
        int idProveedor = Integer.parseInt(request.getParameter("txtpro"));
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlUpdate = "UPDATE Productos SET NombreProd = ?, Descripcion=?, idProveedor=? WHERE idProducto = ?";
                PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
                pstmt.setString(1, NombreProd);
                pstmt.setString(2, Descripcion);
                pstmt.setInt(3, idProveedor);
                pstmt.setInt(4, idProducto);
                int filas = pstmt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        String tipoEmpleado = request.getParameter("tipoEmpleadoTxt");
        String rangoEstudio = request.getParameter("rangoEstudioTxt");
        String trabajosHechos = request.getParameter("trabajosHechosTxt");
        String idPersona = request.getParameter("idPersonaTxt");

        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sql = "INSERT INTO Empleado (TipoEmpleado, RangoEstudio, TrabajosEchos, IdPersona) VALUES(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, tipoEmpleado);
                ps.setString(2, rangoEstudio);
                ps.setString(3, trabajosHechos);
                ps.setString(4, idPersona);
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarPersona(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombrePersonaTxt");
        String apellido = request.getParameter("apellidoPersonaTxt");
        int edad = Integer.parseInt(request.getParameter("edadPersonaTxt"));
        String telefono = request.getParameter("telPersonaTxt");
        String direccion = request.getParameter("dirPersonaTxt");
        String dui = request.getParameter("duiPersonaTxt");

        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sql = "INSERT INTO Persona (Nombre, Apellido, Edad, Telefono, Direccion, DUI) VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setInt(3, edad);
                ps.setString(4, telefono);
                ps.setString(5, direccion);
                ps.setString(6, dui);
                int filas = ps.executeUpdate();
                if (filas > 0) {
                    request.getSession().setAttribute("exito", true);
                } else {
                    request.getSession().setAttribute("exito", false);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarEmpleado(HttpServletRequest req, HttpServletResponse res) {
        int idEmpleado = Integer.parseInt(req.getParameter("idTxt"));
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password =1234;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlDelete = "DELETE FROM Empleado WHERE IdEmpleado = ?";
                PreparedStatement ps = con.prepareStatement(sqlDelete);
                ps.setInt(1, idEmpleado);
                int filas = ps.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void actualizarEmpleados(HttpServletRequest req, HttpServletResponse res) {

        int idEmpleado = Integer.parseInt(req.getParameter("idTxt"));
        String tipoEmpleado = req.getParameter("tipoEmpleadoTxt");
        String rangoEstudio = req.getParameter("rangoEstudioTxt");
        String trabajosHechos = req.getParameter("trabajosHechosTxt");
        String idPersona = req.getParameter("idPersonaTxt");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DS_Mantto_Equipo;user=sa;password = 1234;";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection con = DriverManager.getConnection(url)) {
                String sqlUpdate = "UPDATE Empleado SET TipoEmpleado = ?, RangoEstudio=? , TrabajosEchos=? WHERE IdEmpleado = ?";
                PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
                pstmt.setString(1, tipoEmpleado);
                pstmt.setString(2, rangoEstudio);
                pstmt.setString(3, trabajosHechos);
                pstmt.setInt(4, idEmpleado);
                int filas = pstmt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        if (accion == null) {
            req.getRequestDispatcher("index.jsp").forward(req, res);
        } else if ("insertarEmpleado".equals(accion)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/vistaEmpleados/insertar.jsp");
            dispatcher.forward(req, res);
        } else if ("eliminarEmpleado".equals(accion)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/vistaEmpleados/eliminar.jsp");
            dispatcher.forward(req, res);
        } else if ("actualizarEmpleado".equals(accion)) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/vistaEmpleados/actualizar.jsp");
            dispatcher.forward(req, res);
        } else if (accion.equals("insertar")) {
            if (req.getSession().getAttribute("exito") != null) {
                req.setAttribute("exito", req.getSession().getAttribute("exito"));
                req.getSession().removeAttribute("exito");
            }
            req.getRequestDispatcher("/vistaEquipo/InsertarEquipos.jsp").forward(req, res);
        } else if (accion.equals("eliminar")) {
            if (req.getSession().getAttribute("exito") != null) {
                req.setAttribute("exito", req.getSession().getAttribute("exito"));
                req.getSession().removeAttribute("exito");
            }
            req.getRequestDispatcher("/vistaEquipo/EliminarEquipos.jsp").forward(req, res);
        } else if (accion.equals("modificar")) {
            if (req.getSession().getAttribute("exito") != null) {
                req.setAttribute("exito", req.getSession().getAttribute("exito"));
                req.getSession().removeAttribute("exito");
            }
            req.getRequestDispatcher("/vistaEquipo/ActualizarEquipos.jsp").forward(req, res);
        } else if (accion.equals("editar")) {
            if (req.getSession().getAttribute("exito") != null) {
                req.setAttribute("exito", req.getSession().getAttribute("exito"));
                req.getSession().removeAttribute("exito");
            }
            req.getRequestDispatcher("/vistaCalendario/editar.jsp").forward(req, res);

        } else if (accion.equals("registrar")) {
            if (req.getSession().getAttribute("exito") != null) {
                req.setAttribute("exito", req.getSession().getAttribute("exito"));
                //Se borra el atributo de la sesion despues de asignarlos como atributo a la peticion
                req.getSession().removeAttribute("exito");
            }
            req.getRequestDispatcher("calendario.jsp").forward(req, res);
        } else {
            try {
                switch (accion) {
                    case "mostrar":
                        mostrarCalendario(req, res);
                        break;
                    case "showedit":
                        showEditarCalendario(req, res);
                        break;
                    case "eliminarCalendario":
                        eliminarCalendario(req, res);
                        break;
                    case "perfilUsuario":
                        RequestDispatcher dispatcher = req.getRequestDispatcher("/perfil.jsp");
                        dispatcher.forward(req, res);
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                e.getStackTrace();
            }
        }
    }
}
