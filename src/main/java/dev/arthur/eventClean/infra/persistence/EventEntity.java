package dev.arthur.eventClean.infra.persistence;

import dev.arthur.eventClean.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Events")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private LocalDate startOfTheEvent;
    private LocalDate endOfEvent;
    private String identifier;
    private Integer capacity;
    private String eventLocation;
    private String organizer;
    @Enumerated(EnumType.STRING)
    private EventType eventType;
}
