package com.example.Lab5;

import com.example.Lab5.car.Car;
import com.example.Lab5.carRepository.CarRepository;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @MockBean
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Test
    public void getCarShouldThrowNotFoundException(){
        CarService carService = new CarService(carRepository);
        when(carRepository.findById(1)).thenThrow(new CarNotFoundException());

    }
}
