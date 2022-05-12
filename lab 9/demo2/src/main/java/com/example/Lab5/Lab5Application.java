package com.example.Lab5;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lab5Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Lab5Application.class, args);
	}

}
