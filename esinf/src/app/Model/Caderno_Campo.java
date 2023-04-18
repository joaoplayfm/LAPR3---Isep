package app.Model;

public class Caderno_Campo extends Gestor_Agricula{

    public double id_caderno;
    public double fertilizacoes;

    public Caderno_Campo(double id_caderno, double fertilizacoes, Gestor_Agricula gestor_agricula) {
        super(gestor_agricula.num_cc);
        this.id_caderno = id_caderno;
        this.fertilizacoes = fertilizacoes;
    }

    public Caderno_Campo(double id_caderno) {
        super(id_caderno);
    }

    public double getId_caderno() {
        return id_caderno;
    }

    public void setId_caderno(double id_caderno) {
        this.id_caderno = id_caderno;
    }

    public double getFertilizacoes() {
        return fertilizacoes;
    }

    public void setFertilizacoes(double fertilizacoes) {
        this.fertilizacoes = fertilizacoes;
    }
}
