package beans;

import java.util.List;

public class CalendarioBean {
    private int idCalendario;
    private String fechaRecibido;
    private String fechaEntregado;
    private String estado;
    private int idMantenimiento;
    private String nombreUsuario;
    
    private int total;
    private int finalizado;
    private int sinIniciar;
    private int enProceso;

    public CalendarioBean(int idCalendario,
                          String fechaRecibido,
                          String fechaEntregado,
                          String estado,
                          int idMantenimiento,
                          String nombreUsuario){
        this.idCalendario = idCalendario;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntregado = fechaEntregado;
        this.estado = estado;
        this.idMantenimiento = idMantenimiento;
        this.nombreUsuario = nombreUsuario;

    }
    
    //Lo ocupo para la funcion insertar ya que su id de calendario esta en auto_incrementable
    //lo cual me toca crear este para eliminar el parametro id
    public CalendarioBean(String fechaRecibido,
                          String fechaEntregado,
                          String estado,
                          int idMantenimiento,
                          String nombreUsuario){
        this.fechaRecibido = fechaRecibido;
        this.fechaEntregado = fechaEntregado;
        this.estado = estado;
        this.idMantenimiento = idMantenimiento;
        this.nombreUsuario = nombreUsuario;
    }
    
    //constructor para obtener los totales de datos en la tabla
    public CalendarioBean(int total){
        this.total = total;
    }
    
    public CalendarioBean(int finalizado, 
                            int sinIniciar, 
                            int enProceso) {
        this.finalizado = finalizado;
        this.sinIniciar = sinIniciar;
        this.enProceso = enProceso;
    }
    
    public CalendarioBean() {
    }

    public int getIdCalendario() { return idCalendario; }

    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    public String getFechaRecibido() { return fechaRecibido; }

    public void setFechaRecibido(String fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getFechaEntregado() { return fechaEntregado; }

    public void setFechaEntregado(String fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreUsuario() { return nombreUsuario; }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdMantenimiento() { return idMantenimiento; }

    public int getTotal() { return total; }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFinalizado() { return finalizado; }

    public void setFinalizado(int finalizado) {
        this.finalizado = finalizado;
    }

    public int getSinIniciar() {return sinIniciar;}

    public void setSinIniciar(int sinIniciar) {
        this.sinIniciar = sinIniciar;
    }

    public int getEnProceso() { return enProceso; }

    public void setEnProceso(int enProceso) {
        this.enProceso = enProceso;
    }
}
