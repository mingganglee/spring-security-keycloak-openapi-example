package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApiApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(MyApiApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
