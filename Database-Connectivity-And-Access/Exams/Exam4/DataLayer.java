//Gadd, Cooper
//Spring 2023
//ISTE 330

import java.sql.*;

public class DataLayer 
{
    Connection conn;

    public boolean connect(String username, String password)
    {
        conn = null;

        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bankDB", username, password);
            System.out.println("Connected\n");
        }
        catch (Exception e)
        {
            System.out.println("ERROR connecting");
            System.exit(0);
        }

        return (conn != null);
    }

    public void close()
    {
        try
        {
            conn.close();
            System.out.println("Closed\n");
        }
        catch (Exception e)
        {
            System.out.println("ERROR closing");
        }
    }

    public boolean startTransaction()
    {
        try
        {
            conn.setAutoCommit(false);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean endTransaction()
    {
        try
        {
            conn.setAutoCommit(true);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean commitTransaction()
    {
        try
        {
            conn.commit();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean rollbackTransaction()
    {
        try
        {
            conn.rollback();
            return true;
        }
        catch (Exception e) 
        {
            return false;
        }
    }

    public boolean deposit(String ownerName, String accountType, double depAmt)
    {
        int id = 0;
        double currentBalance = 0.0;

        try
        {
            System.out.println("Attempting to deposit to " + ownerName + "'s account");
            startTransaction();

            PreparedStatement accountId = conn.prepareStatement("SELECT ownerId FROM AccountHolder WHERE accountOwner  = ?;");
            accountId.setString(1, ownerName);
            ResultSet accountIdResultSet = accountId.executeQuery();

            if (accountIdResultSet.isBeforeFirst())
            {
                while(accountIdResultSet.next()) 
                {
                    id = accountIdResultSet.getInt(1);
                }
            }
            else
            {
                System.out.println("Could not find account for " + ownerName + ", rolling back " + ownerName + "'s account.");
                rollbackTransaction();
                endTransaction();
                return false;
            }

            PreparedStatement amount = conn.prepareStatement("SELECT amount from account where ownerId = ? and accountType = ?;");
            amount.setInt(1, id);
            amount.setString(2, accountType);
            ResultSet amountResultSet = amount.executeQuery();

            while(amountResultSet.next())
            {
                currentBalance = amountResultSet.getDouble(1);
                System.out.println("Starting Balance: " + currentBalance);
            }

            if (currentBalance == 0)
            {
                rollbackTransaction();
                endTransaction();
                return false;
            };

            PreparedStatement update = conn.prepareStatement("UPDATE Account set amount = amount + ? where ownerId = ? AND accountType = ?;");
            update.setDouble(1, depAmt);
            update.setInt(2, id);
            update.setString(3, accountType);
            update.executeUpdate();

            System.out.println("Ending Balance: " + (currentBalance + depAmt));
            commitTransaction();
            endTransaction();
            return true;
        }
        catch (Exception e) 
        {
            rollbackTransaction();
            endTransaction();
            return false;
        }
    }

    public boolean newAccount(int ownerId, String accountOwner, int accountId, int accountNumber, String accountType, boolean activate, double amount)
    {
        try
        {
            startTransaction();

            PreparedStatement accountHolder = conn.prepareStatement("INSERT INTO AccountHolder VALUES (?,?);");
            accountHolder.setInt(1, ownerId);
            accountHolder.setString(2, accountOwner);
            accountHolder.executeUpdate();

            PreparedStatement account = conn.prepareStatement("INSERT INTO Account VALUES (?,?,?,?,?,?);");
            account.setInt(1, accountId);
            account.setInt(2, accountNumber);
            account.setInt(3, ownerId);
            account.setString(4, accountType);
            account.setBoolean(5, activate);
            account.setDouble(6, amount);
            account.executeUpdate();

            commitTransaction();
            endTransaction();
            return true;
        }
        catch (Exception e)
        {
            rollbackTransaction();
            endTransaction();
            return false;
        }
    }
}
