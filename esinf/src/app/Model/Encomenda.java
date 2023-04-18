package app.Model;

import java.util.Date;

public class Encomenda {
    public double id_encomenda;
    public double quantidade;
    public Date data_encomenda;
    public String endereco;
    public String estado_encomenda;
    public Date data_pagamento;
    public Date data_entrega;

    public Encomenda(double id_encomenda, double quantidade, Date data_encomenda, String endereco, String estado_encomenda, Date data_pagamento, Date data_entrega) {
        this.id_encomenda = id_encomenda;
        this.quantidade = quantidade;
        this.data_encomenda = data_encomenda;
        this.endereco = endereco;
        this.estado_encomenda = estado_encomenda;
        this.data_pagamento = data_pagamento;
        this.data_entrega = data_entrega;
    }

    public Encomenda(double id_encomenda) {
        this.id_encomenda = id_encomenda;
    }

    public double getId_encomenda() {
        return id_encomenda;
    }

    public void setId_encomenda(double id_encomenda) {
        this.id_encomenda = id_encomenda;
    }
}
