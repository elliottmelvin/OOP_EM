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

    public String printMe(){
        return "Crop: " + name + "  Yield: " + yield + "    Units: " + units + "    Price: " + price + "    Acres: " + acres;
    }

    public String getName(){
        return name;
    }

    public double harvest(){
        double harvestAmount = yield * price * acres;
        System.out.println("Harvest value: " + harvestAmount);

        return harvestAmount;
    }

    public void addAcres(int newAcres) {
        acres += newAcres;
    }
}
