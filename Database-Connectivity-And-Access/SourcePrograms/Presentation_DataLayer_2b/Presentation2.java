// Jim Habermas
// ISTE 330
// Updated: Fall 2022 @ 12:45pm
//
// Second Example of a Presentation Layer and a Data Layer in two different Java programs.
//
// Output Expected
//     1) column count of recipe   in Recipes Database
//     2) row count of recipe      in Recipes Database
//
// Prerequisite
// SOURCE D:\ISTE330\SOURCES\Recipes.sql

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class Presentation2 {

   DataLayer2 dl = new DataLayer2();
   private int columns;
   private int rows;

   public static Font myFontForOutput = new Font("Courier", Font.BOLD, 20);


   public Presentation2(){
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
      System.out.println("\nThe number of columns returned from the sql statment is -->  " + columns);
      
      rows    = dl.geNumberOfRows_recipe_table();
      System.out.println("\nThe number of rows returned from the sql statment is ----->  " + rows);

      
      
      System.out.println("\nClosing all connections to database...\n");
      dl.close();

      // End Of Job data  -   EOJ  routines
      java.util.Date today = new java.util.Date();
	  System.out.println("\nProgram terminated @ " + today);
   } // End of Constructor

   public static void main(String [] args){
      new Presentation2();  // Create a new object. An Instantiation
      System.out.println("EOJ");
      System.exit(0);
   } // End of main method
} // End of Class