package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.enums.EventType;

import java.time.LocalDate;

public class CreateEventCaseImpl implements CreateEventCase {

    @Override
    public Event execute(Event event) {
        return new Event(event.name(),
                event.description(),
                event.startOfTheEvent(),
                event.endOfEvent(),
                event.identifier(),
                event.local(),
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
