package app.Model;

public class Gestor_Distribuicao extends Quinta{

    public double num_cc;
    public double idade;
    public String nome;

    public Gestor_Distribuicao(double num_cc, double idade, String nome, Quinta quinta) {
        super(quinta.getId_quinta());
        this.num_cc = num_cc;
        this.idade = idade;
        this.nome = nome;
    }

    public double getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(double num_cc) {
        this.num_cc = num_cc;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
