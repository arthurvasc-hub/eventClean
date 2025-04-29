package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.enums.EventType;

import java.time.LocalDate;

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
/*
"Tech Conference 2025",
        "Conferência anual de tecnologia focada em inovação, inteligência artificial e desenvolvimento de software.",
        LocalDate.of(2025, 9, 15),
                LocalDate.of(2025, 9, 17),
                "TECH2025CONF", //
                        "Centro de Convenções de São Paulo - SP",
                        "InovaTech Brasil",
EventType.CONFERENCE);*/
