package com.andre.helpdeskback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelpdeskBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskBackApplication.class, args);
	}

}
