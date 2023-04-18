package app.Model;

public class Armazem extends Edificio {
    public double id_armazem;

    public Armazem(double id_armazem, Edificio edificio) {
        super(edificio.getTipo_edificio());
        this.id_armazem = id_armazem;
    }

    public Armazem(double id_armazem) {
        super(id_armazem);

    }

    public double getId_armazem() {
        return id_armazem;
    }

    public void setId_armazem(double id_armazem) {
        this.id_armazem = id_armazem;
    }
}
