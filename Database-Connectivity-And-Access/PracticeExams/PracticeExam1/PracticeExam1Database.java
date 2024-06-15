// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/4/2023
// HW#: 02
// Professor Habermas

import java.sql.*;

public class PracticeExam1Database
{
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private String sql;
    private int col;
    //private String msg = new String();

    final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    public int connect(String databaseName, String userName, String password)
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

        try
        {
            stmt = conn.createStatement();
            sql = "SELECT * FROM passenger;";
            rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            col = rsmd.getColumnCount();
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR MESSAGE -> "+ sqle);
            System.out.println("ERROR SQLException in connect()");
        }

        return col;
    }

    public String getPassengers()
    {
        StringBuilder msg = new StringBuilder();

        try
        {
            stmt = conn.createStatement();
            sql = "SELECT FName, LName FROM passenger;";
            rs = stmt.executeQuery(sql);
    
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            System.out.println("Number Of Columns: " + colCount);
            msg.append("FName    LName\n");

            while (rs.next())
            {
                String FName = rs.getString(1);
                String LName = rs.getString(2);

                String row = FName + "    " + LName + "\n";

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