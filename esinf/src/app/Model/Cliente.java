package app.Model;

import java.util.Date;

public class Cliente {
    public double nif;
    public String nome;
    public double num_encomendas;
    public String email;
    public double cod_interno;
    public String morada_corresp;
    public String morada_entrega;
    public double plafond;
    public double num_incidentes;
    public Date data_ultim_incid;
    public String nivel;

    public Cliente(double nif, String nome, double num_encomendas, String email, double cod_interno, String morada_corresp, String morada_entrega, double plafond, double num_incidentes, Date data_ultim_incid, String nivel) {
        this.nif = nif;
        this.nome = nome;
        this.num_encomendas = num_encomendas;
        this.email = email;
        this.cod_interno = cod_interno;
        this.morada_corresp = morada_corresp;
        this.morada_entrega = morada_entrega;
        this.plafond = plafond;
        this.num_incidentes = num_incidentes;
        this.data_ultim_incid = data_ultim_incid;
        this.nivel = nivel;
    }

    public Cliente(double nif) {
        this.nif = nif;
    }

    public double getNif() {
        return nif;
    }

    public void setNif(double nif) {
        this.nif = nif;
    }
}
