package dev.arthur.eventClean.infra.mapper;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.infra.persistence.EventEntity;
import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import org.springframework.stereotype.Component;

@Component
public class EventResponseMapper {

    public EventResponse toResponse(Event entity) {
        if (entity == null) return null;

        return EventResponse.builder()
                .id(entity.id())
                .name(entity.name())
                .startOfTheEvent(entity.startOfTheEvent())
                .endOfTheEvent(entity.endOfEvent())
                .identifier(entity.identifier())
                .eventLocation(entity.eventLocation())
                .eventType(entity.eventType())
                .build();
    }
}
