package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.gateway.EventGateway;

import java.util.List;

public class SearchEventCaseImpl implements SearchEventCase{

    private final EventGateway eventGateway;

    public SearchEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    public List<Event> execute() {
        return eventGateway.searchEvents();
    }
}