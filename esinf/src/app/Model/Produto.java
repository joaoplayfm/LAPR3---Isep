package app.Model;

public class Produto extends Colheitas{
    public String nome_produto;
    public double preco_produto;

    public Produto(String nome_produto, double preco_produto, Colheitas colheitas) {
        super(colheitas.getId_colheitas());
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }

}
