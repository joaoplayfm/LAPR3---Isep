package app.Model;

public class Garagens extends Edificio{
    public double id_garagens;

    public Garagens(double id_garagens, Edificio edificio) {
        super(edificio.getTipo_edificio());
        this.id_garagens = id_garagens;
    }
}
