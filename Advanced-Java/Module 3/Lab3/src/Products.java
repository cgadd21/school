public abstract class Products implements Comparable<Products> {
    private String color;
    private int releaseYear;

    protected Products() {
    }

    protected Products(String color, int releaseYear) {
        this.color = color;
        this.releaseYear = releaseYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "The Product's color is " + color + " and came out in " + releaseYear + ".";
    }
    public abstract void readyToReplace();

    public int compareTo(Products o){
        if(this.getReleaseYear() == o.getReleaseYear()){
            return 0;
        } else if (this.getReleaseYear() > o.getReleaseYear()){
            return 1;
        } else {
            return -1;
        }
    }
}
