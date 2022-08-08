package model.vo;

public class InformeProyectoVo {

    private int id;
    private String constructora;
    private int numHabitaciones;
    private String ciudad;

    public InformeProyectoVo() {
    }

    public InformeProyectoVo(int id, String constructora, int numHabitaciones, String ciudad) {
        this.id = id;
        this.constructora = constructora;
        this.numHabitaciones = numHabitaciones;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
