package app.Model;

import java.util.Objects;

public class Local implements Comparable{
    public String id;
    public Double lati;
    public Double longi;
    public String type;

    public Local(String id, Double lati, Double longi, String type) {
        this.id = id;
        this.lati = lati;
        this.longi = longi;
        this.type = type;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                ", lati=" + lati +
                ", longi=" + longi +
                ", type='" + type + "\n"
                ;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local country1 = (Local) o;
        return Double.compare(country1.lati, lati) == 0 && Double.compare(country1.longi,longi) == 0  && Objects.equals(type, country1.type) && Objects.equals(id, country1.id);
    }
}
