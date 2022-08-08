package model.vo;

public class InformeLiderVo {

    private String nombre;
    private String primerApellido;
    private String Ciudad;

    public InformeLiderVo() {
    }

    public InformeLiderVo(String nombre, String primerApellido, String Ciudad) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.Ciudad = Ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

}
