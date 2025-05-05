package dev.arthur.eventClean.infra.mapper;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public Event entityToDomain (EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getStartOfTheEvent(),
                eventEntity.getEndOfEvent(),
                eventEntity.getIdentifier(),
                eventEntity.getCapacity(),
                eventEntity.getEventLocation(),
                eventEntity.getOrganizer(),
                eventEntity.getEventType()
        );
    }


    public EventEntity domainToEntity (Event event) {
         return EventEntity.builder()
                .id(event.id())
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
}
