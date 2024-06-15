import java.sql.*;
import java.util.Scanner;

//Using Statements to query a table

public class Example3 {
    public static void main(String[] args) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:derby:GardenDatabase; create = true");
            Statement state = connect.createStatement();
            DatabaseMetaData dbm = connect.getMetaData();
            ResultSet result = dbm.getTables(null, null, "CARROTS", null);
            if(result.next()){
                System.out.println("Carrot table already exists.");
            } else {
                state.execute("CREATE TABLE carrots (id int, variety varchar(50), color varchar(30), days_to_pick int)");
                System.out.println("Table created successfully.");
            }

            //PreparedStatement for inserting new records
            PreparedStatement insert = connect.prepareStatement("INSERT INTO carrots VALUES(?,?,?,?)");
            //Quick, generic code to put 10 entries into the table.
            int id = 11111, days = 70;
            String variety = "Carrot", color = "Orange";
            for(int i = 0; i < 10; i++){
                insert.setInt(1, id);
                insert.setString(2, variety+(i+1));
                insert.setString(3, color);
                insert.setInt(4, days);
                insert.executeUpdate();
                id++;
            }

            //Creating a query to get all data back from the table and printing them
            ResultSet allValues = state.executeQuery("SELECT * FROM carrots");
            //Loop through ResultSet to get data for each record using get() methods
            while(allValues.next()){
                int num = allValues.getInt("id");
                String var = allValues.getString("variety");
                String col = allValues.getString("color");
                int day = allValues.getInt("days_to_pick");
                System.out.println(num+": "+var);
                System.out.println("Color: "+col+", Days: "+day);
            }

            //Creating another more specific query to just get variety of carrots where id is < 11115
            ResultSet names = state.executeQuery("SELECT variety FROM carrots WHERE id < 11115");
            System.out.println("Varieties with id less than 11115");
            while(names.next()){
                String name = names.getString("variety");
                System.out.println(name);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
