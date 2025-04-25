package dev.arthur.eventClean.core.entities;

import dev.arthur.eventClean.core.enums.EventType;

import java.time.LocalDate;

public record Event( String name,
                    String description,
                    LocalDate startOfTheEvent,
                    LocalDate endOfEvent,
                    String identifier,
                    String local,
                    String organizer,
                    EventType eventType )
{ }
