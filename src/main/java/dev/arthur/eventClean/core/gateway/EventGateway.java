package dev.arthur.eventClean.core.gateway;

import dev.arthur.eventClean.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    public Event saveDomain (Event event);

    public List<Event> searchEvents();

    public Optional<Event> findEventByIdentifier(String identifier);

    public String generateIdentifier();
}
