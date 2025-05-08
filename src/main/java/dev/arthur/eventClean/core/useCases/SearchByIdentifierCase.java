package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;

import java.util.Optional;

public interface SearchByIdentifierCase {
    public Optional<Event> execute(String identifier);
}
