package Part1;

public class MainApp {
    public static void main(String[] args) {
        FootballPlayer fp1 = new FootballPlayer("Joe");
        BaseballPlayer bp1 = new BaseballPlayer("Bob");
        SoccerPlayer sp1 = new SoccerPlayer("Max");

        //Nothing is preventing us from adding different
        //sports players to a football team
        Team buffaloBills = new Team("Buffalo Bills");
        buffaloBills.addPlayer(fp1);
        buffaloBills.addPlayer(bp1);
        buffaloBills.addPlayer(sp1);

        System.out.println("# of players: " + buffaloBills.rosterSize());
        buffaloBills.printRoster();

        Team rochesterRhinos = new Team("Rochester Rhinos");

        buffaloBills.updateResults(rochesterRhinos, 10, 12);

        buffaloBills.printStats();

    }
}
