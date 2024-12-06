package Assignments;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {
    public static void run(){
        ArrayList<As3_Team> allTeams = new ArrayList<>();

        loadFile("data/imaginary_teams.csv", allTeams);

        while(true) {

            System.out.println("Press 1 for a list of teams\nPress 2 to find the highest stats\nPress 3 to view divisions\nPress 4 to sort by goal differential\nPress 5 to update stats\nPress 6 to exit");


            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                System.out.println();
                for(As3_Team team : allTeams){
                    System.out.println(team);
                }//for print
                System.out.println();
            }//choice 1
            if (choice == 2) {
                System.out.println("Under construction");
            }
            if (choice == 3) {
                System.out.println("Under construction");
            }
            if (choice == 4) {
                System.out.println("Under construction");
            }
            if (choice == 5) {
                System.out.println("Under construction");
            }
            if (choice == 6) {
                saveFile("data/imaginary_teams.csv", allTeams);

                break;
            }
            System.out.println();

        }//while

        System.out.println("Gooooddd boyyyy");




    }//run

    public static void loadFile(String filename, ArrayList<As3_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As3_Team(  tempArray[0],tempArray[1], Integer.parseInt(tempArray[2]), Integer.parseInt(tempArray[3]) , Integer.parseInt(tempArray[4]) , Integer.parseInt(tempArray[5])   ));

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
                toSave += "," + tempList.get(i).getWins();
                toSave +="," + tempList.get(i).getLosses();
                toSave +="," + tempList.get(i).getGoalDiff();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile

}
