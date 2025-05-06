package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.gateway.EventGateway;



public class CreateEventCaseImpl implements CreateEventCase {

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    public Event execute(Event event) {
        return new Event(event.id(),
                event.name(),
                event.description(),
                event.startOfTheEvent(),
                event.endOfEvent(),
                event.identifier(),
                event.capacity(),
                event.eventLocation(),
                event.organizer(),
                event.eventType());
    }
}
