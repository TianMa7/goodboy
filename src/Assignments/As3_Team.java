package Assignments;

import java.util.ArrayList;
import java.io.*;
//instance
public class As3_Team {

    //private variables
    private String nickname;
    private String city;
    private int division;
    private int wins;
    private int losses;
    private int goalDiff;

    private ArrayList<As4_Player> allPlayers = new ArrayList<>();



    public As3_Team( String n , String c , int d , int w , int l , int gd ){
        nickname = n;
        city = c;
        division = d;
        wins = w;
        losses = l;
        goalDiff = gd;
    }//constructor

    //getters
    public String getNickname() {
        return nickname;
    }

    public String getCity() {
        return city;
    }

    public int getDivision() {
        return division;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getGoalDiff() {
        return goalDiff;
    }

    public void addPlayer(String n, int p, int g){
        allPlayers.add(new As4_Player(n, p, g));
    }


    //setters

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setGoalDiff(int goalDiff) {
        this.goalDiff = goalDiff;
    }
    //outputs

    @Override
    public String toString() {
        return "Name: " + nickname + "  City: " + city + "  Division: "  + division + "  Wins: " + wins + "  Losses: " + losses + "  Goal Differential: " + goalDiff;
    }

    public void printPlayers(){
        for(As4_Player player : allPlayers){
            System.out.println(player);
        }
    }

    public String totalStats(){
        int totGoals = 0;
        for(As4_Player player : allPlayers){
            totGoals += player.getGoalsScored();
        }
        return "Name: " + nickname + "  City: " + city + "  Division: "  + division + "  Wins: " + wins + "  Losses: " + losses + "  Goal Differential: " + goalDiff + " total goals: " + totGoals;
    }

    public void updatePlayers(){
        System.out.println("what player");
        String input4 = Library.input.nextLine();
        for(As4_Player player : allPlayers){
            if(player.getName().equalsIgnoreCase(input4)){
                player.addGoal();
            }
        }
    }


}
