/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

public class ProveedoresBean {
    private int idProveedor;
    private String NombreProveedor;
    private String Direccion;
    private String Telefono;

    public ProveedoresBean(int idProveedor, String NombreProveedor, String Direccion, String Telefono) {
        this.idProveedor = idProveedor;
        this.NombreProveedor = NombreProveedor;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public ProveedoresBean() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
