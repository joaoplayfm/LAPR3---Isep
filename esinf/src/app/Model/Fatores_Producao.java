package app.Model;

public class Fatores_Producao extends Armazem{
    public double id_fat_producao;
    public String classificacao;
    public String nome;
    public String formulacao;

    public Fatores_Producao(double id_fat_producao, String classificacao, String nome, String formulacao, Armazem armazem) {
        super(armazem.id_armazem);
        this.id_fat_producao = id_fat_producao;
        this.classificacao = classificacao;
        this.nome = nome;
        this.formulacao = formulacao;
    }

    public Fatores_Producao(double id_fat_producao) {
        super(id_fat_producao);
    }

    public double getId_fat_producao() {
        return id_fat_producao;
    }

    public void setId_fat_producao(double id_fat_producao) {
        this.id_fat_producao = id_fat_producao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormulacao() {
        return formulacao;
    }

    public void setFormulacao(String formulacao) {
        this.formulacao = formulacao;
    }
}
