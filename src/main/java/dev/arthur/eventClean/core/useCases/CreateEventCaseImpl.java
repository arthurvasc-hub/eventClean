package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;


public class CreateEventCaseImpl implements CreateEventCase {


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
