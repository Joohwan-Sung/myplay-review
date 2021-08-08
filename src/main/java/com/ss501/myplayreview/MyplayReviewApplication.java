package com.ss501.myplayreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyplayReviewApplication {
	
	public static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MyplayReviewApplication.class, args);
		//SpringApplication.run(MyplayPlaygroundApplication.class, args);
	}

}
