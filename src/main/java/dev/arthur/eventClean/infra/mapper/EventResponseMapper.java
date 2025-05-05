package dev.arthur.eventClean.infra.mapper;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.infra.response.EventResponse;
import org.springframework.stereotype.Component;

@Component
public class EventResponseMapper {

    public EventResponse domainToResponse(Event event) {
        if (event == null) return null;

        return EventResponse.builder()
                .id(event.id())
                .name(event.name())
                .startOfTheEvent(event.startOfTheEvent())
                .endOfTheEvent(event.endOfEvent())
                .identifier(event.identifier())
                .eventLocation(event.eventLocation())
                .eventType(event.eventType())
                .build();
    }
}
