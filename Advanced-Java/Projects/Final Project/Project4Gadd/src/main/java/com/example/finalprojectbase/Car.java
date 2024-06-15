package com.example.finalprojectbase;

public class Car {
    private String manufacturer;
    private String model;
    private int mpg;
    private int hp;
    private boolean usa;

    public Car() {
    }

    public Car(String manufacturer, String model, int mpg, int hp, boolean usa) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.mpg = mpg;
        this.hp = hp;
        this.usa = usa;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isUsa() {
        return usa;
    }

    public void setUsa(boolean usa) {
        this.usa = usa;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", mpg=" + mpg +
                ", hp=" + hp +
                ", usa=" + usa +
                '}';
    }
}
