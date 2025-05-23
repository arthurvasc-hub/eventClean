package dev.arthur.eventClean;

import dev.arthur.eventClean.infra.gateway.EventRepositoryGateway;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventCleanApplication {



    public static void main(String[] args) {
		SpringApplication.run(EventCleanApplication.class, args);
	}


}
