import java.util.*;
class Triangle{
   public static void main(String[]args){
      Scanner scan = new Scanner(System.in);
      System.out.println("How big would you like the triagnle?");
      int size = scan.nextInt();
      int count=1;
      int[][]tri=new int[size][];
      for(int i=0; i<tri.length; i++){
         tri[i]=new int[i+1];
         for(int j=0; j<tri[i].length; j++){
            tri[i][j]=count;
            System.out.print(tri[i][j]+" ");
         }
         count+=1;
         System.out.println();
      }
   }
}