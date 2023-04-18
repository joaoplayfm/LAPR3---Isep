package app.Model;

public class Estacao_Meteorologica extends Sistema_Rega{
    public double id_estacao;

    public Estacao_Meteorologica(double id_estacao, Sistema_Rega sistema_rega) {
        super(sistema_rega.getId_rega());
        this.id_estacao = id_estacao;
    }

    public Estacao_Meteorologica(double id_estacao) {
        super(id_estacao);
    }

    public double getId_estacao() {
        return id_estacao;
    }

    public void setId_estacao(double id_estacao) {
        this.id_estacao = id_estacao;
    }
}
