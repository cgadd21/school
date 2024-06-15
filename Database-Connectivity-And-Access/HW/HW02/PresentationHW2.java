// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/4/2023
// HW#: 02
// Professor Habermas

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PresentationHW2 
{
    MySQLDatabase dl = new MySQLDatabase();

    public Font myFontForOutput = new Font("Courier", Font.PLAIN, 32);
    public Font myButtonFont= new Font("Courier", Font.PLAIN, 38);

    String databaseName = new String();
    String userName = new String();
    String password = new String();

    public PresentationHW2()
    {
        super("Gadd_Cooper_HW02");
		setSize(630,400);
		setLocation(200,380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(0,1));
        add(jpCenter);
        setVisible(true);

        JButton jbConnection = new JButton("Connect");
        jbConnection.setFont(myButtonFont);
        jbConnection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				connect();
			}
		});
        jpCenter.add(jbConnection);

        JButton jbAdd = new JButton("Add Passenger");
        jbAdd.setFont(myButtonFont);
        jbAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				addPassenger();
			}
		});
        jpCenter.add(jbAdd);

        JButton jbUpdate = new JButton("Update Passenger");
        jbUpdate.setFont(myButtonFont);
        jbUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				updatePassenger();
			}
		});
        jpCenter.add(jbUpdate);

        JButton jbDelete = new JButton("Delete Passenger");
        jbDelete.setFont(myButtonFont);
        jbDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				deletePassenger();
			}
		});
        jpCenter.add(jbDelete);

        JButton jbClose = new JButton("Close");
        jbClose.setFont(myButtonFont);
        jbClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				close();
			}
		});
        jpCenter.add(jbClose);
    }

    public void connect()
    {
        JPanel databaseBox = new JPanel(new GridLayout(2,1));

        JLabel lblDatabase = new JLabel("Database name?");
        lblDatabase.setFont(myFontForOutput);
        databaseBox.add(lblDatabase);

        JTextField textfieldDatabaseName = new JTextField("travel");
        textfieldDatabaseName.setFont(myFontForOutput);
        textfieldDatabaseName.setForeground(Color.BLUE);
        databaseBox.add(textfieldDatabaseName);

        JOptionPane.showMessageDialog(null,databaseBox,"Database name Input Prompt", JOptionPane.QUESTION_MESSAGE);
        databaseName = textfieldDatabaseName.getText();

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
        
        String temp_password = new String();

        JOptionPane.showMessageDialog(null, Inputbox,"Default Password is 'student'", JOptionPane.QUESTION_MESSAGE);

        userName = tfUser.getText();
        temp_password = tfPassword.getText();

        if (temp_password.equals(""))
        {
            password = "student";
        }
        else
        {
            password = temp_password;
        }

        System.out.println("Connecting to the data travel...");
        dl.connect(databaseName, userName,password);
        System.out.println("You have connected to the database!\n\t\tGadd, Cooper");
    }

    public void addPassenger()
    {
        JPanel InputboxForAdd = new JPanel(new GridLayout(5,2));
            
        JLabel lbl_passengerAddID = new JLabel("Passener ID  -> ");
        InputboxForAdd.add(lbl_passengerAddID);
        lbl_passengerAddID.setFont(myFontForOutput);

        JTextField tf_passengerAddID = new JTextField("");
        InputboxForAdd.add(tf_passengerAddID);
        tf_passengerAddID.setFont(myFontForOutput);
        tf_passengerAddID.setForeground(Color.BLUE);

        JLabel lbl_fNameAdd = new JLabel("First Name   -> ");
        InputboxForAdd.add(lbl_fNameAdd);
        lbl_fNameAdd.setFont(myFontForOutput);

        JTextField tf_fNameAdd = new JTextField("");
        InputboxForAdd.add(tf_fNameAdd);
        tf_fNameAdd.setFont(myFontForOutput);
        tf_fNameAdd.setForeground(Color.BLUE);

        JLabel lbl_lNameAdd = new JLabel("Last  Name   -> ");
        InputboxForAdd.add(lbl_lNameAdd);
        lbl_lNameAdd.setFont(myFontForOutput);

        JTextField tf_lNameAdd = new JTextField("");
        InputboxForAdd.add(tf_lNameAdd);
        tf_lNameAdd.setFont(myFontForOutput);
        tf_lNameAdd.setForeground(Color.BLUE);

        JLabel lbl_streetAdd = new JLabel("Street       -> ");
        InputboxForAdd.add(lbl_streetAdd);
        lbl_streetAdd.setFont(myFontForOutput);

        JTextField tf_streetAdd = new JTextField("");
        InputboxForAdd.add(tf_streetAdd);
        tf_streetAdd.setFont(myFontForOutput);
        tf_streetAdd.setForeground(Color.BLUE);

        JLabel lbl_zipAdd = new JLabel("Zip          -> ");
        InputboxForAdd.add(lbl_zipAdd);
        lbl_zipAdd.setFont(myFontForOutput);

        JTextField tf_zipAdd = new JTextField("");
        InputboxForAdd.add(tf_zipAdd);
        tf_zipAdd.setFont(myFontForOutput);
        tf_zipAdd.setForeground(Color.BLUE);
                        
        JOptionPane.showMessageDialog(null, InputboxForAdd,"SQL Add Prompt", JOptionPane.QUESTION_MESSAGE);
            
        int passengerAddID = Integer.parseInt(tf_passengerAddID.getText());
        String fNameAdd = tf_fNameAdd.getText();
        String lNameAdd = tf_lNameAdd.getText();
        String streetAdd = tf_streetAdd.getText();
        String zipCodeAdd = tf_zipAdd.getText();

        int AddOk = 0;
        AddOk = dl.addPassenger(passengerAddID,fNameAdd,lNameAdd,streetAdd,zipCodeAdd);
        System.out.println(AddOk + " <- Add Status");   
    }

    public void updatePassenger()
    {
        JPanel InputboxForUpdate = new JPanel(new GridLayout(3,2));
            
        JLabel lbl_passengerUpdateID = new JLabel("Passener ID  -> ");
        InputboxForUpdate.add(lbl_passengerUpdateID);
        lbl_passengerUpdateID.setFont(myFontForOutput);

        JTextField tf_passengerUpdateID = new JTextField("");
        InputboxForUpdate.add(tf_passengerUpdateID);
        tf_passengerUpdateID.setFont(myFontForOutput);
        tf_passengerUpdateID.setForeground(Color.BLUE);

        JLabel lbl_streetUpdate = new JLabel("Street       -> ");
        InputboxForUpdate.add(lbl_streetUpdate);
        lbl_streetUpdate.setFont(myFontForOutput);

        JTextField tf_streetUpdate = new JTextField("");
        InputboxForUpdate.add(tf_streetUpdate);
        tf_streetUpdate.setFont(myFontForOutput);
        tf_streetUpdate.setForeground(Color.BLUE);

        JLabel lbl_zipUpdate = new JLabel("Zip          -> ");
        InputboxForUpdate.add(lbl_zipUpdate);
        lbl_zipUpdate.setFont(myFontForOutput);

        JTextField tf_zipUpdate = new JTextField("");
        InputboxForUpdate.add(tf_zipUpdate);
        tf_zipUpdate.setFont(myFontForOutput);
        tf_zipUpdate.setForeground(Color.BLUE);     
                        
        JOptionPane.showMessageDialog(null, InputboxForUpdate,"SQL UPDATE Prompt", JOptionPane.QUESTION_MESSAGE);
            
        int passengerUpdateID = Integer.parseInt(tf_passengerUpdateID.getText());
        String streetUpdate = tf_streetUpdate.getText();
        String zipCodeUpdate = tf_zipUpdate.getText();

        int updateOk = 0;
        updateOk = dl.updatePassenger(passengerUpdateID,streetUpdate,zipCodeUpdate);
        System.out.println(updateOk + " <- Update Status");
    }

    public void deletePassenger()
    {
        JPanel InputboxForDelete = new JPanel(new GridLayout(1,2));

        JLabel lbl_passengerDeleteID = new JLabel("Passener ID to Delete  -> ");
        lbl_passengerDeleteID.setFont(myFontForOutput);
        InputboxForDelete.add(lbl_passengerDeleteID); 

        JTextField tf_passengerDeleteID = new JTextField("");
        tf_passengerDeleteID.setFont(myFontForOutput);
        tf_passengerDeleteID.setForeground(Color.BLUE);
        InputboxForDelete.add(tf_passengerDeleteID);   
        
        JOptionPane.showMessageDialog(null, InputboxForDelete,"DELETE passenger", JOptionPane.QUESTION_MESSAGE);

        int passengerDeleteID = Integer.parseInt(tf_passengerDeleteID.getText());

        int deleteOk = 0;
        deleteOk = dl.deletePassenger(passengerDeleteID);
        System.out.println(deleteOk + " <- Delete Status");
    }

    public void close()
    {
        System.out.println("\nClosing all connections to database...\n");

        if(dl.close())
        {
            java.util.Date today = new java.util.Date();
            System.out.println("\nProgram terminated @ " + today + "\n");
        }
        else
        {
            System.out.println("\nProgram not terminated\n");
        }
        
        System.exit(0);
    }

    public static void main(String [] args)
    {
        System.out.println("Author: Gadd, Cooper");
        new PresentationHW2();
    }
}