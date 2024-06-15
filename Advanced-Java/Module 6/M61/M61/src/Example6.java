import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class Example6 {
    public static void main(String[] args) {
        Queue<Double> numbers = new LinkedList<>();
        numbers.offer(1.11);
        numbers.offer(2.22);
        numbers.offer(3.33);
        numbers.offer(4.44);
        numbers.offer(5.55);

        System.out.println();
        //Using remove will remove and retrieve.
        //We can print as we remove.  Eventually, the size will be 0 and the loop will end.
        while(numbers.size() > 0){
            System.out.println(numbers.remove());
        }
        //Notice when printing, prints first values in first and maintains order.

        Deque<Integer> values = new LinkedList<>();
        values.offer(1);
        values.offer(2);
        values.offer(3);
        values.addFirst(4);
        values.addFirst(5);
        values.addLast(6);
        values.addLast(7);

        while(values.size() > 0){
            System.out.println(values.removeFirst());
        }



    }
}
