package com.example.postblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.example.postblogs")
public class PostBlogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostBlogsApplication.class, args);
	}

//	@GetMapping("/hello")
//	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name){
//		return String.format("Hello %s!", name);
//	}
}
