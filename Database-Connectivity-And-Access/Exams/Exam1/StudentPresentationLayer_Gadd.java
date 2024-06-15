// Name: Gadd, Cooper
// Class: ISTE330
// Date: 10/13/2023
// Practical 01
// Professor Habermas

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentPresentationLayer_Gadd extends JFrame
{
    StudentDataLayer_Gadd dl = new StudentDataLayer_Gadd();

    public Font myFontForOutput = new Font("Courier", Font.PLAIN, 32);
    public Font myButtonFont= new Font("Courier", Font.PLAIN, 38);

    String databaseName = new String();
    String userName = new String();
    String password = new String();

    public StudentPresentationLayer_Gadd()
    {
        super("Gadd_Cooper_Practical01");
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

        JButton jbDelete = new JButton("Delete Student");
        jbDelete.setFont(myButtonFont);
        jbDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				deleteStudentRecord();
			}
		});
        jpCenter.add(jbDelete);

        JButton jbMetaData = new JButton("MetaData");
        jbMetaData.setFont(myButtonFont);
        jbMetaData.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				provideMetaData();
			}
		});
        jpCenter.add(jbMetaData);

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

        JTextField textfieldDatabaseName = new JTextField("studentdb");
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

        try
        {
            if(dl.connect(databaseName, userName,password))
            {
                JOptionPane.showMessageDialog(null,"DB Connected - Gadd, Cooper", "Connection Success",JOptionPane.PLAIN_MESSAGE);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR connecting");
        }
    }

    public void deleteStudentRecord()
    {
        JPanel InputboxForDelete = new JPanel(new GridLayout(1,2));

        JLabel lbl_studentDeleteID = new JLabel("Student ID to Delete  ->  ");
        lbl_studentDeleteID.setFont(myFontForOutput);
        InputboxForDelete.add(lbl_studentDeleteID); 

        JTextField tf_studentDeleteID = new JTextField("");
        tf_studentDeleteID.setFont(myFontForOutput);
        tf_studentDeleteID.setForeground(Color.BLUE);
        InputboxForDelete.add(tf_studentDeleteID);   
        
        JOptionPane.showMessageDialog(null, InputboxForDelete,"DELETE student", JOptionPane.QUESTION_MESSAGE);

        int studentDeleteID = Integer.parseInt(tf_studentDeleteID.getText());

        int deleteOk = 0;

        try
        {
            deleteOk = dl.deleteStudentRecord(studentDeleteID);
            System.out.println(deleteOk + " <- Delete Status");
            JOptionPane.showMessageDialog(null,deleteOk + " <- Delete Status", "Delete Status",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("ERROR deleting student");
        }
    }

    public void provideMetaData()
    {
        try
        {
            int msg = dl.provideMetaData();
            JOptionPane.showMessageDialog(null,"Column Count: " + msg, "MetaData",JOptionPane.PLAIN_MESSAGE);
        }
        catch (Exception e)
        {
            System.out.println("ERROR getting MetaData");
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
        new StudentPresentationLayer_Gadd();
    }

}