// Author Habermas, James
// 0) Load JDBC core library
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *	ISTE 330 JDBC Examples    -    script studentdb.sql
 *  LBE_JDBC_version2.java
 *	This class will retrieve data from MySQL database
 *	Jim Habermas

 *  NOTES
 *     1) Make sure you change the username and password when you want to run this code.
 *     2) Make sure you first run the script to create the studentdb  Database
 *     3) Check your classpath
 */

public class LBE_JDBC_version2 extends JFrame{
    public Font myFontForOutput = new Font("Courier", Font.PLAIN, 28);
	public Font myButtonFont= new Font("Courier", Font.PLAIN, 36);
    public String temporary = new String();

	// Attributes

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql;


	/* JDBC Type 4 Driver */
	final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";

    /* url line below at the end identifies the database name
	/* Define Data Source */
	final String url = "jdbc:mysql://localhost/studentdb";

	/**
	 *	Constructor
	 */
	public LBE_JDBC_version2() {
		// build the GUI here
		super("JDBC Demo");
		setSize(630,400);
		setLocation(650,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(4,1));

		JButton jbDriver = new JButton("Load a Driver");
		jbDriver.setFont(myButtonFont);
		// button event handling

		jbDriver.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae) {
					loadDriver();
				}
		});

		JButton jbConnect = new JButton("Connect to Data Source");
		jbConnect.setFont(myButtonFont);
		// button event handling
		jbConnect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				testConnection();
			}
		});

		JButton jbRS = new JButton("Get Resultset");
		jbRS.setFont(myButtonFont);
		jpCenter.add(jbRS);
		jbRS.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				getResultSet();
			}
		});

		JButton jbExit = new JButton("Exit");
		jbExit.setFont(myButtonFont);
		jpCenter.add(jbExit);

		jbExit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
				//Release rs, stmt & conn
				java.util.Date today = new java.util.Date();
				//release resources
				try {
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
			    		if(conn != null) conn.close();
					}//end of try block
				catch(SQLException se)
				    {
						String msg = "Error occured at closing";
						String title = "Close ERROR";
						JOptionPane.showMessageDialog(null, msg, title,
							   JOptionPane.ERROR_MESSAGE);
						se.printStackTrace();
		            }//end of catch
                System.out.println("\nProgram terminated @ "+today+"\n");
				java.util.Date now = new java.util.Date();
				temporary = "Good-Bye!"+
				        "\nEnd of program\nTerminated at ->"+now;
				JTextArea outputArea = new JTextArea(temporary);
			    outputArea.setFont(myFontForOutput);
				JOptionPane.showMessageDialog(null,outputArea,
				        "EOJ",
                         JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});

		jpCenter.add(jbDriver);
		jpCenter.add(jbConnect);
		jpCenter.add(jbRS);
		jpCenter.add(jbExit);
		add(jpCenter);

		setVisible(true);
	}

/**
*	Load a driver
*/
public void loadDriver(){
// 1) Load a driver
		try {
			//Class.forName method returns the Class object
			//associated with the class or interface
			//with the given string name,
			//using the given class loader.

			Class.forName(DEFAULT_DRIVER);
			temporary = "Successfully loaded driver class: \n" +DEFAULT_DRIVER;
			JTextArea outputArea = new JTextArea(temporary);
			outputArea.setFont(myFontForOutput);
			JOptionPane.showMessageDialog(null,outputArea,
			     "Driver Loaded",JOptionPane.PLAIN_MESSAGE);

		}
		catch(ClassNotFoundException cnfe) {
	    	JOptionPane.showMessageDialog(null,"Unable to load driver class: \n" +
	    		DEFAULT_DRIVER);
		}
	}

	/**
	 *	use the driver to create a connection
	 */
	public void testConnection(){
		// get a connection


				JPanel Inputbox = new JPanel(new GridLayout(2,2));

				JLabel lblUser     = new JLabel("Username  -> ");
				JLabel lblPassword = new JLabel("Password  -> ");

				JTextField tfUser     = new JTextField("");
		        //JTextField tfPassword = new JTextField("");

//				JPasswordField tfPassword = new JPasswordField("");
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
		      		   "SQL Input Prompt", JOptionPane.INFORMATION_MESSAGE); //display output


		boolean connected = false;
        //String password = new String();
        //password = JOptionPane.showInputDialog(null, "Password?",
        // "Enter Password", JOptionPane.QUESTION_MESSAGE    );
        String user     = tfUser.getText();
