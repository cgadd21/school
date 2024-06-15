package example.shapes;

public class Shape {
    private String name;
    private String color;
    private boolean border;

    public Shape() {
    }

    public Shape(String name, String color, boolean border) {
        this.name = name;
        this.color = color;
        this.border = border;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isBorder() {
        return border;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }
    public double calculateArea(){
        System.out.println("Area cannot be computed from this class.");
        return -1;
    }
    public double calculatePerimeter(){
        System.out.println("Perimeter cannot be computed from this class.");
        return -1;
    }



    @Override
    public String toString() {
        return "Color: " + color + '\n' +
                "Border? " + border + '\n';
    }
}
