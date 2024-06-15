// DataLayer
// ISTE330

import java.sql.*;

public class DataLayer {

    // attributes
    Connection conn;
    ResultSet rs;
    String sql;
    int col;

    final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    // empty constructor
    public DataLayer() {
    }

    // attempts to connect to the database
    // returns true if connection works, false otherwise
    public boolean connect() {
        // EDIT USERNAME AND PASSWORD HERE
        conn = null;
        String userName = "root";
        String password = "student";
        String url = "jdbc:mysql://localhost/test3";

        // attempt to connect to the database
        try {
            Class.forName(DEFAULT_DRIVER);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("\nConnected to db\n");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ERROR, CAN NOT CONNECT!!");
            System.out.println("ERROR MESSAGE-> "+cnfe);
            System.exit(0);
        } catch (SQLException sqle) {
            System.out.println("ERROR SQLExcepiton in connect()");
            System.out.println("ERROR MESSAGE -> "+sqle);
            sqle.printStackTrace();
            System.exit(0);
        }

        // if conn is not null, a connection has been made
        return (conn!=null);
    }

    // attempts to close all of the elements used to make connection and perform queries
    public void close() {
        try {
            rs.close();
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("ERROR IN METHOD close()");
            System.out.println("ERROR MESSAGE -> " + sqle);
        } catch (NullPointerException npe) {
            // do nothing - if there is none created, it is ok to close anyway
        }// end of catch
    }// end of close





    // attempts to deposit money into the specified account by using a transaction
    // returns true if the transaction is successful and false if it is not
    public boolean deposit(String ownerFirstname, String ownerLastname, String accountType, double depAmt) {
        int id = 0;
        double currentBalance = 0.0;

        try {

            System.out.println("\nAttempting to deposit to " + ownerLastname + "'s account");
            // start the transaction
            startTransaction();

            // prepared statement to deposit the money into the given account type for the owner

            // first get the ownerid from the name
            PreparedStatement accountId = conn.prepareStatement("SELECT ownerId FROM accounts_owner WHERE accountOwnerFirstname  = ? and accountOwnerLastname = ?;");
            accountId.setString(1, ownerFirstname);
            accountId.setString(2, ownerLastname);
            rs = accountId.executeQuery();

            if (rs.isBeforeFirst()) {
                while(rs.next()) {
                    id = rs.getInt(1);
                    //debug print statement
                    System.out.println("Id number for " + ownerLastname + " is: " + id);

             
                }
            } else {
                // if there is not data in the result set, then the account does not exist and the transaction needs to be rolled back
                System.out.println("Could not find account for " + ownerLastname + ", rolling back " + ownerLastname + "'s account.");
                return false;
            }//end of else
       
// INSERT CODE HERE

            
	   }// end of try
	   catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
       }// end of catch




      try {
	  startTransaction();
      // second statement to get the current balance of the account
	  PreparedStatement balance = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ? AND account_type = ?;");
	  balance.setInt(1, id);
	  balance.setString(2, accountType);

	  rs = balance.executeQuery();

	  // get the balance from the results
	  while(rs.next()) {
	       currentBalance = rs.getDouble(1);
	       System.out.println("Beginning Balance: " + currentBalance);
	  }// end of while

      if (currentBalance == 0)
         {
			 System.out.println("\nNO STARTING balance");
			 rollbackTransaction();
			 return false;
	     };


// READY TO UPDATE THE BALANCE.
            if (id != 0) {
                PreparedStatement UpdateBalance = conn.prepareStatement("UPDATE accounts set balance = balance + ? where id = ?");
			    UpdateBalance.setDouble(1, depAmt);
		  	    UpdateBalance.setInt(2, id);
                int x = UpdateBalance.executeUpdate();
              
            //  Display X, and it should be 1 if success.  Debugging.   
             
                System.out.println("In Data Layer, in deposit. x->"+x+"<-");
		        commitTransaction();
			   }
		    else{
		        rollbackTransaction();
		 }




    }//end of try block
    catch (SQLException sqle) {


	            sqle.printStackTrace();

	            return false;
    }// end of catch

     return true; // end of deposit
}// end of method




    // method to start the transaction
    // returns true if there is no issue starting the transaction, false otherwise
    // boolean value is not really used, though it is there if needed
    public boolean startTransaction() {
        try {
            //System.out.println("Starting the transaction");
            conn.setAutoCommit(false);
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    // method to end the transaction
    // returns true if there is no issue ending the transaction, false otherwise
    // boolean value is not really used, though it is there if needed
    public boolean endTransaction() {
        try {
            conn.setAutoCommit(true);
            //System.out.println("Transaction ended");
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    // method to commit the changes in the transaction
    // returns true if there is no issue committing the transaction, false otherwise
    // boolean value is not really used, though it is there if needed
    public boolean commitTransaction() {
        try {
            conn.commit();
            //System.out.println("Committing changes to database.");
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    // method to rollback the transaction
    // returns true if there is no issue rolling back the transaction, false otherwise
    // boolean value is not really used, though it is there if needed
    public boolean rollbackTransaction() {
        try {
            conn.rollback();
            //System.out.println("Rolling back!  No changes made to database.");
            return true;
        }// end of try
        catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }// end of catch
    }// end of method rollbackTransaction

}// end of dataLayer