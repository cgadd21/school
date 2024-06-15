import java.sql.*;
import java.util.Scanner;

//Using PreparedStatements to add, update, and delete records
//PreparedStatements are used to structure SQL commands, which will then get
//sent to the database.

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            Connection connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
            System.out.println("Connected successfully to database.");
            Statement state = connect.createStatement();

            //check for table before attempting to create it
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CARROTS", null);
            if(result.next()){
                System.out.println("Carrot table already exists.");
            } else {
                state.execute("CREATE TABLE carrots (id int, variety varchar(50), color varchar(30), days_to_pick int)");
                System.out.println("Table created successfully.");
            }

            //PreparedStatement for inserting new records
            //columns are id, variety, color, and days_to_pick
            PreparedStatement insert = connect.prepareStatement("INSERT INTO carrots VALUES(?,?,?,?)");

            //Inserting a record
            insert.setInt(1, 11110);                    //sets 11110 to first question mark
            insert.setString(2, "Little Fingers");       //sets Little Fingers to second question mark
            insert.setString(3, "Orange");              //sets Orange to third question mark
            insert.setInt(4, 55);                       //sets 55 to 4th question mark
            insert.executeUpdate();
            //This will create a SQL statement that says:
            //INSERT INTO carrots VALUES(11110, "Little Fingers", "Orange", 55)
            System.out.println("Entry added successfully.");

            //Inserting a record
            insert.setInt(1, 11111);                    //sets 11111 to first question mark
            insert.setString(2, "Cosmic Purple");       //sets Cosmic Purple to second question mark
            insert.setString(3, "Purple");              //sets Purple to third question mark
            insert.setInt(4, 70);                       //sets 70 to 4th question mark
            insert.executeUpdate();
            //This will create a SQL statement that says:
            //INSERT INTO carrots VALUES(11111, "Cosmic Purple", "Purple", 70)
            System.out.println("Entry added successfully.");

            //Inserting another record with user data
            //I chose to generate the IDs myself rather than get it from the user
            System.out.println("What is the variety of carrot?");
            String var = scanner.nextLine();
            System.out.println("What color is it?");
            String col = scanner.nextLine();
            System.out.println("How many days until it can be picked?");
            int pick = scanner.nextInt();

            insert.setInt(1, 11112);
            insert.setString(2, var);
            insert.setString(3, col);
            insert.setInt(4, pick);
            insert.executeUpdate();
            System.out.println("Entry added successfully.");

            //PreparedStatement for updating records
            PreparedStatement update = connect.prepareStatement(
                    "UPDATE carrots SET variety=?, color=?, days_to_pick=? WHERE id=?");
            update.setString(1, "Pelleted Nantendo");           //sets Pelleted Nantendo to the first question mark
            update.setString(2, "Dark Orange");                 //sets Dark Orange to the second question mark
            update.setInt(3, 65);                               //sets 65 to the third question mark
            update.setInt(4, 11112);                            //sets 11112 to the fourth question mark
            update.executeUpdate();
            //This will create a SQL statement that says:
            //UPDATE carrots SET variety="Pelleted Nantendo", color="Dark Orange", days_to_pick=65 WHERE id=11112
            System.out.println("Record successfully updated.");

            //PreparedStatement for deleting records
            PreparedStatement delete = connect.prepareStatement("DELETE FROM carrots WHERE id=?");
            delete.setInt(1, 11111);                            //sets 11111 to the first question mark
            delete.executeUpdate();
            //This will create a SQL statement that says:
            //DELETE FROM carrots WHERE id=11111
            System.out.println("Successfully deleted.");

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
