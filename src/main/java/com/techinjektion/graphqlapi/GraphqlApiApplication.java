package com.techinjektion.graphqlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class GraphqlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApiApplication.class, args);
	}

}
