// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/23/2023
// Practical 02
// Professor Habermas

import java.sql.*;

public class MySQLDatabase
{
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private String sql;
    private int col;
    private int row;

    final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    public boolean connect(String databaseName, String userName, String password)
    {
        conn = null;
  
        String url = "jdbc:mysql://localhost/" + databaseName;

        try
        {
            Class.forName(DEFAULT_DRIVER);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("\nCreated Connection!\n");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("ERROR, CAN NOT CONNECT!!");
            System.out.println("Class");
            System.out.println("ERROR MESSAGE-> " + cnfe);
            System.exit(0);
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR SQLExcepiton in connect()");
            System.out.println("ERROR MESSAGE -> " + sqle);
            sqle.printStackTrace();
            System.exit(0);
        }

        return (conn != null);
    }

    public int getPassengerRowCount()
    {
        try
        {
            stmt = conn.createStatement();
            sql = "SELECT COUNT(*) FROM passenger;";
            rs = stmt.executeQuery(sql);
            rs.next();
            row = rs.getInt(1);
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR MESSAGE -> "+sqle);
            System.out.println("ERROR SQLException in getPassengerRowCount()");
        }

        return row;
    }

    public String getPassengers()
    {
        StringBuilder msg = new StringBuilder();

        try
        {
            stmt = conn.createStatement();
            sql = "SELECT FName, LName, Street, Zip, PassengerID FROM passenger;";
            rs = stmt.executeQuery(sql);
            msg.append("FName    LName    Street    Zip    PassengerID\n");

            while (rs.next())
            {
                String FName = rs.getString(1);
                String LName = rs.getString(2);
                String Street = rs.getString(3);
                String Zip = rs.getString(4);
                String PassengerID = rs.getString(5);

                String row = FName + "    " + LName + "    " + Street + "    " + Zip + "    " + PassengerID + "\n";

                msg.append(row);
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR MESSAGE -> " + sqle);
            System.out.println("ERROR SQLException in getPassengers()");
        }

        return msg.toString();
    }

    public int addPassenger(int passengerID, String FName, String LName, String Street, String Zip)
    {
        int result = 0;

        try
        {
            sql = "INSERT INTO passenger VALUES (?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, passengerID);
            ps.setString(2, FName);
            ps.setString(3, LName);
            ps.setString(4, Street);
            ps.setString(5, Zip);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception sqle)
        {
            return -1;
        }
    }

    public int deletePassenger(String fname, String lname)
    {
        int result = 0;

        try
        {
            sql = "DELETE FROM passenger WHERE FName = ? AND LName = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setString(2, lname);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public int updatePassenger(int passengerID, String street)
    {
        int result = 0;

        try
        {
            sql = "UPDATE passenger SET passenger.Street = ? WHERE passengerID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, street);
            ps.setInt(2, passengerID);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public int getStaffRowCount()
    {
        try
        {
            stmt = conn.createStatement();
            sql = "SELECT COUNT(*) FROM staff;";
            rs = stmt.executeQuery(sql);
            rs.next();
            row = rs.getInt(1);
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR MESSAGE -> "+sqle);
            System.out.println("ERROR SQLException in getStaffRowCount()");
        }

        return row;
    }

    public int getStaffColumnCount()
    {
        try
        {
            stmt = conn.createStatement();
            sql = "SELECT * FROM staff;";
            rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            col = rsmd.getColumnCount();
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR MESSAGE -> "+sqle);
            System.out.println("ERROR SQLException in getStaffColumnCount()");
        }

        return col;
    }

    public String Staff_Routine()
    {
        return "Rows: " + getStaffRowCount() + " Columns: " + getStaffColumnCount();
    }

    public boolean close() 
    {
        try
        {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            return true;
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR IN METHOD close()");
            System.out.println("ERROR MESSAGE -> " + sqle);
            return false;
        }
    }
}