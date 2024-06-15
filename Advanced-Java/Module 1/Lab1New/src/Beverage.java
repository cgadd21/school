/** This class models a beverage.
 * @author Cooper
 */
public class Beverage {
    /**the name of the beverage*/
    private String name;
    /**the description of the beverage*/
    private String description;
    /**the calories in the beverage*/
    private int calories;
    /**the caffeinated status of the beverage*/
    private boolean caffeinated;
    /**Creates a new beverage*/
    public Beverage() {
    }
    /**Creates a new beverage with a given name
     * @param name the name of the beverage
     **/
    public Beverage(String name) {
        this.name = name;
    }
    /**Creates a new beverage with a given name, description, calories, caffeinated status
     * @param name the name of the beverage
     * @param description the description of the beverage
     * @param calories the calories in the beverage
     * @param caffeinated the caffeinated status of the beverage
      */
    public Beverage(String name, String description, int calories, boolean caffeinated) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.caffeinated = caffeinated;
    }
    /**
     * Gets the name of the beverage
     *
     * @return the name of the beverage
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the description of the beverage
     *
     * @return the description of the beverage
     */
    public String getDescription() {
        return description;
    }
    /**
     * Gets the calories of the beverage
     *
     * @return the calories of the beverage
     */
    public int getCalories() {
        return calories;
    }
    /**
     * Gets the caffeinated status of the beverage
     *
     * @return the caffeinated status of the beverage
     */
    public boolean isCaffeinated() {
        return caffeinated;
    }
    /**Sets the name of the beverage*/
    public void setName(String name) {
        this.name = name;
    }
    /**Sets the description of the beverage*/
    public void setDescription(String description) {
        this.description = description;
    }
    /**Sets the calories of the beverage*/
    public void setCalories(int calories) {
        this.calories = calories;
    }
    /**Sets the caffeinated status of the beverage*/
    public void setCaffeinated(boolean caffeinated) {
        this.caffeinated = caffeinated;
    }
    /**Displays the name, description, calories, and caffeinated status of beverage*/
    @Override
    public String toString() {
        return "Beverage:" + '\n' +
                "name - " + name + '\n' +
                ", description - " + description + '\n' +
                ", calories - " + calories + '\n' +
                ", caffeinated - " + caffeinated;
    }
}
