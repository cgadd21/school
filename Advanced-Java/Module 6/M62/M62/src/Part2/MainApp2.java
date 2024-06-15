package Part2;

public class MainApp2 {
    public static void main(String[] args) {
        FootballPlayer fp1 = new FootballPlayer("Joe");
        BaseballPlayer bp1 = new BaseballPlayer("Bob");
        SoccerPlayer sp1 = new SoccerPlayer("Max");

        Team<FootballPlayer> buffaloBills = new Team<>("Buffalo Bill");
        buffaloBills.addPlayer(fp1);
        //Once Team is parameterized, we get errors when trying to
        //add the wrong athlete type to a team
        //buffaloBills.addPlayer(bp1);
        //buffaloBills.addPlayer(sp1);

        /*Team<String> test = new Team<>("Test");
        test.addPlayer("New Guy");*/

        Team<SoccerPlayer> rochesterRhinos = new Team<>("Rochester Rhinos");
        rochesterRhinos.addPlayer(sp1);

        //buffaloBills.updateResults(rochesterRhinos, 25, 10);

        System.out.println(buffaloBills.rosterSize());
        System.out.println(rochesterRhinos.rosterSize());

    }
}
