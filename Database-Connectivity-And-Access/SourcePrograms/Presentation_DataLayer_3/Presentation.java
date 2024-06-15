// Jim Habermas
// UPDATED: Fall 2022
// SOURCE D:\ISTE330\SOURCES\Recipes.sql
//
//    Java_Presentation_and_DataLayer_Code_Third_Example.zip

// DataLayer Code adds a recipe using  PreparedStatement
// DataLayer Code deletes a step for a recipe
// DataLayer counts columns of recipe

// Presentation Layer uses my class    GetInput    to read from the user

// Prerequisite before running program
// INSERT INTO nutrition values("fat",3000,"grams",20);
// INSERT INTO nutrition VALUES("fat",20,"grams",14);

// Let this program do this insert
// INSERT INTO recipe VALUES (14,"Jim H.","Very Good","Beef Stroganoff",4);
//
// Let the program delete step 6 of recipe 5
//
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  


public class Presentation {

   DataLayer dl = new DataLayer();
   
   public static Font myFontForOutput = new Font("Courier", Font.BOLD, 20);
   
   private int columns;

   public Presentation(){
         System.out.println("Connecting to the database Recipes . . .");
	        
	        
	        
	        
	      JPanel Inputbox = new JPanel(new GridLayout(3,2));
	  	  JLabel lblUser     = new JLabel("Username -> ");
	  	  JLabel lblPassword = new JLabel("Password -> ");
	  	  JTextField tfUser     = new JTextField("root");
	  	          //JTextField tfPassword = new JTextField("");
	  	  JTextField tfPassword = new JPasswordField("");
	  	  JLabel lblDatabase    = new JLabel("Database ->");
	  	  JTextField tfDatabase = new JTextField("");
	  	  
	  	  Inputbox.add(lblUser);
	  	  Inputbox.add(tfUser);
	  	  Inputbox.add(lblPassword);
	  	  Inputbox.add(tfPassword);
	  	  Inputbox.add(lblDatabase);
	  	  Inputbox.add(tfDatabase);
	  	  
	  	  lblUser.setFont(myFontForOutput);
	  	  tfUser.setFont(myFontForOutput);
	  	  tfUser.setForeground(Color.BLUE);
	  	  lblPassword.setFont(myFontForOutput);
	  	  tfPassword.setFont(myFontForOutput);
	  	  tfPassword.setForeground(Color.BLUE);
	  	  lblDatabase.setFont(myFontForOutput);
	  	  tfDatabase.setFont(myFontForOutput);
	  	  tfDatabase.setForeground(Color.BLUE);
	  	  
	  	  
	  	  JOptionPane.showMessageDialog(null, Inputbox,
	  	  		 "Input    Default password is \"student\"", JOptionPane.QUESTION_MESSAGE);
	  	  
	  	  
	  	   String userName = tfUser.getText();
	  	   String database = tfDatabase.getText();   
	  	       
	  	       
	  	   String password = new String();
	  	   String passwordInput = new String();
	  	           
	  	   passwordInput = tfPassword.getText();
	  	           
	  	   // set the default password to   "student"
	  	   if (passwordInput.equalsIgnoreCase("")) {
	  	  		 password = "student";                  //CHANGE TO STUDENT
	  	    } 
	  	    else 
	  	    {
	  	  	     password = passwordInput;
        }
      
      
      
      
      
      
      dl.connect(userName,password,database);  //Call DataLayer
      System.out.println("You have connected to the database!");
      System.out.println("\nGoing to fetch the result set...\n Attempting to gather metadata...");

      columns = dl.getResultSet(); // getColumnCount() is what this method performs

      System.out.println("\nThe number of columns returned from the sql statment is -->  " + columns+"\n");
      System.out.print("Enter recipeID to add -> ");
      int recipeID = GetInput.readLineInt();
      System.out.print("Enter \"Source\" of the recipe -> ");
      String source = GetInput.readLine();
      System.out.print("Enter \"Comments\" -> ");
      String comment = GetInput.readLine();
      System.out.print("Enter name of recipe -> ");
      String name = GetInput.readLine();
      System.out.print("Enter number of servings -> ");
      int numServings = GetInput.readLineInt();
      int result = dl.addRecipe(recipeID,source,comment,name,numServings);


      // int result = dl.addRecipe(28,"Jim","Fast Food","Taco",2);

      System.out.println("\nResults of adding a recipe is -> "+result);

      // Let the program delete step 6 of recipe 5
      result = dl.deleteOneRecordFromSteps();
      System.out.println("\nResults of deleting a step is -> "+result);

      System.out.println("\nClosing all connections to database...\n");
      dl.close();

      // End Of Job data  -   EOJ  routines
      java.util.Date today = new java.util.Date();
	  System.out.println("\nProgram terminated @ " + today + "\n");

   } // End of Constructor

   public static void main(String [] args){
      new Presentation();
   } // End of Main
} // End of Class