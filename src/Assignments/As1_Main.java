package Assignments;

import java.util.ArrayList;

public class As1_Main {
    public static void run(){
        ArrayList <As1_Crops> allCrops = new ArrayList<>();

        allCrops.add(new As1_Crops("Corn", 181.8, "bushels", 4.85));
        allCrops.add(new As1_Crops("Wheat", 67.4, "bushels", 6.50));
        allCrops.add(new As1_Crops("Soybeans", 50.2, "bushels", 12.70));
        allCrops.add(new As1_Crops("Rice", 75.00, "kilograms", 0.20));
        allCrops.add(new As1_Crops("Potatoes", 45.00, "kilograms", 0.10));

        allCrops.get(0).setAcres(   100   );
        allCrops.get(1).setAcres(   200   );
        allCrops.get(2).setAcres(   300   );
        allCrops.get(3).setAcres(   250   );
        allCrops.get(4).setAcres(   150   );

        double totalRev = 0;

        while (true) {

            System.out.println("1. Print Farm Summary");
            System.out.println();
            System.out.println("2. Search & Harvest a crop");
            System.out.println();
            System.out.println("3. Get total revenue");
            System.out.println();
            System.out.println("4. Plant a crop");
            System.out.println();
            System.out.println("5. Exit");
            System.out.println();

            int input = Library.input.nextInt();
            Library.input.nextLine();
            if(input == 1){
                for(As1_Crops crop : allCrops){
                    System.out.println(crop);
                }
            }
            if(input == 2){
                System.out.println("What to search");
                int i = searchByName(allCrops, Library.input.nextLine());


                if( i == -1){
                    System.out.println("None found, try again");
                }else{
                    System.out.println("Do you want to harvest? y/n");
                    String ifHarvest = Library.input.nextLine();
                    if(ifHarvest.equalsIgnoreCase("y")){
                        System.out.println();
                        totalRev += allCrops.get(i).harvest();
                    }
                }
            }
            if(input == 3){
                System.out.println("revenune is: " + totalRev);
            }
            if(input == 4){
                System.out.println("new crops name");
                String newName = Library.input.nextLine();
                System.out.println("acres?");
                int newAcres = Library.input.nextInt();
                Library.input.nextLine();

                if(searchByName(allCrops, newName) == -1) {
                    System.out.println("What is the yield");
                    double yield = Library.input.nextDouble();
                    Library.input.nextLine();

                    System.out.println("What units are you using?");
                    String units = Library.input.nextLine();

                    System.out.println("What is the price?");
                    double price = Library.input.nextDouble();
                    Library.input.nextLine();

                    allCrops.add(new As1_Crops(newName, yield, units, price));
                    allCrops.get(searchByName(allCrops, newName)).setAcres(newAcres);
                } else {
                    allCrops.get(searchByName(allCrops, newName)).addAcres(newAcres);
                }
            }
            if(input == 5){
                break;
            }
        }
    }

    public static int searchByName(  ArrayList<As1_Crops> list, String searchTerm   ){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase(  list.get(i).getName()      )){
                return i;
            }
        }
        return -1;
    }
}
