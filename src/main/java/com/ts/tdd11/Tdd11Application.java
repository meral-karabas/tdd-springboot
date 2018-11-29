package com.ts.tdd11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Tdd11Application {

	public static void main(String[] args) {
		SpringApplication.run(Tdd11Application.class, args);
	}
}
