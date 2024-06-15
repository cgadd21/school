public class Watch extends Products{
    public int size;
    public String material;

    public Watch() {
    }

    public Watch(String color, int releaseYear, int size, String material) {
        super(color, releaseYear);
        this.size = size;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\nThe watch size is " + size + "." +
        "\nThe material is " + material + "." + "\n";
    }

    @Override
    public void readyToReplace() {
        if(getReleaseYear() < 2018 ){
            System.out.println("This watch needs to be replaced.\n");
        }
    }

}
