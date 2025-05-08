package dev.arthur.eventClean.infra.persistence;

import dev.arthur.eventClean.core.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    public Optional<Event> findEventByIdentifier(String identifier);
}
