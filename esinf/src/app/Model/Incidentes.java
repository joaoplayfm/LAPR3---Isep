package app.Model;

import java.util.Date;

public class Incidentes extends Cliente{
    public double id_incidentes;
    public double valor;
    public Date data_ocorrencia;
    public Date data_sanado;

    public Incidentes(double id_incidentes, double valor, Date data_ocorrencia, Date data_sanado, Cliente cliente) {
        super(cliente.getNif());
        this.id_incidentes = id_incidentes;
        this.valor = valor;
        this.data_ocorrencia = data_ocorrencia;
        this.data_sanado = data_sanado;
    }

    public double getId_incidentes() {
        return id_incidentes;
    }

    public void setId_incidentes(double id_incidentes) {
        this.id_incidentes = id_incidentes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_ocorrencia() {
        return data_ocorrencia;
    }

    public void setData_ocorrencia(Date data_ocorrencia) {
        this.data_ocorrencia = data_ocorrencia;
    }

    public Date getData_sanado() {
        return data_sanado;
    }

    public void setData_sanado(Date data_sanado) {
        this.data_sanado = data_sanado;
    }
}
