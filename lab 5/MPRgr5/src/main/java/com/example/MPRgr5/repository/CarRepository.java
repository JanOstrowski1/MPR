package com.example.MPRgr5.repository;


import com.example.MPRgr5.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
    public Car findById(long id);
}
