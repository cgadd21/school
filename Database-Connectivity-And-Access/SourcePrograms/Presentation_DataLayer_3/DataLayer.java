// Jim Habermas
// Updated: Spring 2022
import java.sql.*;
public class DataLayer{

   private Connection conn;
   private ResultSet rs;
   private Statement stmt;
   private String sql;
   private int col;

   final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

   public DataLayer(){
   }//end of constructor

   public boolean connect(String user, String password, String database){
      conn = null;
   
      String url = "jdbc:mysql://localhost/" + database;

      url = url + "?serverTimezone=UTC"; //added 8/27

      try{
         Class.forName(DEFAULT_DRIVER);
         conn = DriverManager.getConnection(url, user, password);
         System.out.println("\nCreated Connection!\n");
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

      return (conn!=null);
   } // End of connect method

   public int getResultSet(){
      try{
         stmt = conn.createStatement();
         sql = "SELECT * FROM recipe;";
         rs = stmt.executeQuery(sql);

         ResultSetMetaData rsmd = rs.getMetaData();
         col = rsmd.getColumnCount();
      }
      catch(SQLException sqle){
       System.out.println("ERROR MESSAGE -> "+sqle);
       System.out.println("ERROR SQLException in getResultSet()");
      }
      return col;
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

   //   Inserting records 
   //   Insert using prepared statements.
   //   With recipe Database please watch the Foreign key connection to the
   //   nutrition table.
   //
   //   Recipe(RecipeID)  REFERENCES   Nutrition(RecipeID)
   //
   //   Insert into Nutrition before you run this program.

      /**
       * addRecipe
       * @param recipeID    - recipeID
       * @param source      - source
       * @param comments    - comments
       * @param name        - name
       * @param numServings - the number of servings for that recipe
       * @return the number of rows affected
      
      Before I add Prime Ribb
      
      INSERT INTO nutrition values("fat",3000,"grams",20);
      
      */
      public int addRecipe(int recipeID, String source, String comments, String name, int numServings) {
         int rows = 0;

         System.out.println("-----INSERT started-----");
         try{
            // prepared statement
            String sql = "INSERT INTO recipe VALUES (?,?,?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            // bind values into the parameters
            stmt.setInt(1, recipeID);
            stmt.setString(2, source);
            stmt.setString(3, comments);
            stmt.setString(4, name);
            stmt.setInt(5, numServings);

            System.out.println("Command to be executed: " + stmt);
            rows = stmt.executeUpdate();
            System.out.println("-----INSERT finished-----");
         }//try
         catch(SQLException sqle){
            System.out.println("SQL ERROR");
            System.out.println("INSERT IN RECIPE FAILED!!!!");
            System.out.println("ERROR MESSAGE IS -> "+sqle);
            sqle.printStackTrace();
            return(0);
         }
         catch(Exception e) {
            System.out.println("Error occured in addRecipe method");
            System.out.println("ERROR MESSAGE is -> "+e);
            e.printStackTrace();
            return(0);
         }
         return (rows);
   } // end of addRecipe   Method


public int deleteOneRecordFromSteps()  {
    int number_rows = 0;
    int step = 0;
    int id   = 0;
    String sql = new String();
    System.out.print("\nEnter step number to delete: ");
	step = GetInput.readLineInt();
	System.out.print("Enter recipeid: ");
    id = GetInput.readLineInt();

 try {
   // Create a statement
    stmt = conn.createStatement();

    sql =  "DELETE FROM steps ";
    sql += " WHERE stepnumber = "+step+" and recipeid = "+ id;
    System.out.println(sql);
    number_rows = stmt.executeUpdate(sql);
  }// end of try block
  catch(SQLException sqle){
             System.out.println("ERROR MESSAGE -> "+sqle);
             System.out.println("ERROR SQLException in deleteOneRecord()");
   }

   return (number_rows);
}// end of deleteOneRecord function


} // End of Class   DataLayer.java