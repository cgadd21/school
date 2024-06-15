// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/4/2023
// HW#: 02
// Professor Habermas

import java.sql.*;

public class MySQLDatabase
{
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private String sql;

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

    public int updatePassenger(int passengerID, String newAddress, String newZip)
    {
        int result = 0;

        try
        {
            sql = "UPDATE passenger SET passenger.Street = ?, passenger.Zip = ? WHERE passengerID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newAddress);
            ps.setString(2, newZip);
            ps.setInt(3, passengerID);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public int deletePassenger(int passengerID)
    {
        int result = 0;

        try
        {
            sql = "DELETE FROM passenger WHERE passengerID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, passengerID);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception e)
        {
            return -1;
        }
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