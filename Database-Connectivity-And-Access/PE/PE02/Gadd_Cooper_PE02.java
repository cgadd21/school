// Name: Gadd, Cooper
// Class: ISTE330
// Date: 9/20/2023
// PE#: 02
// Professor Habermas

// 0) Load JDBC core library
import java.sql.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gadd_Cooper_PE02 extends JFrame{

	// Attributes
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String sql;

    public Font myButtonFont= new Font("Courier", Font.PLAIN, 38);
    public static Font myFontForOutput = new Font("Courier", Font.BOLD, 22);

	//1a)   Set up device driver
	final String DEFAULT_DRIVER = "com.mysql.cj.jdbc.Driver";    

	// Define Data Source
	static String url = "jdbc:mysql://localhost/"  + "recipes";

	public Gadd_Cooper_PE02() {
		
		// build the GUI here
		super("Gadd_Cooper_PE02");
		setSize(630,400);
		setLocation(200,380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(0,1));

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
		jpCenter.add(jbExit);
        jbExit.setFont(myButtonFont);

		jbExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
            	java.util.Date now = new java.util.Date();    
				JOptionPane.showMessageDialog(null,"Good-Bye!"+"\nEnd of program\nTerminated at ->"+now,"EOJ",JOptionPane.PLAIN_MESSAGE);
				System.out.println("\nEnd of program\nTerminated at -> "+now);
				System.exit(0);
			}
		});

		jpCenter.add(jbConnect);
		jpCenter.add(jbRS);
		jpCenter.add(jbExit);
		add(jpCenter);

		setVisible(true);
	}

	public void testConnection(){
		// 2) Load a driver
		try {
	 	   Class.forName(DEFAULT_DRIVER);
	 	   JOptionPane.showMessageDialog(null,"Succefully loaded driver class: \n" + DEFAULT_DRIVER);
		}
		catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Unable to load driver class: \n" + DEFAULT_DRIVER);
			return;
		}

		// get a connection
		boolean connected = true;

		JPanel Inputbox = new JPanel(new GridLayout(2,2));
		JLabel lblUser     = new JLabel("Username  -> ");
		JLabel lblPassword = new JLabel("Password (default is \"student\") -> ");
		JTextField tfUser     = new JTextField("root");
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
		JOptionPane.showMessageDialog(null, Inputbox,"SQL Input Prompt", JOptionPane.INFORMATION_MESSAGE);

		String userName = tfUser.getText();
		String password = new String();
		String passwordInput = new String();
		passwordInput = tfPassword.getText();

		if (passwordInput.equalsIgnoreCase("")){
			password = "student";                  
		} 
		else {
			password = passwordInput;
		}
      
		// 2) Create a connection
		try {
			conn = DriverManager.getConnection(url, userName,password);   
			DatabaseMetaData md = conn.getMetaData();
            System.out.println("Driver Name ----> " + md.getDriverName());
            System.out.println("Version Number -> " + md.getDriverVersion()+"\n");
		}
		catch (SQLException se) {
			connected = false;
		}

		if(connected){  
			JOptionPane.showMessageDialog(null,"Your DB Connection works.  \nAuthor's name ->  Gadd, Cooper");              //CHANGED
		}
		else {
			JOptionPane.showMessageDialog(null,"Unable to connect to data source:\n" + url);
		}
	}

	// Retrieve records from a table
	public void getResultSet() {
		
		String msg = new String();
      
		try {
			// 3) Create a statement
			stmt = conn.createStatement();
         
         	// 4) Create a resultset
			sql = "SELECT name FROM recipes.recipe WHERE Source = 'Mom';";

            rs = stmt.executeQuery(sql);

         	while(rs.next()) {
				String recipe = rs.getString(1);
				msg += recipe + "\n";
			}

			JOptionPane.showMessageDialog(null, msg, "Q.1 Mom's Recipes",JOptionPane.PLAIN_MESSAGE); 
 
			sql =  "SELECT DISTINCT R.name ";
			sql += "FROM recipes.recipe R ";
			sql += "WHERE R.RecipeId NOT IN ( ";
			sql += "SELECT DISTINCT r.RecipeId ";
			sql += "FROM recipes.recipe r ";
			sql += "JOIN recipes.ingredientlist il USING(RecipeId) ";
			sql += "JOIN recipes.ingredients i USING(IngredientId) ";
			sql += "WHERE i.type IN ('beef', 'pork', 'chicken', 'lamb')); ";

			rs = stmt.executeQuery(sql);
         
        	msg = ""; //clearing
         
         	// 5) Test if there are query results
			while(rs.next()) {
            // 6) Retrieve resultset data
				String recipe = rs.getString(1);
				msg += recipe + "\n";
			}
         	
			JOptionPane.showMessageDialog(null, msg, "Q.4 List of Vegetarian Recipes",JOptionPane.PLAIN_MESSAGE);

			//release resources
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

	public static void main(String [] args){
		System.out.println("ISTE330-02  PE02   Gadd, Cooper  -  Fall 2023\n");
		new Gadd_Cooper_PE02();
	}
}