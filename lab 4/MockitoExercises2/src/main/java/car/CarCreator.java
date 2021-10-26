package car;

public class CarCreator {
    public Car createCar(String carMake, String carColor, String carPlate) {
        Car car = new Car();

        car.setColor(carColor);
        car.setMake(carMake);
        car.setPlate(carPlate);

        return car;
    }
}
