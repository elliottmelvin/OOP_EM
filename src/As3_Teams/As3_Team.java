package As3_Teams;

import java.util.ArrayList;

public class As3_Team {

    ArrayList<As3_Player> players = new ArrayList<>();

     String nickname;
     String city;
     String division;
     int wins;
     int losses;
     int rank;

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

    public void printMyPlayers(){
        for(As3_Player player : players){
            player.printMe();
        }
    }

    public String getNickname(){
        return nickname;
    }

    public String getCity(){
        return city;
    }

    public String getDivision(){
        return division;
    }

    public int getWins(){
        return wins;
    }

    public int getLosses(){
        return losses;
    }

    public int getRank(){
        return rank;
    }

    public void addWin(){
        wins += 1;
    }

    public void addLoss(){
        losses += 1;
    }

    public void addPlayer(String n, int id, int p){
        players.add(new As3_Player(n, id, p));
    }

    public int totalPoints(){
        int tp = 0;
        for(As3_Player player : players){
            tp += player.getPointsGot();
        }

        return tp;
    }
}
