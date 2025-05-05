package dev.arthur.eventClean.infra.request;

import dev.arthur.eventClean.core.enums.EventType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EventRequest (
        String name,
        String description,
        LocalDate startOfTheEvent,
        LocalDate endOfEvent,
        String identifier,
        Integer capacity,
        String eventLocation,
        String organizer,
        EventType eventType )
{}
