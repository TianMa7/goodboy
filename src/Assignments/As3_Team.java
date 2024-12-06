package Assignments;
//instance
public class As3_Team {

    //private variables
    private String nickname;
    private String city;
    private int division;
    private int wins;
    private int losses;
    private int goalDiff;

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

    //outputs

    @Override
    public String toString() {
        return "Name: " + nickname + "  City: " + city + "  Division: "  + division + "  Wins: " + wins + "  Losses: " + losses + "  Goal Differential: " + goalDiff;
    }
}
