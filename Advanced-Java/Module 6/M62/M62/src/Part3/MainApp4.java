package Part3;

//An example using bounded type generic methods
//<E extends Shape> tells java this is a generic method
//that can handle any object as long as it's a Shape or Shape sub-class
//E is then used as the generic data type for passing in these objects
public class MainApp4 {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        System.out.println("Same area? " + equalArea(c1, r1));
    }

    public static <E extends Shape> boolean equalArea(E o1, E o2) {
        return o1.calculateArea() == o2.calculateArea();
    }
}
