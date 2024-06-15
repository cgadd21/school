/* Cooper Gadd
CSC 101
This class will create objects of the MainApp class.
*/
//import
import java.text.DecimalFormat;
//class
class Pet{
   //decimal format
   DecimalFormat two = new DecimalFormat("0.00");
   //private data members
   private String name;
   private int age;
   private double fee;
   private boolean status;
   //constructor no parameters
   public Pet(){
      name="Tucker";
      age=1;
      fee=100.00;
      status=true;
   }
   //constructor with two parameters
   public Pet(String str, int num){
      name=str;
      age=num;
      fee=100.00;
      status=true;
   }
   //constructor with four parameters
   public Pet(String str, int num1, double num2, boolean boo){
      name=str;
      age=num1;
      fee=num2;
      status=boo;
   }
   //getter for name
   public String getName(){
      return name;   
   }
   //getter for age
   public int getAge(){
      return age;   
   }
   //getter for fee
   public double getFee(){
      return fee;   
   }
   //getter for status
   public boolean isStatus(){
      return status;   
   }
   //setter for name
   public void setName(String str){
      name=str;
   }
   //setter for age
   public void setAge(int num){
      age=num;
   }
   //setter for fee
   public void setFees(double num){
      fee=num;
   }
   //setter for status
   public void setStatus(boolean boo){
      status=boo;
   }
   //method that displays the animal's information
   public String toString(){
      return "Animal's Name: "+name+" || Animal's Age: "+age+" || Animal's Adoption Fee: "+fee+" || Animal Neutered/Sprayed: "+status;
   }
   //instance method that will update the pets name to include new name
   public void updateName(String str){
      name=name+" "+'"'+str+'"';
   }
   //instance method that will allow the owner to quickly get a discount price for a pet
   public double applyDiscount(double num, double num2){
      double discount = num*num2;
      num=num-discount;
      return num;
   }
   //instance method that will check if the animals age is less than 12 months
   public boolean isBaby(){
      if(this.getAge() <12){
         return true;
      }
      return false;
   }
   //private instance method that will return a string that displays the animal's age in year/month format
   private String formatAge(){
      int totalMonths=this.getAge();
      int years = totalMonths/12;
      int months = totalMonths%12;
      if(years==0){
         return months+" months";
      }
      else{
         return years+" years, "+months+" months";
      }
   }
   //instance method that will show the animal's name, age (in new format), fee, and status
   public String getDescription(){ 
      return "Animal's Name: "+name+" || "+formatAge()+" || "+"Animal's Adoption Fee: $"+two.format(fee)+" || "+"Animal Neutered/Sprayed: "+status;
   }   
}