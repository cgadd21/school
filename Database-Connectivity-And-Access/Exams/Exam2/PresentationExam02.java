// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/23/2023
// Practical 02
// Professor Habermas

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PresentationExam02 extends JFrame
{
    MySQLDatabase dl = new MySQLDatabase();

    public Font myFontForOutput = new Font("Courier", Font.PLAIN, 32);
    public Font myButtonFont= new Font("Courier", Font.PLAIN, 38);

    String databaseName = new String();
    String userName = new String();
    String password = new String();

    public PresentationExam02()
    {
        super("Practical 02");
		setSize(630,600);
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

        JButton jbDelete = new JButton("Delete Passenger");
        jbDelete.setFont(myButtonFont);
        jbDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				deletePassenger();
			}
		});
        jpCenter.add(jbDelete);

        JButton jbUpdate = new JButton("Update Passenger");
        jbUpdate.setFont(myButtonFont);
        jbUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				updatePassenger();
			}
		});
        jpCenter.add(jbUpdate);

        JButton jbStaffRoutine = new JButton("Staff Routine");
        jbStaffRoutine.setFont(myButtonFont);
        jbStaffRoutine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				Staff_Routine();
			}
		});
        jpCenter.add(jbStaffRoutine);

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
        try
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

            if(dl.connect(databaseName, userName,password))
            {
                JOptionPane.showMessageDialog(null,"DB Connected - Gadd, Cooper", "Connection Success",JOptionPane.PLAIN_MESSAGE);

                getPassengerRowCount();
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR in connect");
        }
    }

    public void getPassengerRowCount()
    {
        try
        {
            int row = dl.getPassengerRowCount();
            JOptionPane.showMessageDialog(null, row, "Passenger Row Count",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("ERROR in getPassengerRowCount");
        }
    }

    public void getPassengers(String title)
    {
        String msg = dl.getPassengers();
        JOptionPane.showMessageDialog(null, msg, title,JOptionPane.PLAIN_MESSAGE);
    }

    public void addPassenger()
    {
        try
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

            JTextField tf_zipAdd = new JTextField("14623");
            InputboxForAdd.add(tf_zipAdd);
            tf_zipAdd.setFont(myFontForOutput);
            tf_zipAdd.setForeground(Color.BLUE);
                            
            JOptionPane.showMessageDialog(null, InputboxForAdd,"Add Passenger", JOptionPane.QUESTION_MESSAGE);
                
            int passengerAddID = Integer.parseInt(tf_passengerAddID.getText());
            String fNameAdd = tf_fNameAdd.getText();
            String lNameAdd = tf_lNameAdd.getText();
            String streetAdd = tf_streetAdd.getText();
            String zipCodeAdd = tf_zipAdd.getText();

            int AddOk = 0;
            AddOk = dl.addPassenger(passengerAddID,fNameAdd,lNameAdd,streetAdd,zipCodeAdd);
            System.out.println(AddOk + " <- Add Status");
            JOptionPane.showMessageDialog(null,AddOk + " <- Add Status", "Add Status",JOptionPane.PLAIN_MESSAGE);

            getPassengerRowCount();
        }
        catch (Exception e)
        {
            System.out.println("ERROR in addPassenger");
        }
    }

    public void deletePassenger()
    {
        try
        {
            getPassengers("RECORDS IN PASSENGER BEFORE DELETE"); 

            JPanel InputboxForDelete = new JPanel(new GridLayout(2,2));

            JLabel lbl_passengerDeleteFName = new JLabel("Passenger's First Name to Delete  -> ");
            lbl_passengerDeleteFName.setFont(myFontForOutput);
            InputboxForDelete.add(lbl_passengerDeleteFName); 

            JTextField tf_passengerDeleteFName = new JTextField("");
            tf_passengerDeleteFName.setFont(myFontForOutput);
            tf_passengerDeleteFName.setForeground(Color.BLUE);
            InputboxForDelete.add(tf_passengerDeleteFName);
            
            JLabel lbl_passengerDeleteLName = new JLabel("Passenger's Last Name to Delete  -> ");
            lbl_passengerDeleteLName.setFont(myFontForOutput);
            InputboxForDelete.add(lbl_passengerDeleteLName); 

            JTextField tf_passengerDeleteLName = new JTextField("");
            tf_passengerDeleteLName.setFont(myFontForOutput);
            tf_passengerDeleteLName.setForeground(Color.BLUE);
            InputboxForDelete.add(tf_passengerDeleteLName);

            JOptionPane.showMessageDialog(null, InputboxForDelete,"Delete passenger", JOptionPane.QUESTION_MESSAGE);

            String passengerFName = tf_passengerDeleteFName.getText();
            String passengerLName = tf_passengerDeleteLName.getText();

            int deleteOk = 0;
            deleteOk = dl.deletePassenger(passengerFName,passengerLName);
            System.out.println(deleteOk + " <- Delete Status");
            JOptionPane.showMessageDialog(null,deleteOk + " <- Delete Status", "Delete Status",JOptionPane.PLAIN_MESSAGE);

            getPassengers("RECORDS IN PASSENGER AFTER DELETE"); 

            getPassengerRowCount();
        }
        catch (Exception e)
        {
            System.out.println("ERROR in deletePassenger");
        }
    }

    public void updatePassenger()
    {
        try
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
                            
            JOptionPane.showMessageDialog(null, InputboxForUpdate,"Update Passenger", JOptionPane.QUESTION_MESSAGE);
                
            int passengerUpdateID = Integer.parseInt(tf_passengerUpdateID.getText());
            String streetUpdate = tf_streetUpdate.getText();

            int updateOk = 0;
            updateOk = dl.updatePassenger(passengerUpdateID,streetUpdate);
            System.out.println(updateOk + " <- Update Status");
            JOptionPane.showMessageDialog(null,updateOk + " <- Update Status", "Update Status",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("ERROR in updatePassenger");
        }
    }

    public void Staff_Routine()
    {
        try 
        {
            String msg = dl.Staff_Routine();
            JOptionPane.showMessageDialog(null, msg, "Staff Routine",JOptionPane.PLAIN_MESSAGE);
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR in Staff_Routine");
        }
    }
    
    public void close()
    {
        try
        {
            if(dl.close())
            {
                java.util.Date today = new java.util.Date();
                System.out.println("Program terminated @ " + today);
            }
            else
            {
                System.out.println("Program not terminated");
            }
            
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println("ERROR closing.");
        }
    }

    public static void main(String [] args)
    {
        System.out.println("Author: Gadd, Cooper");
        new PresentationExam02();
    }
}