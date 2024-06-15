package Part3;

public class Rectangle extends Shape {
    private double side1;
    private double side2;

    public Rectangle() {
        this("White", 1, 1);
    }

    public Rectangle(String color, double side1, double side2) {
        super("Rectangle", color);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSide 1: " + side1 +
                "\nSide 2: " + side2 +"\n";
    }

    @Override
    public double calculateArea() {
        return side1 * side2;
    }

    @Override
    public double calculatePerimeter() {
        return (2*side1) + (2*side2);
    }

}
