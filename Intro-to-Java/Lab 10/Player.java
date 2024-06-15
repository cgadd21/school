import java.text.*;
class Player{
   private String name;
   private int health;
   private String power;
   private int lives;
   public Player(){
      name="Cooper";
      health=100;
      power="Telepathy";
      lives=29;
   }
   public Player(String word, String phrase){
      name=word;
      health=50;
      power=phrase;
      lives=16;
   }
   public Player(String word, int value, String phrase, int num){
      name=word;
      health=value;
      power=phrase;
      lives=num;
   }
   public String getName(){
      return name;
   }
   public int getHealth(){
      return health;
   }
   public String getPower(){
      return power;
   }
   public int getLives(){
      return lives;
   }
   public void setName(String word){
      name=word;
   }
   public void setHealth(int value){
      health=value;
   }
   public void setPower(String phrase){
      power=phrase;
   }
   public void setLives(int num){
      lives=num;
   }
   public String toString(){
      return "Player's Name: "+name+", "+"Player's Health: "+health+", "+"Player's Power: "+power+", "+"Player's Lives: "+lives+".";
   }
}