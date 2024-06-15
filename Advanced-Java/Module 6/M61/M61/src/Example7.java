import java.util.PriorityQueue;


public class Example7 {
    public static void main(String[] args) {
        PriorityQueue<Double> numbers = new PriorityQueue<>();
        numbers.offer(3.33);
        numbers.offer(2.22);
        numbers.offer(1.11);
        numbers.offer(5.55);
        numbers.offer(4.44);

        System.out.println();
        //Using remove will remove and retrieve.
        //We can print as we remove.  Eventually, the size will be 0 and the loop will end.
        while(numbers.size() > 0){
            System.out.println(numbers.remove());
        }
        //Notice when printing, gets numerically sorted first

        PriorityQueue<String> cities = new PriorityQueue<>();
        cities.offer("Rome");
        cities.offer("Paris");
        cities.offer("Amsterdam");
        cities.offer("Sydney");

        //PriorityQueue will alphabetize strings

        while(cities.size()>0){
            System.out.println(cities.remove());
        }
    }
}
