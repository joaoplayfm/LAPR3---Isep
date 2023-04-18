package app.Model;

import java.util.Date;

public class Rega extends Caderno_Campo{
    public double id_rega_diaria;
    public Date data;
    public double quantidade;
    public String parcela;

    public Rega(double id_rega_diaria, Date data, double quantidade, Caderno_Campo caderno_campo) {
        super(caderno_campo.getId_caderno());
        this.id_rega_diaria = id_rega_diaria;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Rega(String parcela, double quantidade, double id_rega_diaria){
        super(0);
        this.parcela = parcela;
        this.id_rega_diaria = id_rega_diaria;
        this.quantidade = quantidade;
    }


    public double getId_rega_diaria() {
        return id_rega_diaria;
    }

    public void setId_rega_diaria(double id_rega_diaria) {
        this.id_rega_diaria = id_rega_diaria;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Rega{" +
                "id_rega_diaria=" + id_rega_diaria +
                ", data=" + data +
                ", quantidade=" + quantidade +
                ", parcela='" + parcela + '\'' +
                '}';
    }
}
