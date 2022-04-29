package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan
@EnableAutoConfiguration
@EnableCassandraRepositories
public class Cassandra2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cassandra2Application.class, args);
	}

}
