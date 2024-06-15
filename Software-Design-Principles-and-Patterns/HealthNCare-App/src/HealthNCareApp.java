import java.util.Scanner;

import views.ConsoleView;
import views.GraphicalView;

public class HealthNCareApp {
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Pick \n1. Console View\n2. Graphical View");
      int choice = input.nextInt();
      if (choice == 1)
        new ConsoleView();
      else if (choice == 2)
        new GraphicalView();
      else
        System.out.print("Input 1 or 2");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
