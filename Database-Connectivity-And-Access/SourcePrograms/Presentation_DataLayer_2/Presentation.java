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
// SOURCE D:\ISTE330\SOURCES\travel    I changed the database to add more functions
//                               February 2023 I made this program UPDATE
//                               a passenger's address

import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Presentation {

   DataLayer dl = new DataLayer();
   private int columns;
   public Font myFontForOutput = new Font("Courier", Font.PLAIN, 32); 
   String databaseName = new String();
   String userName = new String();
   String password = new String();
   
   public Presentation(){

    JPanel databaseBox = new JPanel(new GridLayout(2,1));
    JLabel lblDatabase = new JLabel("Database name?");
    lblDatabase.setFont(myFontForOutput);
    databaseBox.add(lblDatabase);
    JTextField textfieldDatabaseName     = new JTextField("travel");
    textfieldDatabaseName.setFont(myFontForOutput);
    textfieldDatabaseName.setForeground(Color.BLUE);
    databaseBox.add(textfieldDatabaseName);
    JOptionPane.showMessageDialog(null,databaseBox,
             "Database name Input Prompt", JOptionPane.QUESTION_MESSAGE);
    databaseName = textfieldDatabaseName.getText();
    


          JPanel Inputbox = new JPanel(new GridLayout(2,2));
          JLabel lblUser     = new JLabel("Username  -> ");
		  JLabel lblPassword = new JLabel("Password  -> ");
          JTextField tfUser     = new JTextField("root");
        //JTextField tfPassword = new JTextField("");
          JTextField tfPassword = new JPasswordField("");

          Inputbox.add(lblUser);
		  Inputbox.add(tfUser);
		  Inputbox.add(lblPassword);
          Inputbox.add(tfPassword);

          lblUser.setFont(myFontForOutput);
          tfUser.setFont(myFontForOutput);
          tfUser.setForeground(Color.BLUE);
          lblPassword.setFont(myFontForOutput);
          tfPassword.setFont(myFontForOutput);
          tfPassword.setForeground(Color.BLUE);
		 
		  String temp_password = new String();
		 
		  JOptionPane.showMessageDialog(null, Inputbox,
		      		   "Default Password is 'student'", JOptionPane.INFORMATION_MESSAGE);


          userName = tfUser.getText();
          temp_password = tfPassword.getText();
         
          if (temp_password.equals(""))
             {
				 password = "student";
		     }
		  else
		     {
				 password = temp_password;
			 }


      System.out.println("Connecting to the data travel...");
      
      dl.connect(databaseName, userName,password);  //Call DataLayer
      
      System.out.println("You have connected to the database!\n\t\tStudent LastName, Student FirstName");
      System.out.println("\nGoing to fetch the result set...\n Attempting to gather metadata...");

      columns = dl.getResultSet(); // getColumnCount() is what this method performs

      System.out.println("\t\tThe database travel, table passenger, has the following . . .");
      System.out.println("\nThe number of columns returned from the sql statement is -->  " + columns);
     
      JPanel InputboxForUpdate     = new JPanel(new GridLayout(3,2));
	        
      JLabel lbl_passengerID       = new JLabel("Passener ID  -> ");
	  JLabel lbl_street            = new JLabel("Street       -> ");
	  JLabel lbl_zip               = new JLabel("Zip          -> ");
	 
	  JTextField tf_passengerID    = new JTextField("");
	  JTextField tf_street         = new JTextField("");
	  JTextField tf_zip            = new JTextField("");
	 
	  InputboxForUpdate.add(lbl_passengerID);
	  InputboxForUpdate.add(tf_passengerID);
	  InputboxForUpdate.add(lbl_street);
	  InputboxForUpdate.add(tf_street);
	  InputboxForUpdate.add(lbl_zip);
	  InputboxForUpdate.add(tf_zip);
	 
	  lbl_passengerID.setFont(myFontForOutput);
	  tf_passengerID.setFont(myFontForOutput);
	  tf_passengerID.setForeground(Color.BLUE);
	                 
	  lbl_street.setFont(myFontForOutput);
	  tf_street.setFont(myFontForOutput);
	  tf_street.setForeground(Color.BLUE);
	                
	  lbl_zip.setFont(myFontForOutput);
	  tf_zip.setFont(myFontForOutput);
	  tf_zip.setForeground(Color.BLUE);                
	                 
	  JOptionPane.showMessageDialog(null, InputboxForUpdate,
	      		   "SQL UPDATE Prompt", JOptionPane.QUESTION_MESSAGE);
	        
	  //get passenger ID
	  int passengerID   = Integer.parseInt(tf_passengerID.getText());
	  //get street
	  String street     = tf_street.getText();
	  //get ZipCode
      String zipCode    = tf_zip.getText();
     
     
      int updateOk = 0;
      updateOk = dl.updatePassengerAddress(passengerID,street,zipCode);
      System.out.println(updateOk + " <- Update Status");
      
      
      
      
      
       JPanel InputboxForDelete       = new JPanel(new GridLayout(1,2));
	   JLabel lbl_passengerDeleteID    = new JLabel("Passener ID to Delete  -> ");
       JTextField tf_passengerDeleteID  = new JTextField("");
	  	 
	   lbl_passengerDeleteID.setFont(myFontForOutput);
	   tf_passengerDeleteID.setFont(myFontForOutput);
	   tf_passengerDeleteID.setForeground(Color.BLUE);
	  	                 
	   InputboxForDelete.add(lbl_passengerDeleteID);       
	   InputboxForDelete.add(tf_passengerDeleteID);                 
//	   JOptionPane.showMessageDialog(null, InputboxForDelete,
//	  	      		   "DELETE passenger", JOptionPane.QUESTION_MESSAGE);
	  	        
	  //get passenger ID
//	   passengerID   = Integer.parseInt(tf_passengerDeleteID.getText());
	  
      
      
      
      
      
      
      
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