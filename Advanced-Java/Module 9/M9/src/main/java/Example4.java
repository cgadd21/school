import java.sql.*;
import java.util.Scanner;

//Queries with parameters using PreparedStatements
public class Example4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Connection connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
            System.out.println("Connected successfully to database.");
            Statement state = connect.createStatement();
            System.out.println("Statement created successfully.");

            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CARROTS", null);
            if(result.next()){
                System.out.println("Carrot table already exists.");
            } else {
                state.execute("CREATE TABLE carrots (id int, variety varchar(50), color varchar(30), days_to_pick int)");
                System.out.println("Table created successfully.");
            }

            //Creating a query with parameters - use PreparedStatement for this so that you can use ?
            PreparedStatement dynQuery = connect.prepareStatement("SELECT * FROM carrots WHERE id = ?");
            System.out.println("What entry would you like to see? (Enter 5-digit id)");
            int usersId = scanner.nextInt();
            dynQuery.setInt(1, usersId);                        //sets user's entry to first question mark
            ResultSet usersPick = dynQuery.executeQuery();      //query gets executed now that query command is complete
            //This returns a ResultSet, which can be looped through
            while(usersPick.next()){
                String var = usersPick.getString("variety");
                String col = usersPick.getString("color");
                int pick = usersPick.getInt("days_to_pick");
                System.out.println(usersId + ": " + var);
                System.out.println("Color: " + col + ", Days: "+pick);
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
