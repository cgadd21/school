import java.util.*;
class Game{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      Scanner s = new Scanner(System.in);
      Player[] players = new Player[5];
      players[0]=new Player();
      players[1]=new Player("Joe","Flying");
      players[2]=new Player("Bob","Telepathy");
      players[3]=new Player("Bill",12,"Magic",100);
      players[4]=new Player("Mike",300,"Vampire",1);
      
      System.out.println("Enter Player's Name: ");
      String pName=scan.nextLine();
      System.out.println("Enter Player's Health: ");
      int pHealth=scan.nextInt();
      System.out.println("Enter Player's Power: ");
      String pPower=s.nextLine();
      System.out.println("Enter Player's Number Of Lives: ");
      int pLives=scan.nextInt();
      
      players[0].setName(pName);
      players[0].setHealth(pHealth);
      players[0].setPower(pPower);
      players[0].setLives(pLives);
      
      for(int i=0; i<players.length; i++){
         System.out.println(players[i].toString());
      }
      for(Player x: players){
         System.out.println("Player's Name: "+x.getName());
         System.out.println("Player's Health: "+x.getHealth());
         System.out.println("Player's Power: "+x.getPower());
         System.out.println("Player's Lives: "+x.getLives());
         System.out.println();
      }
   }
}