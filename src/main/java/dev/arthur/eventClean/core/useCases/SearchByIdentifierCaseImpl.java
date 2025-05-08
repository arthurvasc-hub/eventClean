package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.gateway.EventGateway;

import java.util.Optional;

public class SearchByIdentifierCaseImpl implements SearchByIdentifierCase {

    private final EventGateway eventGateway;

    public SearchByIdentifierCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Optional<Event> execute(String identifier) {
        return eventGateway.findEventByIdentifier(identifier);
    }
}
