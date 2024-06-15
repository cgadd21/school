import java.sql.*;
import java.util.*;

/**
     TRANSACTION CODE.  VIEW EQUIPMENT'S ROWS OFTEN
     Logical output
     1
     2
     3
     4
     STOP  - ALL THE 1,2,3,4 OPERATIONS ARE IN A TRANSACTION
     conn.rollback() - orginal values

     Turn off STARTING A TRANSACTION
     Thus Transaction is off
     5
     6 - Data not changed

     7
     8 - con.comit()  after 8 on the screen  Data not changed it is changed after 9
     conn.commit();
     9 is just a verify data is connected.
 */

public class DemoTransactions
{
   public static void main(String args[])
   {
      Scanner scan = new Scanner(System.in);

      Connection conn = null;

      System.out.println("1-Connecting to a MySQL database, on this computer.");

      try
      {
         String userName = "root";
         String password = "student";
         String url = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         Class.forName("com.mysql.cj.jdbc.Driver");	// Needs driver in dir
         conn = DriverManager.getConnection (url, userName, password);

         System.out.println ("2-Connected. Starting transaction.");

         // Start transaction
         conn.setAutoCommit(false);  ///////////////// begin transaction

         // Do some action
		 Statement stmt = conn.createStatement();
         String sqlString = "UPDATE equipment SET equipmentCapacity=1234 " +
                            " WHERE equipID=568";

         int qty = stmt.executeUpdate(sqlString);
         System.out.println("\n qty updated = "+qty+"\n");
         System.out.println("3-Executed: "+sqlString);
         System.out.println("4-Check database for no change ...");



         System.out.print("\n HOLDING EXECUTION - Please enter a number -> ");
         int hold = GetInput.readLineInt();

         // Rollback
         conn.rollback();
         //end transaction
         conn.setAutoCommit(true);

         System.out.println("5-Rolled back, and ended transaction");
         System.out.print("6-Check for no change. For next tx press enter...");
         scan.nextLine();


         // Start transaction
         conn.setAutoCommit(false); ///////////////// begin transaction

         // Do some action
         stmt.executeUpdate(sqlString);

         System.out.println("7-Executed: "+sqlString);
         System.out.print("8-Check for no change, Press enter to commit...");
         scan.nextLine();

         // Commit
         conn.commit();
         conn.setAutoCommit(true);

         System.out.print("9-Check for change. Statement(s) committed, Press enter...");
         scan.nextLine();

      }
      catch (ClassNotFoundException cnfe){
         System.out.println("No class");
      }
      catch (SQLException ex)
      {
         System.out.println("Error: " + ex.getMessage());
         ex.printStackTrace();
      // handle any errors
         System.out.println("SQLException: " + ex.getMessage());
         System.out.println("SQLState: " + ex.getSQLState());
         System.out.println("VendorError: " + ex.getErrorCode());

      }
      finally
      {
         System.out.println(" \n9-Closing database.");
         try{
            if( conn != null ) conn.close();
         }
         catch(SQLException se){
            System.out.println("Error closing database connections.");
            se.printStackTrace();
         }
      }
      System.out.println("10-Demo is exiting...");
   }
}