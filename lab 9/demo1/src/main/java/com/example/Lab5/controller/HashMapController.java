package com.example.Lab5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashMapController {

    @GetMapping("/map")
    public String getMap(){
        return "This is my map";
    }
}
