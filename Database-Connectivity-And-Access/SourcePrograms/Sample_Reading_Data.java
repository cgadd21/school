public class Sample_Reading_Data{
   public static void main(String [] args) {
      char choice = ' ';
      boolean done = false;

      System.out.print("        Please enter your age -> ");
      int age = GetInput.readLineInt();
      System.out.print("Please enter your 2022 income -> ");
      double income = GetInput.readLineDouble();

      while (! done)
      {
		  System.out.println("\nDo you like programming in JAVA ?");
		  System.out.print("please answer Y or N   -> ");
		  choice = GetInput.readLineNonwhiteChar();

		  if ((choice == 'Y') || (choice == 'y')) {
			  System.out.println("Good Answer!!!!!!\n");
			  done = true;
		  }
		  else {
			    System.out.println("\nYou need to re-consider your answer!\n");
			    done = false;
		  }//end of else path
      }//end of while loop

      System.out.println("End of program - EOJ!");
  }//end of main method
}// end of class

