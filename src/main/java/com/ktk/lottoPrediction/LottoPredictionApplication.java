package com.ktk.lottoPrediction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LottoPredictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LottoPredictionApplication.class, args);
	}

}
