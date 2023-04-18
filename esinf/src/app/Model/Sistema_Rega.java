package app.Model;

public class Sistema_Rega extends Edificio{
    public double id_rega;
    public double dimensao_exploracao;
    public String modo_rega;
    public double num_parcelas_culturas;
    public double variedade_fatores_producao;
    public String qualidade_agua;
    public double quantidade_agua;
    public String tipo_distribuicao;

    public Sistema_Rega(double id_rega, double dimensao_exploracao, String modo_rega, double num_parcelas_culturas, double variedade_fatores_producao, String qualidade_agua, double quantidade_agua, String tipo_distribuicao, Edificio edificio) {
        super(edificio.getTipo_edificio());
        this.id_rega = id_rega;
        this.dimensao_exploracao = dimensao_exploracao;
        this.modo_rega = modo_rega;
        this.num_parcelas_culturas = num_parcelas_culturas;
        this.variedade_fatores_producao = variedade_fatores_producao;
        this.qualidade_agua = qualidade_agua;
        this.quantidade_agua = quantidade_agua;
        this.tipo_distribuicao = tipo_distribuicao;
    }

    public Sistema_Rega(double id_rega) {
        super(id_rega);
    }

    public double getId_rega() {
        return id_rega;
    }

    public void setId_rega(double id_rega) {
        this.id_rega = id_rega;
    }
}
