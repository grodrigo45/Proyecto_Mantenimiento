package beans;

public class EmpleadosBean {

    private int idEmpleado;
    private String tipoEmpleado;
    private String rangoEstudio;
    private String trabajosHechos;
    private int idPersona;
    private int totalEmpleados;
    private int totalTrabajos;

//    Cajas
    private int realizado;
    private int estudio;
    private int tipo;

    public void setTotalTrabajos(int totalTrabajos) {
        this.totalTrabajos = totalTrabajos;
    }

    public int getTotalTrabajos() {
        return totalTrabajos;
    }

    public EmpleadosBean(int idEmpleado, String tipoEmpleado, String rangoEstudio, String trabajosHechos) {
        this.idEmpleado = idEmpleado;
        this.tipoEmpleado = tipoEmpleado;
        this.rangoEstudio = rangoEstudio;
        this.trabajosHechos = trabajosHechos;
        this.idPersona = idPersona;
    }

    public EmpleadosBean() {
//        constructor vacío

    }

    public EmpleadosBean(int totalEmpleados) {
        this.totalEmpleados = totalEmpleados;

    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getRangoEstudio() {
        return rangoEstudio;
    }

    public void setRangoEstudio(String rangoEstudio) {
        this.rangoEstudio = rangoEstudio;
    }

    public String getTrabajosHechos() {
        return trabajosHechos;
    }

    public void setTrabajosHechos(String trabajosHechos) {
        this.trabajosHechos = trabajosHechos;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setTotalEmpleados(int totalEmpleados) {
        this.totalEmpleados = totalEmpleados;
    }

    public int getTotalEmpleados() {
        return totalEmpleados;
    }
    
    
//    Cajas
    public int getRealizado() {
        return realizado;
    }

    public void setRealizado(int realizado) {
        this.realizado = realizado;
    }

    public int getEstudio() {
        return estudio;
    }

    public void setEstudio(int estudio) {
        this.estudio = estudio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
