package Part2;

import java.util.ArrayList;

/* When a new team object is created, the object type that gets
    used must be placed in diamonds. The code below ensures that only
    an Athlete type can be used. If BaseballPlayer is the type passed in,
    then all areas where "T" is found will become BaseballPlayer.
 */
public class Team<T extends Athlete>{
    private String teamName;
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesTied = 0;

    //The T here indicates that the ArrayList should store whatever
    //was passed in the diamonds
    private ArrayList<T> members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    //This T ensures that only athletes of a matching type
    //can be added to the roster.
    public boolean addPlayer(T athlete){
        if(members.contains(athlete)){
            System.out.println(athlete.getName() + " is already on the team.");
            return false;
        } else {
            members.add(athlete);
            System.out.println(athlete.getName() + " added to team " + this.teamName + ".");
            return true;
        }
    }

    public int rosterSize(){
        return members.size();
    }

    //The T here ensures that only two like teams can be used
    //with this method.
    public void updateResults(Team<T> opponent, int ourScore, int theirScore){
        if(ourScore > theirScore){
            gamesWon++;
        } else if (ourScore == theirScore){
            gamesTied++;
        } else {
            gamesLost++;
        }
        gamesPlayed++;
        if(opponent != null){
            opponent.updateResults(null, theirScore, ourScore);
        }
    }

}
