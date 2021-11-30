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

import java.util.List;

@Controller
public class CarsController {

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    CarService carService;

    @GetMapping("/cars")
    public String getCar(Model model) {
        List<Car> cars = carService.getCarsFromRepo();
        model.addAttribute("cars",cars);
        return "index";
    }

    @GetMapping("/cars/add")
    public String displayAddCarForm(Model model){
        model.addAttribute("car",new Car());
        return "addForm";
    }

    @PostMapping("/cars/add")
    public String submitAddCarForm(@ModelAttribute Car car){
        carService.insertCarIntoRepo(car);

        return "redirect:/cars";
    }
    @GetMapping("/cars/delete")
    public String displayDeleteCarForm(Model model){
        model.addAttribute("car",new Car());
        return "deleteForm";
    }

    @PostMapping("/cars/delete")
    public String submitDeleteCarForm(@ModelAttribute Car car){
        carService.removeCar(car.getId());
        return "redirect:/cars";
    }

    @GetMapping("/cars/update")
    public String displayUpdateCarForm(Model model){
        model.addAttribute("car",new Car());
        return "updateForm";
    }

    @PostMapping("/cars/update")
    public String submitUpdateCarForm(@ModelAttribute Car car){
        carService.updateCar(car.getId(),car);
        return "redirect:/cars";
    }


}
