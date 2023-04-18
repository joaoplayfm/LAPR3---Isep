package app.Model;

public class Cabaz {
    public String id;
    public int day;
    public Double prod1;
    public Double prod2;
    public Double prod3;
    public Double prod4;
    public Double prod5;
    public Double prod6;
    public Double prod7;
    public Double prod8;
    public Double prod9;
    public Double prod10;
    public Double prod11;
    public Double prod12;

    public Double prod13;

    public Double prod14;

    public Double prod15;

    public Double prod16;

    public Double prod17;

    public Double prod18;

    public Double prod19;

    public Double prod20;


    public Cabaz(String id, int day, Double prod1, Double prod2, Double prod3, Double prod4, Double prod5, Double prod6, Double prod7, Double prod8, Double prod9, Double prod10, Double prod11, Double prod12) {
        this.id = id;
        this.day = day;
        this.prod1 = prod1;
        this.prod2 = prod2;
        this.prod3 = prod3;
        this.prod4 = prod4;
        this.prod5 = prod5;
        this.prod6 = prod6;
        this.prod7 = prod7;
        this.prod8 = prod8;
        this.prod9 = prod9;
        this.prod10 = prod10;
        this.prod11 = prod11;
        this.prod12 = prod12;
    }

    public Cabaz(String id, int day, Double prod1, Double prod2, Double prod3, Double prod4, Double prod5, Double prod6, Double prod7, Double prod8, Double prod9, Double prod10, Double prod11, Double prod12, Double prod13, Double prod14, Double prod15, Double prod16, Double prod17, Double prod18, Double prod19, Double prod20) {
        this.id = id;
        this.day = day;
        this.prod1 = prod1;
        this.prod2 = prod2;
        this.prod3 = prod3;
        this.prod4 = prod4;
        this.prod5 = prod5;
        this.prod6 = prod6;
        this.prod7 = prod7;
        this.prod8 = prod8;
        this.prod9 = prod9;
        this.prod10 = prod10;
        this.prod11 = prod11;
        this.prod12 = prod12;
        this.prod13 = prod13;
        this.prod14 = prod14;
        this.prod15 = prod15;
        this.prod16 = prod16;
        this.prod17 = prod17;
        this.prod18 = prod18;
        this.prod19 = prod19;
        this.prod20 = prod20;
    }

    public String getId() {
        return id;
    }

    public int getDay() {
        return day;
    }

    public Double getProd1() {
        return prod1;
    }

    public Double getProd2() {
        return prod2;
    }

    public Double getProd3() {
        return prod3;
    }

    public Double getProd4() {
        return prod4;
    }

    public Double getProd5() {
        return prod5;
    }

    public Double getProd6() {
        return prod6;
    }

    public Double getProd7() {
        return prod7;
    }

    public Double getProd8() {
        return prod8;
    }

    public Double getProd9() {
        return prod9;
    }

    public Double getProd10() {
        return prod10;
    }

    public Double getProd11() {
        return prod11;
    }

    public Double getProd12() {
        return prod12;
    }

    public Double getProd13() {
        return prod13;
    }

    public Double getProd14() {
        return prod14;
    }

    public Double getProd15() {
        return prod15;
    }

    public Double getProd16() {
        return prod16;
    }

    public Double getProd17() {
        return prod17;
    }

    public Double getProd18() {
        return prod18;
    }

    public Double getProd19() {
        return prod19;
    }

    public Double getProd20() {
        return prod20;
    }

    public Double getProdGeneric(int i){
        Double prod = 0.0;
        if(i==1){
            prod = prod1;
        }

        if(i==2){
            prod = prod2;
        }

        if(i==3){
            prod = prod3;
        }
        if(i==4){
            prod = prod4;
        }
        if(i==5){
            prod = prod5;
        }
        if(i==6){
            prod = prod6;
        }
        if(i==7){
            prod = prod7;
        }
        if(i==8){
            prod = prod8;
        }
        if(i==9){
            prod = prod9;
        }
        if(i==10){
            prod = prod10;
        }
        if(i==11){
            prod = prod11;
        }
        if(i==12){
            prod = prod12;
        }
        if(i==13){
            prod = prod13;
        }
        if(i==14){
            prod = prod14;
        }
        if(i==15){
            prod = prod15;
        }
        if(i==16){
            prod = prod16;
        }
        if(i==17){
            prod = prod17;
        }
        if(i==18){
            prod = prod18;
        }
        if(i==19){
            prod = prod19;
        }
        if(i==20){
            prod = prod20;
        }
        return prod;
    }

    @Override
    public String toString() {
        return "Cabaz{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", prod1=" + prod1 +
                ", prod2=" + prod2 +
                ", prod3=" + prod3 +
                ", prod4=" + prod4 +
                ", prod5=" + prod5 +
                ", prod6=" + prod6 +
                ", prod7=" + prod7 +
                ", prod8=" + prod8 +
                ", prod9=" + prod9 +
                ", prod10=" + prod10 +
                ", prod11=" + prod11 +
                ", prod12=" + prod12 +
                ", prod13=" + prod13 +
                ", prod14=" + prod14 +
                ", prod15=" + prod15 +
                ", prod16=" + prod16 +
                ", prod17=" + prod17 +
                ", prod18=" + prod18 +
                ", prod19=" + prod19 +
                ", prod20=" + prod20 +
                '}';
    }
}
