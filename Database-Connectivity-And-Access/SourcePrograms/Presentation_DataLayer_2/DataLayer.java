// Author of this program:    Jim Habermas
// Spring 2023 Small DataLayer
// No Updates in the Spring 2023 Semester - February
// First example of using two programs
//                    Presentation Layer  &  Data Layer
// This code is the Data Layer
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

   public boolean connect(String databaseName, String userName, String password){
      conn = null;

      String url = "jdbc:mysql://localhost/";
      url = url + databaseName;
      url = url + "?serverTimezone=UTC"; //added 8/27


  try{
         Class.forName(DEFAULT_DRIVER);
         conn = DriverManager.getConnection(url, userName, password);
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
         sql = "SELECT * FROM passenger;";
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





public int updatePassengerAddress(int passengerID, String newAddress, String newZip) {
// UPDATE passenger SET street = ?, Zip = ? WHERE passengerID = ?;  
      int result = 0;
      try {
         sql = "UPDATE passenger SET passenger.street = ?, passenger.zip = ? WHERE passengerID = ?";
   
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, newAddress);
         ps.setString(2, newZip);
         ps.setInt(3, passengerID);
         
         result = ps.executeUpdate();
         return (result);
      
      } catch (SQLException se) {
         return -1;
      }//end of the catch
   }// end of update using prepared Statements





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
} // End of Class   DataLayer.java