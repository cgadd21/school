import java.sql.*;
import java.util.Scanner;

//Closing out objects using finally block

public class Example5 {
    public static void main(String[] args) {
        //declaring variables here so that they're accessible in finally block
        //Not the ideal way to close connections, but it works
        Connection connect = null;
        Statement state = null;
        PreparedStatement insert = null;
        Scanner scanner = new Scanner(System.in);
        try{
            connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
            System.out.println("Connected successfully to database.");
            state = connect.createStatement();

            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CARROTS", null);
            if(result.next()){
                System.out.println("Carrot table already exists.");
            } else {
                state.execute("CREATE TABLE carrots (id int, variety varchar(50), color varchar(30), days_to_pick int)");
                System.out.println("Table created successfully.");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        } finally {
            //These objects still need to be enclosed in a try block
            //if block allows only objects that aren't null to be closed - otherwise, Null exception
            try{
                if(state != null) {                 //close statements first, then the connection
                    state.close();
                }
                if(connect !=null) {
                    connect.close();
                }
            }
            catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
