package app.Model;

public class Condutor extends Quinta{

    public double num_carta;
    public String nome;
    public double idade;
    public double num_cc;

    public Condutor(double num_carta, String nome, double idade, double num_cc, Quinta quinta) {
        super(quinta.getId_quinta());
        this.num_carta = num_carta;
        this.nome = nome;
        this.idade = idade;
        this.num_cc = num_cc;
    }

    public Condutor(double num_carta) {
        super(num_carta);
    }

    public double getNum_carta() {
        return num_carta;
    }

    public void setNum_carta(double num_carta) {
        this.num_carta = num_carta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getNum_cc() {
        return num_cc;
    }

    public void setNum_cc(double num_cc) {
        this.num_cc = num_cc;
    }
}
