package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;

public interface CreateEventCase {

    public Event execute(Event event);
}
