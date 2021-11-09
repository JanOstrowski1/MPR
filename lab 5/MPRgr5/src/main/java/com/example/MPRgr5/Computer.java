package com.example.MPRgr5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private GPU gpu;
    private Motherboard motherboard;
    private Processor processor;

    @Autowired
    public Computer(GPU gpu, Motherboard motherboard, Processor processor) {
        this.gpu = gpu;
        this.motherboard = motherboard;
        this.processor = processor;
    }
}