//      String password = new String(tfPassword.getPassword());
        String password = tfPassword.getText();

		// 2) Create a connection
		try {
			//This statement below returns connections to the URL.
			//SQLException will be thrown, if database access occurs or url is null.

			//conn = DriverManager.getConnection(url,"root",password);

			conn = DriverManager.getConnection(url,user,password);
			connected = true;
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		if(connected){
			temporary = "Your DB Connection works.\nAuthor's name (insert your lastname) Habermas, James";
		    JTextArea outputArea = new JTextArea(temporary);
		    outputArea.setFont(myFontForOutput);
		    JOptionPane.showMessageDialog(null,outputArea,
			"Connected",JOptionPane.PLAIN_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,"Unable to connect to data source:\n" +
				url);
		}
	}

	/**
	 *	Retrieve records from the database
	 */
	public void getResultSet() {
		//String title = "OUTPUT"; //never used
		try {
	// 3) Create a statement
			stmt = conn.createStatement();
	// 4) Create a resultset
			sql = "select studentID,lastname,firstname, gpa from student";
			rs = stmt.executeQuery(sql);

            //Want to demonstrate some metadata
			ResultSetMetaData rsmd = rs.getMetaData();
	  // getting number of columns in 'rs'
			int colCount = rsmd.getColumnCount();
			System.out.println("   Number Of Columns : "+colCount);
      // Get how many rows in this resultset
      //      rs.last();		// go to the last row in RS
      //      int numRows = rs.getRow();	// # rows in RS
      //      rs.beforeFirst();	// setup ready for while(next...)
      //      System.out.println("      Number Of Rows : "+numRows);

    // 5) Test if there are query results
			while(rs.next()) {
	          int rowCount = rs.getRow();
              System.out.println("   Row you are working on : "+rowCount);

	// 6) Retrieve resultset data
	            String heading = new String();
	            heading= "StudentID       Student Name           GPA\n";
	            String id = rs.getString(1);
				String ln = rs.getString(2);
				String fn = rs.getString(3);
				double gpa = rs.getDouble(4);
				//String msg = heading + ln + "    " + gpa;
				String msg = String.format("%-25s",heading);
				//msg = ln + "     " +gpa;
				msg += String.format("%-5s      %11s, %-11s    %4.2f",id,ln,fn,gpa);
				//JOptionPane.showMessageDialog(null, msg,title,
				//                JOptionPane.INFORMATION_MESSAGE);
			   Font myFontForOutput = new Font("Courier", Font.PLAIN, 38);
			   JTextArea outputArea = new JTextArea(msg);
			   outputArea.setFont(myFontForOutput);
               outputArea.setForeground(Color.BLUE);
			   JOptionPane.showMessageDialog(null, outputArea,
      		   "SQL output", JOptionPane.INFORMATION_MESSAGE, null);
			}//end of while loop
		}//end of try block
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}//end of catch

		deleteRecord();

	}//end of method getResultSet()



public void deleteRecord() {
		String studentID = new String();
		studentID = JOptionPane.showInputDialog(null, "Student ID to delete?",
          "StudentID", JOptionPane.QUESTION_MESSAGE );
		try {
			sql = "DELETE FROM student where studentID = '"+studentID+"';";
			System.out.println(sql);   // not required, but good to have
		    stmt = conn.createStatement();

		    int rows = stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Number of rows Deleted ->" + rows);
            // Use JOptionPane or System.out.println to display number of records deleted
			// System.out.println("Records Deleted -> "+rows+"<-");
   }// end of try block;
	catch(SQLException sqle) {
		  System.out.println("\n**  RUN-TIME ERROR HAS OCCURED");
		  System.out.println("** ERROR MESSAGE IS "+sqle);
		//	sqle.printStackTrace();   // if you want you can use this line
		}//end of catch
	}//end of method to delete one record()






	public static void main(String [] args)
	{
		System.out.println("Demo of how to use Java with MySQL");
		System.out.println("ISTE330-02  PE02   Gadd, Cooper  Fall 2023\n");
	    // Replace Habermas and Jim with your Lastname and firstname
		new LBE_JDBC_version2();

	}//end of main
}//end of class