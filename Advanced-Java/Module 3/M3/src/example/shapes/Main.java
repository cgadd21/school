package example.shapes;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        System.out.println( );

        Circle circle1 = new Circle("Purple", true, 4.4);
        System.out.println(circle1);
        System.out.println("Area: " + circle1.calculateArea());
        System.out.println("Perimeter: " + circle1.calculatePerimeter());
        System.out.println();

        Rectangle rectangle1 = new Rectangle("Red", true, 10.1, 20.2);
        System.out.println(rectangle1);
        System.out.println("Area: " + rectangle1.calculateArea());
        System.out.println("Perimeter " + rectangle1.calculatePerimeter());
    }


}
