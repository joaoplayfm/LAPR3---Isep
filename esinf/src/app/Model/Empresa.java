package app.Model;

public class Empresa {
    protected String id;
    protected Double lati;
    protected Double longi;
    protected String type;
    protected Double centralDistance;


    public Empresa(String id, Double lati, Double longi, Double centralDistance,String type) {
        this.id = id;
        this.lati = lati;
        this.longi = longi;
        this.centralDistance = centralDistance;
        this.type = type;
    }

    public Double getLati() {
        return lati;
    }

    public Double getLongi() {
        return longi;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Double getCentralDistance() {
        return centralDistance;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", lati=" + lati +
                ", longi=" + longi +
                ", type='" + type + '\'' +
                ", centralDistance=" + centralDistance +
                '}' + "\n";
    }



}