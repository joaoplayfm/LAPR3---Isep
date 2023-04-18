package app.Model;

public class Racao extends Armazem{
    public double id_racao;

    public Racao(double id_racao, Armazem armazem) {
        super(armazem.getId_armazem());
        this.id_racao = id_racao;
    }

    public double getId_racao() {
        return id_racao;
    }

    public void setId_racao(double id_racao) {
        this.id_racao = id_racao;
    }
}
