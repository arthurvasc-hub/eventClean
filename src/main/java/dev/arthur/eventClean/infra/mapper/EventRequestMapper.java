package dev.arthur.eventClean.infra.mapper;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.infra.persistence.EventEntity;
import dev.arthur.eventClean.infra.request.EventRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class EventRequestMapper {

    public EventRequest fromEntityToRequest(Event event) {
        if (event == null) return null;

        return EventRequest.builder()
                .name(event.name())
                .description(event.description())
                .startOfTheEvent(event.startOfTheEvent())
                .endOfEvent(event.endOfEvent())
                .identifier(event.identifier())
                .capacity(event.capacity())
                .eventLocation(event.eventLocation())
                .organizer(event.organizer())
                .eventType(event.eventType())
                .build();


    }

    public Event fromRequestToEntity(EventRequest request) {
        if (request == null) return null;

        return Event.builder()
                .name(request.name())
                .description(request.description())
                .startOfTheEvent(request.startOfTheEvent())
                .endOfEvent(request.endOfEvent())
                .identifier(request.identifier())
                .capacity(request.capacity())
                .eventLocation(request.eventLocation())
                .organizer(request.organizer())
                .eventType(request.eventType())
                .build();
    }

}
