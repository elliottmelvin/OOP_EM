package As3_Teams;



public class As3_Team {


    static String nickname;
    static String city;
    static String division;
    static int wins;
    static int losses;
    static int rank;

    public As3_Team(String n, String c, String d, int w, int l, int r){
        nickname = n;
        city = c;
        division = d;
        wins = w;
        losses = l;
        rank = r;


    }

    public void  printMe(){
        System.out.println("Name: " + nickname + " City: " + city + " Division: " + division + " Wins: " + wins + " Losses: " + losses + " Rank: " + rank);
    }
}
