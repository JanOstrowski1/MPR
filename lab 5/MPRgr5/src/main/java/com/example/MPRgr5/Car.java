package com.example.MPRgr5;

public class Car {
    public String name;
    public String model;
    public String plate;

    public Car(String name, String model, String plate) {
        this.name = name;
        this.model = model;
        this.plate = plate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }
}
