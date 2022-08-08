package model.vo;

public class InformeCompraVo {

    private int id;
    private String constructora;
    private String bancoVinculado;

    public InformeCompraVo() {
    }

    public InformeCompraVo(int id, String constructora, String bancoVinculado) {
        this.id = id;
        this.constructora = constructora;
        this.bancoVinculado = bancoVinculado;
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

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }

}
