package dev.arthur.eventClean.infra.gateway;
import org.apache.commons.lang3.RandomStringUtils;


import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.gateway.EventGateway;
import dev.arthur.eventClean.infra.mapper.EventEntityMapper;
import dev.arthur.eventClean.infra.persistence.EventEntity;
import dev.arthur.eventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;



    @Override
    public Event saveDomain(Event event) {
        String newIdentifier = generateIdentifier();

        if (event.identifier() == null || event.identifier().isBlank()) {
            event = new Event(
                    event.id(),
                    event.name(),
                    event.description(),
                    event.startOfTheEvent(),
                    event.endOfEvent(),
                    newIdentifier,
                    event.capacity(),
                    event.eventLocation(),
                    event.organizer(),
                    event.eventType());
        }

        EventEntity save = eventRepository.save(eventEntityMapper.domainToEntity(event));
        return eventEntityMapper.entityToDomain(save);
    }


    @Override
    public List<Event> searchEvents() {
        List<EventEntity> events = eventRepository.findAll();
        return events.stream()
                .map(eventEntityMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Event> findEventByIdentifier(String identifier) {
        return eventRepository.findEventByIdentifier(identifier);

    }

    @Override
    public String generateIdentifier() {
        String letters = RandomStringUtils.random(3, true, false); // Só letras
        String numbers = RandomStringUtils.random(3, false, true); // Só números


        return letters + numbers;
    }


}
