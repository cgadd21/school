public class Text {
    public double celsius;
    public double kelvin;
    public boolean visible = false;

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Text() {}

    public boolean isVisible() {
        return visible;
    }

    public void print() {
        System.out.printf("Reading is %6.2f degrees C and %6.2f degrees K %n", celsius, kelvin);
    }
}
