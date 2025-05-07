package dev.arthur.eventClean.core.useCases;

import dev.arthur.eventClean.core.entities.Event;

import java.util.List;

public interface SearchEventCase {

    public List<Event> execute();

}
