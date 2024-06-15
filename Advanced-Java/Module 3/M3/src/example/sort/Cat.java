package example.sort;

public class Cat implements Comparable<Cat>{
    private String name;
    private String breed;
    private int birthYear;
    private boolean vaccinated;

    public Cat() {
    }

    public Cat(String name, String breed, int birthYear, boolean vaccinated) {
        this.name = name;
        this.breed = breed;
        this.birthYear = birthYear;
        this.vaccinated = vaccinated;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Breed: " + breed + ", Birth Year: " + birthYear + ", Vaccinated? " + vaccinated;
    }

    //sorts by birth year and then name
    @Override
    public int compareTo(Cat o) {
        if(this.birthYear == o.birthYear){
            return this.name.compareTo(o.name);
        } else {
            return this.birthYear - o.birthYear;
        }
    }
}
