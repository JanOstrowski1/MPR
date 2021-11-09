package com.example.MPRgr5;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarService {
    private  Map<Integer, Car> carHashMap=new HashMap<>();
    public CarService() {
        carHashMap.put(1, new Car("bmw", "x", "GD132"));
        carHashMap.put(2, new Car("gradle", "x12", "ZR132"));
        carHashMap.put(3, new Car("huawei", "ad", "GA132"));
        carHashMap.put(4, new Car("opel", "wq", "WW132"));
    }

    public Car getCar(Integer id) {
        return carHashMap.get(id);
    }

    public void addCar(Integer id, String name, String model, String plate) {
        carHashMap.put(id, new Car(name, model, plate));
    }
}
