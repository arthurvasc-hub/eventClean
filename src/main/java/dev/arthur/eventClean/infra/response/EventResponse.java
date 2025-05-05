package dev.arthur.eventClean.infra.response;

import dev.arthur.eventClean.core.enums.EventType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EventResponse (
        String name,
        LocalDate startOfTheEvent,
        LocalDate endOfTheEvent,
        String identifier,
        String eventLocation,
        EventType eventType )
{}
