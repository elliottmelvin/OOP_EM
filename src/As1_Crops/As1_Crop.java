package As1_Crops;

public class As1_Crop {

    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;

    public As1_Crop(String n, double y, String u, double p ){
        name = n;
        yield = y;
        units = u;
        price = p;

    }
    public void setAcres(int setAcres) {
        this.acres = setAcres;
    }

    public String toString(){
        return name + " " + yield + " " + units + " " + price + " " + acres;
    }
}
