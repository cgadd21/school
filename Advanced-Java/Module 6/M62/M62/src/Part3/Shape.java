package Part3;

public class Shape {
    private String name;
    private String color;

    public Shape() {
        this("Shape", "Transparent");
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Type: " + name +
                "\nColor: " + color;
    }

    public double calculateArea(){
        System.out.println("Area cannot be computed from this class.");
        return -1;
    }

    public double calculatePerimeter(){
        System.out.println("Perimeter cannot be computed from this class.");
        return -1;
    }
}
