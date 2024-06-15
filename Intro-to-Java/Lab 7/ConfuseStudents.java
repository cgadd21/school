class ConfuseStudents{
   public static void main(String args[]){
      int cherry = 5;
      int orange = 12;
      int grape = 1;
      int banana = 8;
   
      swapIt(grape,orange);
      System.out.println(swapIt(orange,cherry));
      System.out.println(swapIt(cherry,grape));
      System.out.println(banana);
      //System.out.println(Math.PI);
   }
   
   public static int swapIt(int apple, int cherry){
      int banana = apple + cherry;
      cherry = cherry + 2;
      System.out.println(cherry);
      return banana;
   }
}

/*

questions

A.
my guess is that the input will be:
14
7
3
8

B.
I understood that the variables got passed into swapIt and went from there.I do not understand where the 17 and 6 came from. 
This was moderate due to the fact that I was mostly correct. 
I am confused where the two numbers came from.
I will be able to answer a question after I get an explanation on my question.

*/

