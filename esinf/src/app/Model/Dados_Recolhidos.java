package app.Model;

public class Dados_Recolhidos extends Caderno_Campo{

    public double id_dados;
    public double vento;
    public double temperatura;
    public double humidade;
    public double radiacao;
    public double pressao;

    public Dados_Recolhidos(double id_dados, double vento, double temperatura, double humidade, double radiacao, double pressao, Caderno_Campo caderno) {
        super(caderno.getId_caderno());
        this.id_dados = id_dados;
        this.vento = vento;
        this.temperatura = temperatura;
        this.humidade = humidade;
        this.radiacao = radiacao;
        this.pressao = pressao;
    }

    public double getId_dados() {
        return id_dados;
    }

    public void setId_dados(double id_dados) {
        this.id_dados = id_dados;
    }

    public double getVento() {
        return vento;
    }

    public void setVento(double vento) {
        this.vento = vento;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumidade() {
        return humidade;
    }

    public void setHumidade(double humidade) {
        this.humidade = humidade;
    }

    public double getRadiacao() {
        return radiacao;
    }

    public void setRadiacao(double radiacao) {
        this.radiacao = radiacao;
    }

    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
}
