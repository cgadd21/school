// Third Example of Transaction
// PresentationLayer
// ISTE330

public class PresentationLayer {

    // creates a new instance of the datalayer and then attempts to deposit money into 2 different accounts and add a new account for Jim Habermas
    public static void main(String[] args) {
        DataLayer dl = new DataLayer();

        // attempts to connect to the database
        boolean connected = dl.connect();

        // once connected, run through the transactions
        if (connected) {

            // transaction 1
            boolean status = dl.deposit("Jim","Habermas", "IRA", 2000.00);
            if (status) {
                dl.commitTransaction();
                dl.endTransaction();
                System.out.println("First deposit was successful");
            } else {
                dl.rollbackTransaction();
                dl.endTransaction();
                System.out.println("First deposit failed");
            }

            // transaction 2
            System.out.println();
            status = dl.deposit("Karen","Salley", "C", 500); // substituted in
            if (status) {
                dl.commitTransaction();
                dl.endTransaction();
                System.out.println("Second deposit was successful");
            } else {
                dl.rollbackTransaction();
                dl.endTransaction();
                System.out.println("Second deposit failed!!!!!!!");
            }

            dl.close(); // closes anything that is open, ignores anything not used

            System.out.println("\nDisconnected from db");
        } else { // if not connected, just end the program
            System.out.println("No connection created");
        }// end of else
    }// end of main
}// end of class