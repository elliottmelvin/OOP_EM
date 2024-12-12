package As3_Teams;

public class As3_Player {

    private String name;
    private int playerID;
    private int pointsGot;

    public As3_Player(String n, int id, int p){
        name = n;
        playerID = id;
        pointsGot = p;
    }

    public void printMe(){
        System.out.println("Name: " + name + " ID: " + playerID + " Points: " + pointsGot);
    }

    public void addPoints(){

        System.out.println("How many points would you like to give this player?");
        int newPoints = Library.input.nextInt();
        Library.input.nextLine();

        pointsGot += newPoints;
    }

    public int getPointsGot(){
        return pointsGot;
    }

    public String getName(){
        return name;
    }
}
