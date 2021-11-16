package com.example.MPRgr5;

import com.example.MPRgr5.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CarService {
    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
        carRepository.save(new Car("bmw", "x", "GD132"));
        carRepository.save(new Car("gradle", "x12", "ZR132"));
        carRepository.save(new Car("huawei", "ad", "GA132"));
        carRepository.save(new Car("opel", "wq", "WW132"));
    }

    public Car findById(long id) {
        return carRepository.findById(id);
    }

    public void addCar(long id ,Car car) {
        car.setId(id);
        carRepository.save(car);
    }

    public void deleteCar(long id){
        carRepository.delete(findById(id));
    }

//    public List<Car> getAllCars() {
//        List<Car> carList =new ArrayList<>();
//        carRepository.findAll().forEach(car -> carList.add(car));
//        return carList ;
//    }



//    private final Map<Integer, Car> carHashMap=new HashMap<>();
//    public CarService() {
//        carHashMap.put(1, new Car("bmw", "x", "GD132"));
//        carHashMap.put(2, new Car("gradle", "x12", "ZR132"));
//        carHashMap.put(3, new Car("huawei", "ad", "GA132"));
//        carHashMap.put(4, new Car("opel", "wq", "WW132"));
//    }
//
//    public Car getCar(Integer id) {
//        return carHashMap.get(id);
//    }
//

//
//    public void deleteCar(Integer id) {
//        carHashMap.remove(id);
//    }
}
