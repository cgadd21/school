//Box Tester Class - DO NOT CHANGE THIS CLASS!
//ALSO, DO NOT CHANGE THIS CLASS.
//You may comment out parts of this class as you add new features to your Box class.

class BoxTester {
   public static void main(String args[] ) {
   
      //This will test your three constructor
      Box boxOne = new Box();
      Box boxTwo = new Box(5.5, 3.3);
      Box boxThree = new Box(10, 15.2, 3);
      
      //This will test your toString() method
      System.out.println("BoxOne Dimensions: " + boxOne.toString());
      System.out.println("BoxTwo Dimensions: " + boxTwo.toString());
      System.out.println("BoxThree Dimensions: " + boxThree.toString());
      
      //This will test your getters
      System.out.println();
      System.out.println("Using Getters:");
      System.out.println("Width of BoxThree: "+ boxThree.getWidth());
      System.out.println("Length of BoxThree: " + boxThree.getLength());
      System.out.println("Height of BoxThree: " + boxThree.getHeight());
      
      //This will test your setters
      System.out.println();
      System.out.println("Using setters:");
      System.out.println("Change BoxOne width to 12");
      boxOne.setWidth(12);
      System.out.println("Change BoxOne length to 13");
      boxOne.setLength(13);
      System.out.println("Change BoxOne height to 14");
      boxOne.setHeight(14);

      System.out.println("BoxOne New Dimensions: " + boxOne.toString());
      System.out.println();
      
      //This will test the method that adds two boxes together
      System.out.println("Creating BoxFour by adding BoxOne to BoxTwo");
      Box boxFour= boxOne.add(boxTwo);
      System.out.println("BoxFour Dimensions: " + boxFour.toString());
      
      //This will test the method that adds a double to each dimension of the box
      Box boxFive = boxTwo.add(10);
      System.out.println("Adding to BoxTwo Height to create BoxFive...");
      System.out.println("BoxFive Dimensions: " + boxFive);
      System.out.println();
      
      //This will test the equals method
      Box boxSix = new Box(12, 13, 14);
      System.out.println("BoxOne equal to BoxSix: " + boxOne.equals(boxSix));
      System.out.println("BoxThree equal to BoxFour: " + boxThree.equals(boxFour));   
      
      //This will test the isBig method and indirectly, the BIG constant
      System.out.println();
      System.out.println("boxFive Big: " + boxFive.isBig());
      System.out.println("boxTwo Big: " + boxTwo.isBig());
   }
}
   
   