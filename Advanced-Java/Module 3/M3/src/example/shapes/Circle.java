package example.shapes;

public class Circle extends Shape{
    private double radius;

    public Circle() {
        setName("Circle");
    }

    public Circle(String color, boolean border, double radius) {
        super("Circle", color, border);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Shape Type: " + getName() + '\n' +
                super.toString() +
                "Radius: " + radius;
    }
}
