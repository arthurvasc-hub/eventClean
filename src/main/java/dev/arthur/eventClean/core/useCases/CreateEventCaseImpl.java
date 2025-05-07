package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.gateway.EventGateway;



public class CreateEventCaseImpl implements CreateEventCase {

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    public Event execute(Event event) {
        return eventGateway.saveDomain(event);
    }
}
