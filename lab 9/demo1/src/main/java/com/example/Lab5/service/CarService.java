package com.example.Lab5.service;

import com.example.Lab5.car.Car;
import com.example.Lab5.carRepository.CarRepository;
import com.example.Lab5.exceptions.CarAlreadyExistException;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.exceptions.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
public class CarService {

    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
        carRepository.save(new Car(1,"blue","fiat"));
        carRepository.save(new Car(2,"black","mercedes"));
        carRepository.save(new Car(3,"white","audi"));
    }

    public Car getCar(int id) {
        Car car = carRepository.findById(id);
        if (car == null){
            throw new CarNotFoundException();
        }
        return car;
    }

    public void addCar(int id,String color,String make){
        if(carRepository.findById(id) == null){
            throw new CarAlreadyExistException();
        }
        carRepository.save(new Car(id,color, make));
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

            carRepository.save(car);

        }else {
            throw new CarNotFoundException();
        }
    }

    public List<Car> getCarsFromRepo() {
        return carRepository.findAll();
    }

    public int insertCarIntoRepo(Car car) {
        if(carRepository.existsById(car.getId())){
            throw new CarAlreadyExistException();
        }
        return carRepository.save(car).getId();
    }
}
