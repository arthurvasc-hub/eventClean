package dev.arthur.eventClean.core.entities;

import dev.arthur.eventClean.core.enums.EventType;

import java.time.LocalDate;

public record Event(
                    Long id,
                    String name,
                    String description,
                    LocalDate startOfTheEvent,
                    LocalDate endOfEvent,
                    String identifier,
                    Integer capacity,
                    String eventLocation,
                    String organizer,
                    EventType eventType )
{ }
