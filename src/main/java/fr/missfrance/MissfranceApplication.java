package fr.missfrance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MissfranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MissfranceApplication.class, args);
    }

}
