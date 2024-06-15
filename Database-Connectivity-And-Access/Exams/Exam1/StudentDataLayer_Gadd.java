// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/13/2023
// Practical 01
// Professor Habermas

import java.sql.*;

public class StudentDataLayer_Gadd
{
    private Connection conn;
    private ResultSet rs;
    private Statement stmt;
    private String sql;
    private int col;

    final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    public boolean connect(String databaseName, String userName, String password)
    {
        conn = null;
  
        String url = "jdbc:mysql://localhost/" + databaseName;

        try
        {
            Class.forName(DEFAULT_DRIVER);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("DB Connected - Gadd, Cooper");
        }
        catch (Exception e)
        {
            System.out.println("No DB connection");
            System.exit(0);
        }
    
        return (conn != null);
    }

    public int deleteStudentRecord(int studentID)
    {
        int result = 0;

        try
        {
            sql = "DELETE FROM student WHERE studentID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentID);

            result = ps.executeUpdate();
            return result;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    public int provideMetaData()
    {
        try
        {
            stmt = conn.createStatement();
            sql = "SELECT * FROM student;";
            rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            col = rsmd.getColumnCount();
            
            System.out.println(col + " <- Column Count");
        }
        catch (Exception e)
        {
            System.out.println("ERROR getting MetaData");
        }

        return col;
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
        catch(Exception e)
        {
            System.out.println("ERROR closing");
            return false;
        }
    }
}