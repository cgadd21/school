// Jim Habermas
// ISTE 330
// Small DataLayer

// Java Class Named  DataLayer4

// This code is the Data Layer
import java.sql.*;

public class DataLayer4{
   private Connection conn;
   private ResultSet rs;
   private Statement stmt;
   private String sql;
   private int col;

   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

   public DataLayer4(){
   }//end of constructor

   public boolean connect(String user, String password, String database){
      conn = null;
     
      String url = "jdbc:mysql://localhost/" + database;
      url = url + "?serverTimezone=UTC"; //added only required for Mac Users

      try{
         Class.forName(DEFAULT_DRIVER);
         System.out.println("CLASSPATH is set correctly!");
         
         conn = DriverManager.getConnection(url, user, password);
         System.out.println("\nCreated Connection!\n");
      }// end of try block
      catch(ClassNotFoundException cnfe){
		 System.out.println("ERROR, CAN NOT CONNECT!!");
         System.out.println("Class");
         System.out.println("ERROR MESSAGE-> "+cnfe);
         System.exit(0);
      }// end of the first catch block
      catch(SQLException sqle){
		 System.out.println("ERROR SQLExcepiton in connect()");
		 System.out.println("ERROR MESSAGE -> "+sqle);
         // sqle.printStackTrace();
         System.exit(0);
      }//end of  Second catch block

      return (conn!=null);
   } // End of connect method



 
 
      //   Inserting records 
      //   Insert ZipCodes using prepared statements.
      /**
       * addZipCode
       * @param zip         - Primary key
       * @param city        - city of zip code
       * @param state       - state of zip code

       * @return the number of rows affected 
      */
      public int addZipCode(String zip, String city, String state) {
         int rows = 0;

         System.out.println("-----INSERT started-----");
         try{
            // prepared statement
            String sql = "INSERT INTO zips VALUES (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            // bind values into the parameters
            stmt.setString(1, zip);
            stmt.setString(2, city);
            stmt.setString(3, state);


            System.out.println("Command to be executed: " + stmt);
            rows = stmt.executeUpdate();
            System.out.println("-----INSERT finished-----");
         }//try
         catch(SQLException sqle){
            System.out.println("SQL ERROR");
            System.out.println("INSERT IN addZipCode FAILED!!!!");
            System.out.println("ERROR MESSAGE IS -> "+sqle);
            sqle.printStackTrace();
            return(0);
         }
         catch(Exception e) {
            System.out.println("Error occured in addZipCode method");
            System.out.println("ERROR MESSAGE is -> "+e);
            e.printStackTrace();
            return(0);
         }
         return (rows);
   } // end of add a ZipCode



      //   Inserting records 
      //   Insert a new passenger
      /**
       * addPassenger
       * @param passengerID   - Primary key
       * @param fname         - first name
       * @param lname         - last name
       * @param street        - street
       * @param zip           - zip code

       * @return the number of rows affected 
      */
      public int addPassenger(int passengerID, String fname, String lname, String street, String zip) {
         int rows = 0;

         System.out.println("-----INSERT started-----");
         try{
            // prepared statement
            String sql = "INSERT INTO passenger VALUES (?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            // bind values into the parameters
            stmt.setInt(1, passengerID);
            stmt.setString(2, fname);
            stmt.setString(3, lname);
            stmt.setString(4, street);
            stmt.setString(5, zip);
            System.out.println("Command to be executed: " + stmt);
            rows = stmt.executeUpdate();
            System.out.println("-----INSERT finished-----");
         }//try
         catch(SQLException sqle){
            System.out.println("SQL ERROR");
            System.out.println("INSERT FAILED!!!!");
            System.out.println("ERROR MESSAGE IS -> "+sqle);
            sqle.printStackTrace();
            return(0);
         }
         catch(Exception e) {
            System.out.println("Error occured in addPassenger method");
            System.out.println("ERROR MESSAGE is -> "+e);
            e.printStackTrace();
            return(0);
         }
         return (rows);
   } // end of add a passenger





   // Goal is to get the number of columns that are in table passenger  in Database travel
   public int getResultSet(){
      try{
         stmt = conn.createStatement();
         sql = "SELECT * FROM passenger;";
         rs = stmt.executeQuery(sql);

         ResultSetMetaData rsmd = rs.getMetaData();  // collecting meta data
         col = rsmd.getColumnCount();
         
      }// end of try block
      catch(SQLException sqle){
       System.out.println("ERROR MESSAGE -> "+sqle);
       System.out.println("ERROR SQLException in getResultSet()");
      }// end of catch block
      return col;  // return the desired answer to the Presentation program
   } // End of getResultSet

   public void close(){
      try {
         rs.close();
         stmt.close();
         conn.close();
      }
      catch(SQLException sqle){
        System.out.println("ERROR IN METHOD close()");
        System.out.println("ERROR MESSAGE -> "+sqle);
      }// end of catch
   }//end of method close
   
   
   
   
   
   
    // Goal is to get the number of rows that are in table passenger
    public int getNumberOfRows_passenger_table() {
           int rowCount = 0;
           try {
               // Create a statement
               stmt = conn.createStatement();
               // Create a resultset
               String sql = "SELECT COUNT(*) FROM passenger;";
               rs = stmt.executeQuery(sql);
               rs.next(); // moving to the next row in rs
               rowCount = rs.getInt(1);
   
           }//end of try
           catch (SQLException sqle) {
   			   rowCount = 0;
               System.out.println("\nERROR CAN NOT getResultSet()");
               System.out.println("ERROR MESSAGE-> " + sqle + "\n");
               sqle.printStackTrace();
           }// end of catch
       return (rowCount);// return the desired answer to the Presentation program
   }// end of method to generate record count from the table recipe in Database Recipes


     /**
	 *	Retrieve records from passenger table
	 */
	public String retrievePassengers() {
        String msg = new String();
      
		try {
         // 3) Create a statement
			stmt = conn.createStatement();
         
         // 4) Create a resultset
	     sql = "SELECT concat(lname,', ',fname), street, zip FROM passenger;";
         rs = stmt.executeQuery(sql);
         while(rs.next()) {
				String name   = rs.getString(1);
				String street = rs.getString(2);
				String zip    = rs.getString(3);
				msg += name +" " +street+" "+ zip + "\n";
			} //end of while loop to get all the records
         return (msg);
          
		}// end of try
		catch(SQLException se) {
			se.printStackTrace();
			return "Error";
		}//end of catch
	}// end of retrievePassengers
} // End of Class   DataLayer4.java