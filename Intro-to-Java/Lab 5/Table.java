import java.text.DecimalFormat;
import java.util.*;
class Table{
   public static void main(String[]args){
      int number = 100;
      int num = 0;
      for(int width = 0; width < 9 ; width++){
         for(int length = 0; length <6; length++){
            System.out.print(number+num + " ");
            num+=2;
         }
         num-=12;
         number+=100;
         System.out.println();
   }
   }
}