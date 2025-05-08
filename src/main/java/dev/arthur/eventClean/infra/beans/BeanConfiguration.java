package dev.arthur.eventClean.infra.beans;

import dev.arthur.eventClean.core.gateway.EventGateway;
import dev.arthur.eventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventCase createEvent(EventGateway eventGateway){
        return new CreateEventCaseImpl(eventGateway);
    }

    @Bean
    public SearchEventCase searchEventCase(EventGateway eventGateway){
        return new SearchEventCaseImpl(eventGateway);
    }

    @Bean
    public SearchByIdentifierCase searchByIdentifierCase(EventGateway eventGateway){
        return new SearchByIdentifierCaseImpl(eventGateway);
    }
}
