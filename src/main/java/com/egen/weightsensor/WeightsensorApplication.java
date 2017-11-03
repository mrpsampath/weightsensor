package com.egen.weightsensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.egen.controller.WeightController;

@SpringBootApplication
@ComponentScan(basePackageClasses = WeightController.class)
public class WeightsensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeightsensorApplication.class, args);
	}
}
