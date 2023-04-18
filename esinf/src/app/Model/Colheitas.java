package app.Model;

import java.util.Date;

public class Colheitas extends Caderno_Campo{


    public double id_colheitas;
    public double quantidade;
    public Date data;

    public Colheitas(double id_colheitas, double quantidade, Date data, Caderno_Campo caderno_campo) {
        super(caderno_campo.getId_caderno());
        this.id_colheitas = id_colheitas;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Colheitas(double id_colheitas) {
        super(id_colheitas);
    }

    public double getId_colheitas() {
        return id_colheitas;
    }

    public void setId_colheitas(double id_colheitas) {
        this.id_colheitas = id_colheitas;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
