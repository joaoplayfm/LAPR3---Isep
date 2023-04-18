package app.Model;

public class Ficha_Tecnica extends Fatores_Producao{
    public double id_ficha_tecnica;
    public double N;
    public double P2O5;
    public double K2O;
    public double CaO;
    public double MgO;
    public double TOC;
    public double mat_org;
    public double acidos_humidos;
    public double acidos_fluvicos;
    public double humidade;
    public double pH;
    public String peso_especifico;
    public String formulacao;

    public Ficha_Tecnica(double id_ficha_tecnica, double n, double p2O5, double k2O, double caO, double mgO, double TOC, double mat_org, double acidos_humidos, double acidos_fluvicos, double humidade, double pH, String peso_especifico, String formulacao, Fatores_Producao fatores_producao) {
        super(fatores_producao.getId_fat_producao());
        this.id_ficha_tecnica = id_ficha_tecnica;
        N = n;
        P2O5 = p2O5;
        K2O = k2O;
        CaO = caO;
        MgO = mgO;
        this.TOC = TOC;
        this.mat_org = mat_org;
        this.acidos_humidos = acidos_humidos;
        this.acidos_fluvicos = acidos_fluvicos;
        this.humidade = humidade;
        this.pH = pH;
        this.peso_especifico = peso_especifico;
        this.formulacao = formulacao;
    }

    public double getId_ficha_tecnica() {
        return id_ficha_tecnica;
    }

    public void setId_ficha_tecnica(double id_ficha_tecnica) {
        this.id_ficha_tecnica = id_ficha_tecnica;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getP2O5() {
        return P2O5;
    }

    public void setP2O5(double p2O5) {
        P2O5 = p2O5;
    }

    public double getK2O() {
        return K2O;
    }

    public void setK2O(double k2O) {
        K2O = k2O;
    }

    public double getCaO() {
        return CaO;
    }

    public void setCaO(double caO) {
        CaO = caO;
    }

    public double getMgO() {
        return MgO;
    }

    public void setMgO(double mgO) {
        MgO = mgO;
    }

    public double getTOC() {
        return TOC;
    }

    public void setTOC(double TOC) {
        this.TOC = TOC;
    }

    public double getMat_org() {
        return mat_org;
    }

    public void setMat_org(double mat_org) {
        this.mat_org = mat_org;
    }

    public double getAcidos_humidos() {
        return acidos_humidos;
    }

    public void setAcidos_humidos(double acidos_humidos) {
        this.acidos_humidos = acidos_humidos;
    }

    public double getAcidos_fluvicos() {
        return acidos_fluvicos;
    }

    public void setAcidos_fluvicos(double acidos_fluvicos) {
        this.acidos_fluvicos = acidos_fluvicos;
    }

    public double getHumidade() {
        return humidade;
    }

    public void setHumidade(double humidade) {
        this.humidade = humidade;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public String getPeso_especifico() {
        return peso_especifico;
    }

    public void setPeso_especifico(String peso_especifico) {
        this.peso_especifico = peso_especifico;
    }

    public String getFormulacao() {
        return formulacao;
    }

    public void setFormulacao(String formulacao) {
        this.formulacao = formulacao;
    }
}
