package example.shapes;

public class Rectangle extends Shape{
    private double side1;
    private double side2;

    public Rectangle() {
        setName("Rectangle");
    }

    public Rectangle(String color, boolean border, double side1, double side2) {
        super("Rectangle", color, border);
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
        return "Shape Type: " + getName() + '\n' +
                super.toString() +
                "Side 1: " + side1 + '\n' +
                "Side 2: " + side2;
    }

    @Override
    public double calculateArea() {
        return side1 * side2;
    }

    @Override
    public double calculatePerimeter() {
        return (side1 * 2) + (side2 * 2);
    }
}
