import java.sql.*;
import java.util.Scanner;

//Closing objects using try-with-resources - preferred way
//Shutting down Derby

public class Example6 {
    public static void main(String[] args) {
        //Create all Connection and Statement objects in parentheses
        //They will close automatically when try block ends
        try (Connection connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
             Statement state = connect.createStatement();
             PreparedStatement insert = connect.prepareStatement("INSERT INTO carrots VALUES(?,?,?,?)");
             PreparedStatement dynQuery = connect.prepareStatement("SELECT * FROM carrots WHERE id =?");
        )
        {
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CARROTS", null);
            if(result.next()){
                System.out.println("Carrot table already exists.");
            } else {
                state.execute("CREATE TABLE carrots (id int, variety varchar(50), color varchar(30), days_to_pick int)");
                System.out.println("Table created successfully.");
            }

            DriverManager.getConnection("jdbc:derby:;shutdown=true"); //shuts down Derby - will always throw an exception even if successful

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
