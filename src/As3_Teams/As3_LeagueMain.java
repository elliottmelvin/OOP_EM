package As3_Teams;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {


    public static void run() {

        ArrayList<As3_Team> allTeams = new ArrayList<>();
        loadFile("data/NBA Teams.csv", allTeams);
//        for (As3_Team allTeam : allTeams) {
//            allTeam.printMe();
//        }
        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println(allTeams.get(5).nickname);
        }

        while(0 == 0){
            System.out.println("Press 1 to ");
            break;
        }
//        System.out.println(allTeams.get(5).printMe());
    }

    public static void loadFile(String filename, ArrayList<As3_Team> list) {
        int i = 0;
        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while (file.ready()) {

                dataToRead = file.readLine();

                String[] tempArray = dataToRead.split(",");

                list.add(new As3_Team(tempArray[0], tempArray[1], tempArray[2], Integer.parseInt(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));
                list.get(i).printMe();
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile
}
