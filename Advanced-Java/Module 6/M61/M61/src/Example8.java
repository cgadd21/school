import java.util.Collections;
import java.util.LinkedList;

public class Example8 {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);  //autoboxing converts primitive types into object - doesn't just apply to linkedlist
        intList.add(Integer.valueOf(50));
        intList.add(new Integer(60));

        System.out.println("Original Values:");
        for(Integer number : intList){
            System.out.println(number);
        }

        System.out.println();
        System.out.println("Shuffled Values:");
        Collections.shuffle(intList);
        for(Integer number : intList){
            System.out.println(number);
        }

        System.out.println();
        System.out.println("Sorted Values:");
        Collections.sort(intList);
        for(Integer number : intList){
            System.out.println(number);
        }

        System.out.println();
        System.out.println("Reversed Values:");
        Collections.reverse(intList);
        for(Integer number : intList){
            System.out.println(number);
        }

        System.out.println();
        System.out.println("Rotated Values:");
        Collections.rotate(intList, 1);
        for(Integer number : intList){
            System.out.println(number);
        }

        //All Collections methods can be used on ArrayLists as well
    }
}
