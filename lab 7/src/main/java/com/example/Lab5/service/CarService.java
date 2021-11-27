package com.example.Lab5.service;

import com.example.Lab5.car.Car;
import com.example.Lab5.carRepository.CarRepository;
import com.example.Lab5.exceptions.CarAlreadyExistException;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
public class CarService {
//    private HashMap<String, Car> map = new HashMap<>();

    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
        carRepository.save(new Car(1,"red","audi","a4"));
        carRepository.save(new Car(2,"black","bwm","e36"));
        carRepository.save(new Car(3,"white","mercedes","C63"));
    }

    public Car getCar(int id) {
        Car car = carRepository.findById(id);
        if (car == null){
            throw new CarNotFoundException();
        }
        return car;
    }

    public void addCar(int id,String color,String make,String model){
        if(carRepository.findById(id) == null){
            throw new CarAlreadyExistException();
        }
        carRepository.save(new Car(id,color, make, model));
    }

    public void addCar(int id, Car car){
        if(carRepository.findById(id) == null){
            throw new CarAlreadyExistException();
        }
        carRepository.save(car);
    }

    public void removeCar(int id){
        if(carRepository.findById(id) == null){
            throw new CarNotFoundException();
        }
        carRepository.deleteById(id);
    }

    public void updateCar(int id,Car newCar){
        if(carRepository.findById(id) != null){
            Car car = carRepository.findById(id);
            if(Objects.equals(newCar.getColor(),null)){
                throw new InvalidDataException();
            }

            car.setColor(newCar.getColor());

            if(Objects.equals(newCar.getMake(), null)){
                throw new InvalidDataException();
            }

            car.setMake(newCar.getMake());

            if(Objects.equals(newCar.getModel(),null)){
                throw new InvalidDataException();
            }

            car.setModel(newCar.getModel());
        }else {
            throw new CarNotFoundException();
        }
    }
}
