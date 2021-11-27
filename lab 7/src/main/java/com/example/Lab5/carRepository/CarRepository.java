package com.example.Lab5.carRepository;


import com.example.Lab5.car.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Integer> {
    public Car findById(int id);
}
