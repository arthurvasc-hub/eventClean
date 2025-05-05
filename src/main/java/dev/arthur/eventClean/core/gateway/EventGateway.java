package dev.arthur.eventClean.core.gateway;

import dev.arthur.eventClean.core.entities.Event;

public interface EventGateway {

    public Event saveDomain (Event event);
}
