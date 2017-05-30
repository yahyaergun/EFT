package com.yergun.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EftApplication {

	@RequestMapping("/")
	String hello(){
		return "hello dude!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EftApplication.class, args);
	}
}
