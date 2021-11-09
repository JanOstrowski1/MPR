package com.example.MPRgr5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MpRgr5Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(MpRgr5Application.class, args);
		System.out.println(context.getBean(Computer.class));
	}

}
