import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class test3Presentation  extends JFrame   {
   public static Font myFontForOutput = new Font("Courier", Font.PLAIN, 24);
   public static Font myFontForAstric = new Font("Times Roman", Font.BOLD, 45);
   public static JPanel Inputbox = new JPanel(new GridLayout(3,4));

   
   public static JTextField tfUser     = new JTextField("DRJIM");    
   public static JPasswordField tfPassword = new JPasswordField("RIT123");
   
   public test3Presentation(){	
	 JLabel lblUser         = new JLabel("Username  -> ");
	 JLabel lblPassword     = new JLabel("Password  -> ");
	 JLabel lblUserStar     = new JLabel("  *  ");
	 JLabel lblPasswordStar = new JLabel("  *  ");
	 JLabel filler          = new JLabel(" ");
  
	 lblUser.setFont(myFontForOutput);
	 tfUser.setFont(myFontForOutput);
	 tfUser.setForeground(Color.BLUE);
	 lblPassword.setFont(myFontForOutput);
	 tfPassword.setFont(myFontForOutput);
	 tfPassword.setForeground(Color.BLUE);
	 lblUserStar.setForeground(Color.RED);
	
	 Inputbox.add(lblUser);
	 Inputbox.add(tfUser);
	
	 lblUserStar.setFont(myFontForAstric);
	 lblUserStar.setForeground(Color.RED);
	 Inputbox.add(lblUserStar);
	 Inputbox.add(filler);
		           
     Inputbox.add(lblPassword);
     Inputbox.add(tfPassword);
	 
	 lblPasswordStar.setFont(myFontForAstric);
	 lblPasswordStar.setForeground(Color.RED);
	 Inputbox.add(lblPasswordStar);
	 Inputbox.add(filler);
	
	 pack();
	 setDefaultCloseOperation(EXIT_ON_CLOSE);   	 
 }//end of constructor named test3Presentation
	
	
/************************  M A I N    M E T H O D ****************************/		
	public static void main(String [] args)
	{
		System.out.println("ISTE 330 Sample Passwords in Final Projects");
        new test3Presentation();  // call to the constructor
        
        test3Datalayer    dl = new  test3Datalayer();      
		boolean status = dl.connect();
		   
        JOptionPane.showMessageDialog(null, Inputbox,
		  	"Sample Faculty Member Login Screen.  Must check their password against the database.", JOptionPane.QUESTION_MESSAGE);
        
	    String userName = tfUser.getText();
	    // System.out.println("\n\n User -> "+userName);
	    String password = tfPassword.getText(); 
	    System.out.println("\npassword is ->"+password+"<-");
	            
	    String passwordEC = encrypt(password);      
        //System.out.println("\npassword is ->"+password+"<-");

        String DBpassword = new String();
        DBpassword = dl.readFacultyPassword(userName);
		System.out.println("In main,  Database password ->"+DBpassword+"<- ");

        if (DBpassword.equals(passwordEC)) {
			  System.out.println("\n\tLet the user make changes to the faculty informaton.");
		 }
		else {
		      System.out.println("\n\tDo not let this user make changes to the faculty Database!");  
	    }

        System.out.println("\nInserting a new Faculty");
          
        System.out.print("Enter faculty id -> ");
        String facID = GetInput.readLine();
        System.out.print("Enter first name -> ");
        String fname = GetInput.readLine();
        System.out.print("Enter last name -> ");
        String lname = GetInput.readLine(); 
        System.out.print("Enter department -> ");
        int dept = GetInput.readLineInt();
        System.out.print("Enter faculty password -> ");
        String pass = GetInput.readLine();
          
        String passEC = encrypt(pass);  
          
        boolean insertStatus = dl.insertFacultyRecord(facID,fname,lname,dept,passEC);

        if (insertStatus == true)
            System.out.println("\nNew faculty added into Faculty table in Database test!");
        else
            System.out.println("\nERROR, something went wrong trying to insert a new faculty member.");

        System.out.println("\nEND OF PROGRAM");
        java.util.Date now = new java.util.Date(); 
        System.out.println("Program terminated @ " + now);
        JOptionPane.showMessageDialog(null,"Program terminated @ " + now ,
				  	"EOJ", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
}//end main



 public static String encrypt(String secret){//Endcypt password
        String sha1 = "";
        String value = new String(secret);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
   	    digest.reset();
   	    digest.update(value.getBytes("utf8"));
   	    sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
   	}// end of catch
   
       System.out.println( "The sha1 of \""+ value + "\" is:");
   	   System.out.println("--->" + sha1 );
   	   System.out.println();
   	return sha1;
   }//end of encrypt
}//end of class