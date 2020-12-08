package beans;

public class PersonaBean {
    private int idPersona;
    private String nombre;
    private String apellido;
    private int Edad;
    private String telefono;
    private String direccion;
    private String dui;
    private String nombreUsuario;


    public PersonaBean(String nombre, String apellido, int edad, String telefono, String direccion,String nombreUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        Edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombreUsuario = nombreUsuario;
    }
    
    public PersonaBean(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    

    public PersonaBean() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
