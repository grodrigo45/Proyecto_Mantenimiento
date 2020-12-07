package beans;

public class EquiposBean {
    private int idProducto ;
    private String NombreProd;
    private String Descripcion;
    private int idProveedor;

    public EquiposBean(int idProducto,
                          String NombreProd,
                          String Descripcion,
                          int idProveedor){
        this.idProducto = idProducto;
        this.NombreProd = NombreProd;
        this.Descripcion = Descripcion;
        this.idProveedor = idProveedor;

    }

    public EquiposBean(){
        //Constructor vacio
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idproducto) {
        this.idProducto = idproducto;
    }

    public String getNombreProd(){
        return NombreProd;
    }

    public void setNombreProd(String NombreProd){
        this.NombreProd = NombreProd;
    }

    public String getDescripcion(){
        return Descripcion;
    }

    public void setDescripcion(String descripcion){
        this.Descripcion = descripcion;
    }

    public int getIdProveedor(){
        return idProveedor;
    }

    public void setIdProveedor(int idproveedor){
        this.idProveedor = idproveedor;
    }
}
