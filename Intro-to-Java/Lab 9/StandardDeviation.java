import java.util.*;
import java.text.DecimalFormat;
class StandardDeviation{
   public static void main(String[]args){
      DecimalFormat three = new DecimalFormat("0.000");
      Scanner scan = new Scanner(System.in);
      double[] values;
      System.out.println("How many values would you like to enter?");
      int size = scan.nextInt();
      System.out.println();
      values = new double[size];
      for(int i=0; i<size; i++){
         System.out.println("Enter value "+(i+1)+".");
         values[i] = scan.nextDouble();
      }
      System.out.print("You have entered the values: ");
      for(double x:values){
         System.out.print(x+" ");
      }
      System.out.println();
      double stanDev=getStandardDeviation(values);
      System.out.println("The standard deviation is "+three.format(stanDev));
   }
   public static double getStandardDeviation(double[] array){
      double total=0;
      double sum=0;
      double avg=0;
      double top=0;
      double t=0;
      double sr=0;
      for(double num:array){
         sum=sum+num;
      }
      avg=sum/array.length;
      for(int i=0; i<array.length; i++){
         top=Math.pow(array[i]-avg,2);
         t+=top;
      }
      total=t/array.length;
      sr=Math.sqrt(total);
      return sr;
   }
}