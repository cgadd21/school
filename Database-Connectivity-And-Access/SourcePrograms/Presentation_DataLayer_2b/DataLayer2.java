// Jim Habermas
// ISTE 330
// Fall 2022 Small DataLayer

// Java Class Named  DataLayer2

// This code is the Data Layer
import java.sql.*;

public class DataLayer2{
   private Connection conn;
   private ResultSet rs;
   private Statement stmt;
   private String sql;
   private int col;

   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

   public DataLayer2(){
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


   // Goal is to get the number of columns that are in table recipe  in Database Recipes
   public int getResultSet(){
      try{
         stmt = conn.createStatement();
         sql = "SELECT * FROM recipe;";
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
   
   
   
   
   
   
    // Goal is to get the number of rows that are in table recipe  in Database Recipes
    public int geNumberOfRows_recipe_table() {
           int rowCount = 0;
           try {
               // Create a statement
               stmt = conn.createStatement();
               // Create a resultset
               String sql = "SELECT COUNT(*) FROM recipe";
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
} // End of Class   DataLayer2.java