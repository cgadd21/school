import java.util.*;
import java.sql.*;
import javax.swing.*;


public class test3Datalayer{	
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private String sql;
	final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

  public boolean connect(){
	      conn = null;
	
	      String databaseName = new String("test3");
		  String userName = new String("root");
	      String password = new String("student");
	
	      String url = "jdbc:mysql://localhost/" + databaseName;
	
	      url = url + "?serverTimezone=UTC"; //  Mac Users
	
		  String passwordInput = JOptionPane.showInputDialog(null,"Enter password. If 'student' HIT ok",
		                     "Database Connection - Requires Local Database Password.", JOptionPane.QUESTION_MESSAGE);
	
	     if (passwordInput.equalsIgnoreCase("")) {
	       password = "student";
	      }
	     else{
		   password = passwordInput;
	     }
	
	   try{
	         Class.forName(DEFAULT_DRIVER);
	         conn = DriverManager.getConnection(url, userName, password);
	         System.out.println("\nCreated Connection to the Faculty table in test3 Database!\n");
	         return true;
	      }
	      catch(ClassNotFoundException cnfe){
			 System.out.println("ERROR, CAN NOT CONNECT!!");
	         System.out.println("Class");
	         System.out.println("ERROR MESSAGE-> "+cnfe);
	         System.exit(0);
	      }
	      catch(SQLException sqle){
			 System.out.println("ERROR SQLExcepiton in connect()");
			 System.out.println("ERROR MESSAGE -> "+sqle);
	         sqle.printStackTrace();
	         System.exit(0);
	      }//end of catch
	
	      return (false);
	   } // End of connect method


	public String readFacultyPassword(String factID) {   // Username came fron the first GUI Input Box  = FacultyID
	       int result = 0;
	       String DBpassword = new String();
	       try {
	           PreparedStatement stmt2;
	           stmt2 = conn.prepareStatement("SELECT password FROM faculty WHERE facultyID = ?");
		       stmt2.setString(1,factID);
	           rs = stmt2.executeQuery(); 
	           while(rs.next()) {
			      DBpassword = rs.getString(1);
			     }//end of while loop
	         }// endn of try
	        catch(Exception e)
	         {
				 System.out.println("Error whlie getting password from database");
				 System.out.println("Error message is --> "+e);
			}//end of catch		
			return DBpassword;
    }// end of method
    
    
    public boolean insertFacultyRecord(String facultyID, String fname, String lname, int department, String password) {
	       boolean result = true;
           int x = 0;
	       try {
	           PreparedStatement stmt3;
	           stmt3 = conn.prepareStatement("INSERT INTO faculty VALUES(?,?,?,?,?)");
		       stmt3.setString(1,facultyID);
		       stmt3.setString(2,fname);
		       stmt3.setString(3,lname);
		       stmt3.setInt(4,department);   
		       stmt3.setString(5,password);
	           x = stmt3.executeUpdate();     // Performs the update command
	           if (x > 0 )
	              result = true;
	           else
	              result = false;
	       }// endn of try
	       catch(Exception e) {
				 System.out.println("Error whlie trying to insert a record or close.");
				 System.out.println("Error message is --> "+e);
				 result = false;
			}//end of catch
			
	   return result;
    }// end of method
}//end of class