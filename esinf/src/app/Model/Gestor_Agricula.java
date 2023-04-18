package app.Model;

public class Gestor_Agricula extends Quinta{

    public double num_cc;
    public double idade;
    public String nome;

    public Gestor_Agricula(double num_cc, double idade, String nome, Quinta quinta) {
        super(quinta.getId_quinta());
        this.num_cc = num_cc;
        this.idade = idade;
        this.nome = nome;
    }

    public Gestor_Agricula(double num_cc) {
        super(num_cc);
    }

    public double getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(double num_cc) {
        this.num_cc = num_cc;
    }
}
