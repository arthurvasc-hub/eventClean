package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.gateway.EventGateway;
import org.hibernate.id.IdentifierGenerator;

public class IdentifierGeneratorImpl implements IdentifierGeneratorCase {

    private final EventGateway eventGateway;

    public IdentifierGeneratorImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    public String execute() {
        return eventGateway.generateIdentifier();
    }
}
