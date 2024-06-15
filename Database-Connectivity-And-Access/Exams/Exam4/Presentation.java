//Gadd, Cooper
//Spring 2023
//ISTE 330

import java.util.*;

public class Presentation 
{
    public static void main(String[] args)
    {
        DataLayer dl = new DataLayer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password (Default student):");
        String password = scanner.nextLine();
        password = password.isEmpty() ? "student" : password;

        if(dl.connect(username,password));
        {
            int ownerId;
            String accountOwner;
            int accountId;
            int accountNumber;
            String accountType;
            String activateInput;
            boolean activate;
            double amount;

            System.out.println("Deposit 1");
            System.out.println("Account Owner:");
            accountOwner = scanner.nextLine();
            System.out.println("Account Type:");
            accountType = scanner.nextLine();
            System.out.println("Amount:");
            amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(dl.deposit(accountOwner, accountType, amount) ? "Sucess\n" : "Fail\n");

            System.out.println("Deposit 2");
            System.out.println("Account Owner:");
            accountOwner = scanner.nextLine();
            System.out.println("Account Type:");
            accountType = scanner.nextLine();
            System.out.println("Amount:");
            amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(dl.deposit(accountOwner, accountType, amount) ? "Sucess\n" : "Fail\n");

            System.out.println("New Account");
            
            System.out.println("Owner Id:");
            ownerId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Account Owner:");
            accountOwner = scanner.nextLine();

            System.out.println("Account Id:");
            accountId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Account Number:");
            accountNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Account Type:");
            accountType = scanner.nextLine();

            System.out.println("Active (1:Yes | 0:No)");
            activateInput = scanner.nextLine();
            activate = activateInput.equals("1");

            System.out.println("Amount:");
            amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.println(dl.newAccount(ownerId, accountOwner, accountId, accountNumber, accountType, activate, amount) ? "Sucess\n" : "Fail\n");

            System.out.println("Deposit 3");
            System.out.println("Account Owner:");
            accountOwner = scanner.nextLine();
            System.out.println("Account Type:");
            accountType = scanner.nextLine();
            System.out.println("Amount:");
            amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(dl.deposit(accountOwner, accountType, amount) ? "Sucess\n" : "Fail\n");

            dl.close();
            scanner.close();
            System.out.println("Exiting");
            System.exit(0);
        }
    }
}
