package Part3;

import java.util.ArrayList;

public class MainApp3 {
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

        //printList is SO generic that we can even pass other objects in
        String hello = "Hello";
        printList(hello);
    }

    public static <E> void printList(E list){
        System.out.println(list);
    }

    //redundant code
    /*public static void printCircleList(ArrayList<Circle> circleList){
        System.out.println(circleList);
    }

    public static void printRectangleList(ArrayList<Rectangle> rectangleList){
        System.out.println(rectangleList);
    }

    public static void printTriangleList(ArrayList<EquilateralTriangle> triangleList){
        System.out.println(triangleList);
    }*/


}
