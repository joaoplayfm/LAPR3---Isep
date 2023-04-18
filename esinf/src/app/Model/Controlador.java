package app.Model;

public class Controlador extends Sistema_Rega{
    public double id_controlador;
    public String periocidade;
    public double tempo_rega;
    public String ordem_rega;

    public Controlador(double id_controlador, String periocidade, double tempo_rega, String ordem_rega, Sistema_Rega sistema_rega) {
        super(sistema_rega.getId_rega());
        this.id_controlador = id_controlador;
        this.periocidade = periocidade;
        this.tempo_rega = tempo_rega;
        this.ordem_rega = ordem_rega;
    }

    public double getId_controlador() {
        return id_controlador;
    }

    public void setId_controlador(double id_controlador) {
        this.id_controlador = id_controlador;
    }

    public String getPeriocidade() {
        return periocidade;
    }

    public void setPeriocidade(String periocidade) {
        this.periocidade = periocidade;
    }

    public double getTempo_rega() {
        return tempo_rega;
    }

    public void setTempo_rega(double tempo_rega) {
        this.tempo_rega = tempo_rega;
    }

    public String getOrdem_rega() {
        return ordem_rega;
    }

    public void setOrdem_rega(String ordem_rega) {
        this.ordem_rega = ordem_rega;
    }
}
