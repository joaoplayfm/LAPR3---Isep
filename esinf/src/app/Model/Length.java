package app.Model;

public class Length {
    public String id1;
    public String id2;
    public Double length;

    public Length(String id1, String id2, Double length) {
        this.id1 = id1;
        this.id2 = id2;
        this.length = length;
    }

    public String getId1() {
        return id1;
    }

    public String getId2() {
        return id2;
    }

    public Double getLength() {
        return length;
    }

    @Override
    public String toString() {
        return
                "id1='" + id1 + '\'' +
                ", id2='" + id2 + '\'' +
                ", length=" + length +"||";
    }
}
