package com.example.demo;

import com.example.demo.controller.DataOutputController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		//DataOutputController controller = new DataOutputController();
		//controller.outputData();

	}
}
