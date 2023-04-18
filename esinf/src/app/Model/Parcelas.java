package app.Model;

public class Parcelas {
    public double id_parcelas;
    public double area;
    public String designacao;
    public String tipo_cultura;
    public String cultura;

    public Parcelas(double id_parcelas, double area, String designacao, String tipo_cultura, String cultura) {
        this.id_parcelas = id_parcelas;
        this.area = area;
        this.designacao = designacao;
        this.tipo_cultura = tipo_cultura;
        this.cultura = cultura;
    }

    public Parcelas(double id_parcelas) {
        this.id_parcelas = id_parcelas;
    }

    public double getId_parcelas() {
        return id_parcelas;
    }

    public void setId_parcelas(double id_parcelas) {
        this.id_parcelas = id_parcelas;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getTipo_cultura() {
        return tipo_cultura;
    }

    public void setTipo_cultura(String tipo_cultura) {
        this.tipo_cultura = tipo_cultura;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }
}
