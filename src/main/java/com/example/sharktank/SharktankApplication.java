package com.example.sharktank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example.SharktankApplication"})
public class SharktankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharktankApplication.class, args);
	}

}
