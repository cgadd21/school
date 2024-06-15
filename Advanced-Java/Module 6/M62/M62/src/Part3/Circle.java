package Part3;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        this("White", 1);
    }

    public Circle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nRadius: " + radius+"\n";
    }

}
