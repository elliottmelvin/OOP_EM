package As3_Teams;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {

    static ArrayList<As3_Team> allTeams;

    public static void run() {

        allTeams = new ArrayList<As3_Team>();

        loadFile("data/NBA Teams.csv", allTeams);

        allTeams.get(0).addPlayer("Ingram", 8001, 1605);
        allTeams.get(0).addPlayer("Williamson", 5552, 1822);
        allTeams.get(0).addPlayer("Jones", 2938, 1013);
        allTeams.get(0).addPlayer("Trey", 1087, 1342);
        allTeams.get(0).addPlayer("Alvarado", 9872, 897);

        allTeams.get(1).addPlayer("Tatum", 2376, 2182);

        allTeams.get(2).addPlayer("Washington", 1290, 1001);

        allTeams.get(4).addPlayer("Garland", 9723, 1998);
        allTeams.get(4).addPlayer("Mitchell", 2345, 2305);
        allTeams.get(4).addPlayer("Okoro", 2525, 501);

        allTeams.get(7).addPlayer("Edwards", 1241, 2508);
        allTeams.get(7).addPlayer("Conley", 2397, 691);
        allTeams.get(7).addPlayer("McDaniels", 1988, 989);

        allTeams.get(8).addPlayer("Ivey", 9523, 1198);
        allTeams.get(8).addPlayer("Hayes", 1471, 1);

        allTeams.get(9).addPlayer("Henderson", 8111, 0);
        allTeams.get(9).addPlayer("Sharpe", 1289, 1524);

        while(0 == 0){
            System.out.println("Press 1 to see a list of every team\nPress 2 to find the highest team for any statistic\nPress 3 to view a division\nPress 4 to sort by wins\nPress 5 to update stats\nPress 6 to exit and save\nPress 7 to print players\nPress 8 to see the teams total points\nPress 9 to update a players point total");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){
                for(As3_Team Team : allTeams){
                    Team.printMe();
                }
            }

            if(choice == 2){

                System.out.println("Which stat would you like to search for?");
                String searchStat = Library.input.nextLine();

//                System.out.println("Would you like to find the highest or lowest?\tPress 1 to find highest or 2 for lowest");
//                int whichPole = Library.input.nextInt();

                if(searchStat.equalsIgnoreCase("wins")){
                    int foundIndex = highestWins(allTeams);

                    System.out.println(allTeams.get(foundIndex).nickname + " from " + allTeams.get(foundIndex).city + " have the most " + searchStat + " with " + allTeams.get(foundIndex).wins);
                }

                else if(searchStat.equalsIgnoreCase("losses")){
                    int foundIndex = highestLosses(allTeams);

                    System.out.println(allTeams.get(foundIndex).nickname + " from " + allTeams.get(foundIndex).city + " have the most " + searchStat + " with " + allTeams.get(foundIndex).losses);

                }

                else if(searchStat.equalsIgnoreCase("rank")){
                    int foundIndex = highestRank(allTeams);

                    System.out.println(allTeams.get(foundIndex).nickname + " from " + allTeams.get(foundIndex).city + " have the most " + searchStat + " with " + allTeams.get(foundIndex).rank);

                }

                else{
                    System.out.println("Not a valid statistic");
                }

            }

            if(choice == 3){
                System.out.println("Would you like to view the Eastern or Western conference?");
                String searchDiv = Library.input.nextLine();

                if(searchDiv.equalsIgnoreCase("eastern")){
                    for (int i = 0; i < allTeams.size(); i++) {
                        if(allTeams.get(i).division.equalsIgnoreCase("East")){
                            allTeams.get(i).printMe();
                        }
                    }
                }
                else if(searchDiv.equalsIgnoreCase("western")){
                    for (int i = 0; i < allTeams.size(); i++) {
                        if(allTeams.get(i).division.equalsIgnoreCase("West")){
                            allTeams.get(i).printMe();
                        }
                    }
                }
            }

            if(choice == 4){
                sortByWins(allTeams);

                System.out.println("Teams sorted by wins");
            }

            if(choice == 5){
                System.out.println("What is the name of the team which won?");
                String winTeam = Library.input.nextLine();

                System.out.println("What is the name of the team which lost?");
                String loseTeam = Library.input.nextLine();

                for(As3_Team team : allTeams){
                    if(team.nickname.equalsIgnoreCase(winTeam)){
                        team.addWin();
                    } else if (team.nickname.equalsIgnoreCase(loseTeam)) {
                        team.addLoss();
                    }
                }
            }

            if(choice == 6){
                saveFile("data/NBA Teams.csv", allTeams);
                break;
            }

            if(choice == 7){
                System.out.println("What team's players would you like to see?");
                String searchTeam = Library.input.nextLine();

                for (As3_Team team : allTeams){
                    if(searchTeam.equalsIgnoreCase(team.getNickname())){
                        team.printMyPlayers();
                    }
                }
            }

            if(choice == 8){
                for(As3_Team team : allTeams){
                    System.out.println("The " + team.getNickname() + " have " + team.totalPoints() + " Points as a team");
                }
            }

            if(choice == 9){
                System.out.println("Which player would you like to give points to?");
                String searchName = Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    for (int j = 0; j < allTeams.get(i).players.size(); j++) {
                        if(searchName.equalsIgnoreCase(allTeams.get(i).players.get(j).getName())){
                            allTeams.get(i).players.get(j).addPoints();
                        }
                    }
                }
            }
        }

    }

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();


                    String[] tempArray = dataToRead.split(",");

                    list.add(new As3_Team(tempArray[0], tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }//end loadFile

    public static void saveFile(String filename, ArrayList <As3_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getNickname();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getCity();
                toSave += "," + tempList.get(i).getDivision();
                toSave +="," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getLosses();
                toSave +="," + tempList.get(i).getRank();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

//    public static int findPolar(ArrayList list, String stat, int pole){
//
//
//
//        if(pole == 1) {
//
//            int highest = 0;
//            for (int i = 0; i < list.size() - 1; i++) {
//                if (list.get(highest).stat > list.get(i + 1).stat) {
//                    highest = i;
//                } else {
//                    highest = i + 1;
//                }
//            }
//
//            return highest;
//        }
//
//        else{
//            int lowest = 0;
//            for (int i = 0; i < list.size() - 1; i++) {
//                if (list.get(lowest).stat > list.get(i + 1).stat) {
//                    lowest = i;
//                } else {
//                    lowest = i + 1;
//                }
//            }
//
//            return lowest;
//        }
//    }

        public static int highestWins(ArrayList<As3_Team> list){
            int highestIndex = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(highestIndex).getWins() < list.get(i).getWins()){
                    highestIndex = i;
                }
            }

            return highestIndex;
        }

    public static int highestLosses(ArrayList<As3_Team> list){
        int highestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(highestIndex).getLosses() < list.get(i).getLosses()){
                highestIndex = i;
            }
        }

        return highestIndex;
    }

    public static int highestRank(ArrayList<As3_Team> list){
        int highestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(highestIndex).getRank() < list.get(i).getRank()){
                highestIndex = i;
            }
        }

        return highestIndex;
     }

    public static void sortByWins(ArrayList<As3_Team> list){
        for(int i=0; i<list.size()-1; i++){
            int lowestIndex = i;
            for(int j=i+1; j<list.size(); j++){
                if(list.get(j).getWins() < list.get(lowestIndex).getWins()){
                    lowestIndex = j;
                }
            }
            //swap the data
            As3_Team temp = list.get(i);
            list.set(i, list.get(lowestIndex));
            list.set(lowestIndex, temp);

        }
    }
}
