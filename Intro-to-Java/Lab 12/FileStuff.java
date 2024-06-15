import java.io.*;
import java.util.*;

class FileStuff{
   public static void main(String[] args)throws IOException{
      File outFile=new File("multnum.txt");
      PrintWriter writer=new PrintWriter(outFile);
      File inFile=new File("num.txt");
      Scanner read = new Scanner(inFile);
      for(int i=0; i<9; i++){
         int num=read.nextInt();
         writer.println(num*5);
         System.out.println(num);
      }
      writer.close();
   }
}