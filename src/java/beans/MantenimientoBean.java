/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author marce
 */
public class MantenimientoBean {
    
    private int idMantenimiento;
    private String descripcion;
    private int idEmpleado;
    private int idProducto;
    private int idTipoMantto;
    private int idCliente;

    public MantenimientoBean(int idMantenimiento, 
                        String descripcion, 
                        int idEmpleado, 
                        int idProducto, 
                        int idTipoMantto, 
                        int idCliente) {
        this.idMantenimiento = idMantenimiento;
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.idTipoMantto = idTipoMantto;
        this.idCliente = idCliente;
    }

    public MantenimientoBean(String descripcion, 
                        int idEmpleado, 
                        int idProducto, 
                        int idTipoMantto, 
                        int idCliente) {
        this.descripcion = descripcion;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.idTipoMantto = idTipoMantto;
        this.idCliente = idCliente;
    }

    public MantenimientoBean(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }
    
    public MantenimientoBean() {
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTipoMantto() {
        return idTipoMantto;
    }

    public void setIdTipoMantto(int idTipoMantto) {
        this.idTipoMantto = idTipoMantto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
