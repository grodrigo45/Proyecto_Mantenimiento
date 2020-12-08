package beans;

public class UsuarioBean {

    private String nombreUsuario;
    private String apellidoUsuario;
    private String edadUsuario;
    private String direccionUsuario;
    private String telefonoUsuario;
    private String usuarioConfirmado;

    public UsuarioBean( String nombreUsuario, String apellidoUsuario, String edadUsuario, String direccionUsuario, String telefonoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.edadUsuario = edadUsuario;
        this.direccionUsuario = direccionUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public UsuarioBean(String UsuarioConfirmado) {
        this.usuarioConfirmado = UsuarioConfirmado;
    }

    public UsuarioBean() {
       
    }

    public String getUsuarioConfirmado() {
        return usuarioConfirmado;
    }

    public void setUsuarioConfirmado(String UsuarioConfirmado) {
        this.usuarioConfirmado = UsuarioConfirmado;
    }

    public String getNombre() {
        return nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombreUsuario = nombre;
    }

    public String getApellido() {
        return apellidoUsuario;
    }

    public void setApellido(String apellido) {
        this.apellidoUsuario = apellido;
    }

    public String getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(String edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
}
