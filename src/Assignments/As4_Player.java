package Assignments;

public class As4_Player {

    private String Name;
    private int PlayerID;
    private int goalsScored;

    public As4_Player(String n, int p, int g){
        Name = n;
        PlayerID = p;
        goalsScored = g;
    }

    public String toString(){
        return "Name: " + Name + "  PlayerID: "  + PlayerID + "  Goals Scored: " + goalsScored;
    }

    public void addGoal(){
        goalsScored += 1;
    }

    public String getName() {
        return Name;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public int getGoalsScored() {
        return goalsScored;
    }


}
