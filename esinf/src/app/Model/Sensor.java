package app.Model;

public class Sensor extends Estacao_Meteorologica{
    public String tipo_sensor;

    public Sensor(String tipo_sensor, Estacao_Meteorologica estacao) {
        super(estacao.getId_estacao());
        this.tipo_sensor = tipo_sensor;
    }

    public String getTipo_sensor() {
        return tipo_sensor;
    }

    public void setTipo_sensor(String tipo_sensor) {
        this.tipo_sensor = tipo_sensor;
    }
}
