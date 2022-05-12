package com.example.Lab5.controller;

import com.example.Lab5.car.Car;
import com.example.Lab5.exceptions.CarAlreadyExistException;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.exceptions.InvalidDataException;
import com.example.Lab5.service.CarService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;


@Controller
public class CarsController {
    CarService carService;
    final String API_URL="http://localhost:8082";
    WebClient webClient = WebClient.create(API_URL);
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String displayCars(Model model){

        //     Car[] cars = restTemplate.getForObject(API_URL+"/cars",Car[].class);
        Car[] cars = webClient
                .get()
                .uri("/cars")
                .retrieve()
                .bodyToMono(Car[].class)
                .block();
        List<Car> carList = Arrays.asList(cars);
        model.addAttribute("cars", cars);

        return "index";
    }

    @GetMapping("/cars/add")
    public String displayAddCarForm(Model model){
        model.addAttribute("car",new Car());
        return "addForm";
    }

    @PostMapping("/cars/add")
    public String submitAddCarForm(@ModelAttribute Car car){
        //   restTemplate.postForObject(API_URL+"/car/add/"+car.getId(),car,Void.class);
        webClient
                .post()
                .uri("/car/add/"+car.getId())
                .body(Mono.just(car),Car.class)
                .retrieve()
                .bodyToMono(Void.class).block();
        return "redirect:/cars";
    }


    @GetMapping("/cars/delete")
    public String displayDeleteCarForm(Model model){
        model.addAttribute("car",new Car());
        return "deleteForm";
    }

    @PostMapping("/cars/delete")
    public String submitDeleteCarForm(@ModelAttribute Car car){
        webClient
                .delete()
                .uri("/car/remove/"+car.getId())
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return "redirect:/cars";
    }


    @GetMapping("/cars/update")
    public String displayUpdateCarForm(Model model){
        model.addAttribute("car",new Car());
        return "updateForm";
    }

    @PostMapping("/cars/update")
    public String submitUpdateCarForm(@ModelAttribute Car car){
        //  carService.updateCar(car.getId(),car);

        webClient
                .put()
                .uri("/car/update/"+car.getId())
                .body(Mono.just(car),Car.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
        return "redirect:/cars";
    }
}
