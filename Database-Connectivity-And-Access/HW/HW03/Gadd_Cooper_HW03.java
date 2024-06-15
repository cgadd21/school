// Name: Gadd, Cooper
// Class: ISTE330
// Date: 11/3/2023
// HW#: 03
// Professor Habermas

import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class Gadd_Cooper_HW03
{
    private Connection conn = null;

    Scanner scanner = new Scanner(System.in);

    public Gadd_Cooper_HW03()
    {
        connect();
        menu();
    }

    public void connect()
    {
        Font myFontForOutput = new Font("Courier", Font.PLAIN, 32);

        JPanel databaseBox = new JPanel(new GridLayout(2,1));

        JLabel lblDatabase = new JLabel("Database name?");
        lblDatabase.setFont(myFontForOutput);
        databaseBox.add(lblDatabase);

        JTextField textfieldDatabaseName = new JTextField("candidateSkills");
        textfieldDatabaseName.setFont(myFontForOutput);
        textfieldDatabaseName.setForeground(Color.BLUE);
        databaseBox.add(textfieldDatabaseName);

        JOptionPane.showMessageDialog(null,databaseBox,"Database name Input Prompt", JOptionPane.QUESTION_MESSAGE);
        String databaseName = textfieldDatabaseName.getText();

        JPanel Inputbox = new JPanel(new GridLayout(2,2));

        JLabel lblUser= new JLabel("Username  -> ");
        Inputbox.add(lblUser);
        lblUser.setFont(myFontForOutput);

        JTextField tfUser = new JTextField("root");
        Inputbox.add(tfUser);
        tfUser.setFont(myFontForOutput);
        tfUser.setForeground(Color.BLUE);

        JLabel lblPassword = new JLabel("Password  -> ");
        Inputbox.add(lblPassword);
        lblPassword.setFont(myFontForOutput);

        JTextField tfPassword = new JPasswordField("");
        Inputbox.add(tfPassword);
        tfPassword.setFont(myFontForOutput);
        tfPassword.setForeground(Color.BLUE);

        JOptionPane.showMessageDialog(null, Inputbox,"Default Password is 'student'", JOptionPane.QUESTION_MESSAGE);

        String userName = tfUser.getText();
        String password = tfPassword.getText();

        if (password.equals(""))
        {
            password = "student";
        }

        System.out.println("\nConnecting to the data " + databaseName + "...");
  
        String url = "jdbc:mysql://localhost/" + databaseName;

        try
        {
            final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";
            Class.forName(DEFAULT_DRIVER);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Created Connection!");
            System.out.println("Driver: " + DEFAULT_DRIVER);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("ERROR loading driver.");
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR connecting to database.");
        }

        if(conn != null)
        {
            System.out.println("You have connected to the database!\nStudent: Gadd, Cooper");
        }
    }

    public void menu()
    {
        int choice = 0;

        while (choice != 4)
        {
            System.out.print("\nEnter an option:\n1. Add Candidate\n2. Add Skill\n3. Print Candidate_Skill Pairing\n4. Exit\nSelection: ");
            choice = scanner.nextInt();
            System.out.println("");

            switch (choice)
            {
                case 1:
                    addCandidate();
                    break;
                case 2:
                    addSkill();
                    break;
                case 3:
                    System.out.print("Enter in Candidate ID\nChoices include " + String.join(", ", getCandidateIDs()) + ".\nCandidate ID: ");
                    getCandidateSkill(scanner.nextInt());
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("Goodbye!\n");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid menu option");
                    break;
            }
        }
    }

    public void addCandidate()
    {
        try
        {
            System.out.print("Enter candidate first name: ");
            String firstName = scanner.next();

            System.out.print("Enter candidate last name: ");
            String lastName = scanner.next();

            System.out.print("Enter candidate job title: ");
            String jobTitle = scanner.next();

            String sql = "INSERT INTO candidate (lastName,firstName,jobTitle) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lastName);
            ps.setString(2, firstName);
            ps.setString(3, jobTitle);
            ps.executeUpdate();

            Statement stmt = conn.createStatement();
            sql = "SELECT candidate_ID FROM candidate ORDER BY candidate_ID DESC LIMIT 1;";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            System.out.print("ID of inserted record is: " + rs.getString(1) + "\n");
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR adding candidate.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR adding candidate.");
        }
    }

    public void addSkill()
    {
        try
        {
            System.out.print("Enter candidate Id: ");
            int candidateID = scanner.nextInt();

            System.out.println("Seperate multiple skills with a comma.\nChoices: ");

            Statement stmt = conn.createStatement();
            String sql = "SELECT skill_ID, skill FROM skills ORDER BY skill_ID;";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                System.out.print(rs.getString(1) + ": " + rs.getString(2) + " | ");
            }

            System.out.print("\nEnter Skill(s) ID: ");
            String skills = scanner.next();
            String[] skillIds = skills.split(",");

            int skillAdded = 0;

            for(String skill: skillIds)
            {
                sql = "INSERT INTO candidate_skill (candidate_ID,skill_ID) VALUES (?,?)";
                int skillId = Integer.parseInt(skill);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, candidateID);
                ps.setInt(2, skillId);
                ps.executeUpdate();
                skillAdded++;
            }

            System.out.println(skillAdded + " skills added.");
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR adding skill(s).");
        }
        catch(Exception e)
        {
            System.out.println("ERROR adding skill(s)");
        }
    }

    public ArrayList<String> getCandidateIDs()
    {
        ArrayList<String> ids = new ArrayList<String>();

        try
        {
            Statement stmt = conn.createStatement();
            String sql = "SELECT candidate_ID FROM candidate;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) 
            {
                ids.add(rs.getString(1));    
            }
        }
        catch(SQLException sqle)
        {
            System.out.println("ERROR getting candidate ids.");
        }

        return ids;
    }

    public void getCandidateSkill(int candidateID)
    {
        try
        {
            String query = "{CALL get_candidate_skill(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, candidateID);
    
            ResultSet rs = stmt.executeQuery();
            String heading  = "\nDatabase candidateSkills\nID \tCandidate Name \t       Skills";
            System.out.println(heading);
            while (rs.next()) 
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String skill = rs.getString(3);
                System.out.printf("%3d     %-22s %-60s",id, name, skill);
            }
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR getting candidate skill.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR getting candidate skill.");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Author: Gadd, Cooper");
        new Gadd_Cooper_HW03();
    }
}