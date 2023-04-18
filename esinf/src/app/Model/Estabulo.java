package app.Model;

public class Estabulo extends Edificio{
    public double id_estabulo;

    public Estabulo(double id_estabulo, Edificio edificio) {
        super(edificio.getTipo_edificio());
        this.id_estabulo = id_estabulo;
    }
}
