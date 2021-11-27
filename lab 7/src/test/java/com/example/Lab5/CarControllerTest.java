package com.example.Lab5;

import com.example.Lab5.car.Car;
import com.example.Lab5.controller.CarController;
import com.example.Lab5.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CarService carService;

    @Test
    public void getCarReturnCar() throws Exception{
        Car testCar = new Car(1,"abc","abc","abc");
        when(carService.getCar(1)).thenReturn(testCar);

        mvc.perform(MockMvcRequestBuilders.get("/car/1")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'color':'abc','make':'abc','model':'abc'}"));

    }
}
