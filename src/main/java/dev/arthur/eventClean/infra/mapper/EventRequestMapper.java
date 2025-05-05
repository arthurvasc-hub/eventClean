package dev.arthur.eventClean.infra.mapper;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.infra.request.EventRequest;
import org.springframework.stereotype.Component;

@Component
public class EventRequestMapper {

    public EventRequest fromDomainToRequest(Event event) {
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

    public Event fromRequestToDomain(EventRequest request) {
        if (request == null) return null;

        return new Event(
                null,
                request.name(),
                request.description(),
                request.startOfTheEvent(),
                request.endOfEvent(),
                request.identifier(),
                request.capacity(),
                request.eventLocation(),
                request.organizer(),
                request.eventType()
        );
    }

}
