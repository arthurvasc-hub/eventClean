package dev.arthur.eventClean.infra.gateway;

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


}
