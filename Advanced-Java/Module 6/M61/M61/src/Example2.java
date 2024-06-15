import java.util.LinkedList;

public class Example2 {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);  //autoboxing converts primitive types into object - doesn't just apply to linkedlist
        intList.add(Integer.valueOf(50));
        //intList.add(new Integer(60));

        System.out.println("Original Values:");
        for(Integer number : intList){
            System.out.println(number);
        }

        //Can remove by index or object
        //To remove an Integer, use Integer.valueOf() so that it doesn't
        //think you are trying to remove index 20
        intList.remove(0);
        intList.remove(Integer.valueOf(20));
        System.out.println();
        System.out.println("Fewer Values:");
        for(Integer number : intList){
            System.out.println(number);
        }


    }
}
