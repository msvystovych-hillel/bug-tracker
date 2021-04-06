package com.example.demo;

import com.example.demo.controller.DataOutputController;
import com.example.demo.data.User;
import com.example.demo.repository.JdbcRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
}
