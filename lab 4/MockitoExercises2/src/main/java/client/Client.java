package client;

import car.Car;

public class Client {
    private String id;
    private boolean active;
    private Car car;

    public Client() {
    }

    public Client(String id, boolean active, Car car) {
        this.id = id;
        this.active = active;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
