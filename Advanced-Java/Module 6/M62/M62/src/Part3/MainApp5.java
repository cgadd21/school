package Part3;

import java.util.ArrayList;

public class MainApp5 {
    public static void main(String[] args) {
        ArrayList<Circle> circles = new ArrayList<>();
        ArrayList<EquilateralTriangle> triangles = new ArrayList<>();
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        circles.add(new Circle("red", 10));
        circles.add(new Circle("blue", 20));
        circles.add(new Circle("purple", 30));

        triangles.add(new EquilateralTriangle("yellow", 5));

        rectangles.add(new Rectangle("orange", 4, 10));
        rectangles.add(new Rectangle("green", 8, 22));

        printList(circles);
        printList(triangles);
        printList(rectangles);
    }

    public static <E extends Shape> void printList(ArrayList<E> list){
        list.get(0).setColor("blue");
        System.out.println(list.size());
        System.out.println(list);
    }

}
