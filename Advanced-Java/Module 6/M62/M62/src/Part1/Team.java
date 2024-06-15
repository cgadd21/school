package Part1;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesTied = 0;

    private ArrayList<Athlete> members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public boolean addPlayer(Athlete athlete){
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

    public void updateResults(Team opponent, int ourScore, int theirScore){
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

    public void printRoster(){
        for(Athlete athlete : members){
            System.out.println(athlete);
            System.out.println("***********************");
        }
    }

    public void printStats(){
        System.out.printf("Stats for %s:\n", teamName);
        System.out.printf("Wins: %d\n", gamesWon);
        System.out.printf("Losses: %d\n", gamesLost);
        System.out.printf("Ties: %d\n", gamesTied);
        System.out.printf("Total Games: %d\n", gamesPlayed);
    }

}
