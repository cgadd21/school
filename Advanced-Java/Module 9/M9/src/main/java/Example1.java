import java.sql.*;

//A demo of creating a database and new table
//All sql code should go in a try/catch
public class Example1 {
    public static void main(String[] args) {
        try{
            Connection connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
            System.out.println("Connected successfully to database.");
            Statement state = connect.createStatement();
            System.out.println("Statement created successfully.");
            //Program will throw exception if you try to create the same table twice
            //The solution is to check to see if it's there first. If not, create it.
            //DatabaseMetaData can be used to search for the table by name as shown.
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
        }
    }
}
