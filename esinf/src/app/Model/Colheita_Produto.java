package app.Model;

public class Colheita_Produto extends Armazem{
    public double id_colheita;

    public Colheita_Produto(double id_colheita, Armazem armazem) {
        super(armazem.getId_armazem());
        this.id_colheita = id_colheita;
    }

    public double getId_colheita() {
        return id_colheita;
    }

    public void setId_colheita(double id_colheita) {
        this.id_colheita = id_colheita;
    }
}
