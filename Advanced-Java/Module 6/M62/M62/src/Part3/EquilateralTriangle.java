package Part3;

public class EquilateralTriangle extends Shape{
    private double side;

    public EquilateralTriangle() {
        this("White", 1);
    }

    public EquilateralTriangle(String color, double side) {
        super("Equilateral Triangle", color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(3)/4 * Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return side * 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSide Length: " + side+"\n";
    }
}
