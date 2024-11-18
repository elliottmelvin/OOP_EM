package Examples;

public class Ex3_Client {

    private String name;
    private String address;
    private int lawnSize;
    private boolean hasDog;
    private double outstandingFees;

    //constructor method
    public Ex3_Client( String n, String a, int l, boolean d){
        name = n;
        address = a;
        lawnSize = l;
        hasDog = d;
        outstandingFees = 0;
    }//constructor

    public String toString(){
        return name + "   " + address + "   " + lawnSize + "   " + hasDog + "   " + outstandingFees;
    }

    public void printMe(){
        System.out.println();
        System.out.println();
    }

    public void mowLawn() {

        double baseFee = 30;

        if (lawnSize > 200) {
            baseFee += 0.1 * lawnSize;
        }

        outstandingFees += baseFee;

        System.out.println(name + ", your lawn was mowed today for a charge of " + baseFee);
        System.out.println("Your outstanding fees are $" + outstandingFees);
    }//mowLawn

}//Ex3_Client
