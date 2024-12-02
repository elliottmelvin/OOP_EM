package As1_Crops;

import javax.xml.transform.Source;
import java.util.ArrayList;

public class As1_Main {

    public static void run() {
        ArrayList<As1_Crop> allCrops = new ArrayList<As1_Crop>();

        allCrops.add(new As1_Crop("Saffron", 9, "lbs", 521.34));
        allCrops.add(new As1_Crop("Sugarcane", 28, "tons", 663.00));
        allCrops.add(new As1_Crop("Soybean", 47, "bushels", 9.80));
        allCrops.add(new As1_Crop("Banana", 43, "tons", 497.50));
        allCrops.add(new As1_Crop("Mango", 40, "lbs", 412.00));

        allCrops.get(0).setAcres(200);
        allCrops.get(1).setAcres(200);
        allCrops.get(2).setAcres(400);
        allCrops.get(3).setAcres(100);
        allCrops.get(4).setAcres(100);

        double totalRevenue = 0;

        while(0 == 0){

            System.out.println("Press 1 to Print farm summary\nPress 2 to Search & harvest a crop\nPress 3 to Get total revenue\nPress 4 to Plant a crop\nPress 5 to exit");
            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){
                System.out.println("Here is your farm summary:");

                for (int i = 0; i < allCrops.size(); i++) {
                    System.out.println(allCrops.get(i).printMe());
                }
                System.out.println();
            }

            if(choice == 2){
                System.out.println("What crop would you like to search for?");
                String searchCrop = Library.input.nextLine();

                int foundIndex = searchByName(allCrops, searchCrop);

                if(foundIndex == -1){
                    System.out.println("Could not find that crop");
                }
                else{
                    System.out.println(allCrops.get(foundIndex).printMe());

                    System.out.println("Would you like to harvest the crop");
                    String doHarv = Library.input.nextLine();

                    if (doHarv.toLowerCase().contains("y")){
                        totalRevenue += allCrops.get(foundIndex).harvest();

                    }
                }
            }

            if(choice == 3){
                System.out.println("Here is your total revenue: ");
                System.out.println(totalRevenue);
            }

            if(choice == 4){
                System.out.println("What is the name of the crop you would like to plant?");
                String plantCrop = Library.input.nextLine();

                System.out.println();

                System.out.println("How many acres would you like to plant?");
                int plantAcres = Library.input.nextInt();
                Library.input.nextLine();

                int foundIndex = searchByName(allCrops, plantCrop);

                if(foundIndex != -1){
                   allCrops.get(foundIndex).addAcres(plantAcres);
                }

                else{
                    System.out.println("What is the yield of this crop");
                        int plantYield = Library.input.nextInt();
                        Library.input.nextLine();
                    System.out.println("What is the price per yield of this crop");
                        double plantPrice = Library.input.nextDouble();
                        Library.input.nextLine();
                    System.out.println("What is the units of the yield of this crop");
                        String plantUnit = Library.input.nextLine();

                    allCrops.add(new As1_Crop(plantCrop, plantYield, plantUnit, plantPrice));

                    allCrops.get(searchByName(allCrops, plantCrop)).setAcres(plantAcres);
                }

            }

            if(choice == 5){
                break;
            }
        }
    }

    public static int searchByName(ArrayList<As1_Crop> list, String searchTerm){
        for(int i = 0; i < list.size(); i++){
            if(searchTerm.equalsIgnoreCase(list.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
}
