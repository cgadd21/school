import java.util.Scanner;
import java.sql.*;                   // Step 1) Load JDBC core library
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeConnection_Hide_Password_STORED_PROCEDURE_GUI {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;       //result set, used after query
    public String sql;          //any sql SELECT statement
    /* JDBC Type 4 Driver */
    final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Font myFontForOutput = new Font("Courier", Font.PLAIN, 32);

    public static Font myFontSmaller = new Font("Courier", Font.PLAIN, 20);

    /* url line below at the end identifies the database name
	/* Define Data Source */
    public static String url = "jdbc:mysql://localhost/";

    public static String databaseName = new String();
    public static String userName = new String();
    public static String password = new String();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    //    System.out.println("ISTE330  DEMONSTRATION   Habermas, Jim  September 30\n");
    //    System.out.print("Enter database name: ");
    //    databaseName = scanner.nextLine();
          JPanel databaseBox = new JPanel(new GridLayout(2,1));
          JLabel lblDatabase = new JLabel("Database name?");
          lblDatabase.setFont(myFontForOutput);
          databaseBox.add(lblDatabase);
          JTextField textfieldDatabaseName     = new JTextField("candidateSkills");
          textfieldDatabaseName.setFont(myFontForOutput);
          textfieldDatabaseName.setForeground(Color.BLUE);
          databaseBox.add(textfieldDatabaseName);
          JOptionPane.showMessageDialog(null,databaseBox,
                                              "Database name Input Prompt",
                                                JOptionPane.QUESTION_MESSAGE);
          databaseName = textfieldDatabaseName.getText();

          url = url + databaseName;
          url = url + "?serverTimezone=UTC"; //added 8/27



		JPanel Inputbox = new JPanel(new GridLayout(2,2));
        JLabel lblUser     = new JLabel("Username  -> ");
		JLabel lblPassword = new JLabel("Password  -> ");
        JTextField tfUser     = new JTextField("root");
        //JTextField tfPassword = new JTextField("");
        JTextField tfPassword = new JPasswordField("");

         Inputbox.add(lblUser);
		 Inputbox.add(tfUser);
		 Inputbox.add(lblPassword);
         Inputbox.add(tfPassword);

         lblUser.setFont(myFontForOutput);
         tfUser.setFont(myFontForOutput);
         tfUser.setForeground(Color.BLUE);
         lblPassword.setFont(myFontForOutput);
         tfPassword.setFont(myFontForOutput);
         tfPassword.setForeground(Color.BLUE);
		 JOptionPane.showMessageDialog(null, Inputbox,
		      		   "SQL Input Prompt", JOptionPane.INFORMATION_MESSAGE);


         userName = tfUser.getText();
         password = tfPassword.getText();



        MakeConnection_Hide_Password_STORED_PROCEDURE_GUI someObject =
              new MakeConnection_Hide_Password_STORED_PROCEDURE_GUI();

        someObject.loadDriver();
        someObject.testConnection();


        System.out.println("\nEnter in Candidate ID");
        System.out.println("\tChoices include 100,101,102,103,104,105 or 106");
        System.out.print("\t\tCandidate ID ? ");
        String input_candidate_id = scanner.nextLine();
        int candidate_id = Integer.parseInt(input_candidate_id);

        someObject.getResultSet(candidate_id);

        java.util.Date today = new java.util.Date();
        System.out.println("\nProgram terminated @ " + today + "\n");
        System.exit(0);
    }//end of main method

    public void loadDriver() {
        // Step 2) Load a driver
        try {
            //Class.forName method returns the Class object
            //associated with the class or interface
            //with the given string name,
            //using the given class loader.
            Class.forName(DEFAULT_DRIVER);
            System.out.println("\nDriver Loaded " + DEFAULT_DRIVER + "\n");
        }//end of try block
        catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to load driver class: " + DEFAULT_DRIVER);
        }//end of catch
    }// end of method loadDriver()

    /**
     * Step 3) Create a connection Use the driver to create a connection
     */
    public void testConnection() {
        boolean connected = false;

        try {
            //conn = DriverManager.getConnection(url,"root",password);
            conn = DriverManager.getConnection(url, userName, password);
            connected = true;
        }// end of try block
        catch (SQLException sqle) {
            System.out.println("\nERROR CAN NOT MAKE CONNECITON");
            System.out.println("ERROR WAS " + sqle + "\n");
            sqle.printStackTrace();
        }// end of catch

        if (connected) {
            String temporary = "Your DB Connection works.  Student name: Nathan Radin (TA)";
            System.out.println(temporary);
        } else {
            System.out.println("Unable to connect to data source");
        }// end of if
    }//end of testConnection method()

    /**
     * Step 4) Get one Record, first passenger in Travel Database
     */
    public void getResultSet(int candidateID) {
        try {

            String query = "{CALL get_candidate_skill(?)}";
            CallableStatement stmt = conn.prepareCall(query);
            stmt.setInt(1, candidateID);

            ResultSet rs = stmt.executeQuery();

            String output = new String();
            String heading = new String();
            heading  = "\nDatabase candidateSkills\n";
            heading +=  "ID \tCandidate Name \t       Skills";
        //    System.out.println(heading);
        // Test (condition of while loop) if there are query results
            while (rs.next()) {
                // Retrieve resultset data to print on the screen

                int    id    = rs.getInt(1);
                String outputID = "" + id;
                String name  = rs.getString(2);
                String skill = rs.getString(3);
            //  System.out.printf("%3d     %-22s %-60s",id, name, skill);


         JPanel outputbox       = new JPanel(new GridLayout(3,0,0,0));

         JLabel label_ID        = new JLabel(outputID,JLabel.LEFT);
         JLabel label_name      = new JLabel(name,JLabel.LEFT);
         JLabel label_skill     = new JLabel(skill,JLabel.LEFT);
		 outputbox.add(label_ID);
         outputbox.add(label_name);
         outputbox.add(label_skill);

         label_ID.setFont(myFontSmaller);
         label_name.setFont(myFontSmaller);
         label_skill.setFont(myFontSmaller);


         label_ID.setForeground(Color.BLUE);
         label_name.setForeground(Color.BLUE);
         label_skill.setForeground(Color.BLUE);



		JScrollPane jsp = new JScrollPane(outputbox);
		jsp.setPreferredSize(new java.awt.Dimension(900, 175));



		 JOptionPane.showMessageDialog(null, jsp,
		      		   "OUTPUT / RESULTS", JOptionPane.PLAIN_MESSAGE);




    }// end of while loop, end of processing the result set

}//end of try
        catch (SQLException sqle) {
            System.out.println("\nERROR CAN NOT getResultSet()");
            System.out.println("ERROR MESSAGE-> " + sqle + "\n");
            sqle.printStackTrace();
        }// end of catch
    }// end of method getResultSet()
}//end of class