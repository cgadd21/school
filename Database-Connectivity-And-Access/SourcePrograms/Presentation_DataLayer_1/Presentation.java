// Jim Habermas
// Updated: Spring 2023 - February
//
// Java_Presentation_and_DataLayer_Code.zip
//
// Very short Presentation Layer and DataLayer
// First example of using two programs
//                    Presentation Layer  &  Data Layer
// This code is the DataLayer
//
// Prerequisite
// SOURCE D:\ISTE330\SOURCES\Recipes.sql

import java.sql.*;

public class Presentation {

   DataLayer dl = new DataLayer();
   private int columns;

   public Presentation(){
      System.out.println("Connecting to the data recipe...");
      dl.connect();  //Call DataLayer
      System.out.println("You have connected to the database!\n\t\tStudent LastName, Student FirstName");
      System.out.println("\nGoing to fetch the result set...\n Attempting to gather metadata...");

      columns = dl.getResultSet(); // getColumnCount() is what this method performs

      System.out.println("\t\tThe database recipes, table recipe, has the following . . .");
      System.out.println("\nThe number of columns returned from the sql statment is -->  " + columns);
      System.out.println("\nClosing all connections to database...\n");
      dl.close();

      // End Of Job data  -   EOJ  routines
      java.util.Date today = new java.util.Date();
	  System.out.println("\nProgram terminated @ " + today + "\n");
   } // End of Constructor

   public static void main(String [] args){
   	  System.out.println("Created by Student LastName, Student FirstName");
      new Presentation();  // Create a new object. An Instantiation
   } // End of main method
} // End of Class