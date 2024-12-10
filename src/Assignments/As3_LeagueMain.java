package Assignments;

import java.util.ArrayList;
import java.io.*;

public class As3_LeagueMain {
    public static void run(){
        ArrayList<As3_Team> allTeams = new ArrayList<>();

        loadFile("data/imaginary_teams.csv", allTeams);

        while(true) {

            System.out.println("Press 1 for a list of teams\nPress 2 to find the highest stats\nPress 3 to view divisions\nPress 4 to sort by wins\nPress 5 to update stats\nPress 6 to exit");


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
                searchHigh(allTeams);
            }
            if (choice == 3) {
                viewDivision(allTeams);
            }
            if (choice == 4) {
                selectionSorIntList(allTeams);
            }
            if (choice == 5) {
                statUpdate(allTeams);
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

    public static void searchHigh(ArrayList<As3_Team> teams){
        As3_Team highestWins = teams.get(0);
        As3_Team highestLosses = teams.get(0);
        As3_Team highestGD = teams.get(0);


        for (As3_Team team : teams) {
            if (team.getWins() > highestWins.getWins()){
                highestWins = team;
            }
            if (team.getLosses() > highestLosses.getLosses()) {
                highestLosses = team;
            }
            if (team.getGoalDiff() > highestGD.getGoalDiff()) {
                highestGD = team;

            }

        }
        System.out.println("The highest wins are held by: " + highestWins.getNickname() + " in " + highestWins.getCity() + " with " + highestWins.getWins());
        System.out.println("The highest losses are held by: " + highestLosses.getNickname() + " in " + highestLosses.getCity() + " with " + highestLosses.getLosses());
        System.out.println("The highest GD are held by: " + highestGD.getNickname() + " in " + highestGD.getCity() + " with " + highestGD.getGoalDiff());
    }

    public static void viewDivision(ArrayList<As3_Team> teams){
        System.out.println("What div do you want to see? 1-3");
        int input = Library.input.nextInt();
        Library.input.nextLine();

        for(As3_Team team : teams){
            if(team.getDivision() == input){
                System.out.println(team);
            }
        }
    }

    public static void selectionSorIntList(ArrayList<As3_Team> teams){


        for (int i = 0; i < teams.size(); i++) {
            int lowestIndex = 1;
            for (int j = i+1; j < teams.size(); j++) {
                if(teams.get(j).getWins() < teams.get(lowestIndex).getWins()){
                    lowestIndex = j;
                }
            }

            As3_Team tempTeam = teams.get(i);
            teams.set(i, teams.get(lowestIndex));
            teams.set(lowestIndex, tempTeam);
        }
    }

    public static void statUpdate(ArrayList<As3_Team> teams){
        System.out.println("Please enter game info");
        System.out.println("What team? will default to first team if incorrect");
        As3_Team selectedTeam = teams.getFirst();
        String lfTeam = Library.input.nextLine();
        for(As3_Team team : teams){
            if(team.getNickname().equalsIgnoreCase(lfTeam)){
                selectedTeam = team;
                System.out.println(selectedTeam.getNickname() + " is selected");
            }
        }
        System.out.println("win? y/n");
        String lfWin = Library.input.nextLine();
        if(lfWin.equals("y")){
            selectedTeam.setWins(selectedTeam.getWins() + 1);
        }else{
            selectedTeam.setLosses(selectedTeam.getLosses() + 1);
        }
        System.out.println("Goal diff of match?");
        int lfGD = Library.input.nextInt();
        Library.input.nextLine();
        selectedTeam.setGoalDiff(selectedTeam.getGoalDiff() + lfGD);
    }

}
