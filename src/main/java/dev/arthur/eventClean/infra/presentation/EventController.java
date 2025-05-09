package dev.arthur.eventClean.infra.presentation;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.useCases.CreateEventCase;
import dev.arthur.eventClean.core.useCases.SearchByIdentifierCase;
import dev.arthur.eventClean.core.useCases.SearchEventCase;
import dev.arthur.eventClean.infra.exceptions.InvalidIdentifierException;
import dev.arthur.eventClean.infra.mapper.EventRequestMapper;
import dev.arthur.eventClean.infra.mapper.EventResponseMapper;
import dev.arthur.eventClean.infra.persistence.EventRepository;
import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class EventController {

private final CreateEventCase createEventCase;
private final SearchEventCase searchEventCase;
private final SearchByIdentifierCase searchByIdentifierCase;
private final EventRequestMapper eventRequestMapper;
private final EventResponseMapper eventResponseMapper;

public EventController(CreateEventCase createEventCase, SearchEventCase searchEventCase, SearchByIdentifierCase searchByIdentifierCase, EventRequestMapper eventRequestMapper, EventResponseMapper eventResponseMapper) {
    this.createEventCase = createEventCase;
    this.searchEventCase = searchEventCase;
    this.searchByIdentifierCase = searchByIdentifierCase;
    this.eventRequestMapper = eventRequestMapper;
    this.eventResponseMapper = eventResponseMapper;
}

@PostMapping("/event")
public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventRequest eventRequest) {
    Map<String, Object> messages = new HashMap<>();
    Optional<Event> eventByIdentifier = searchByIdentifierCase.execute(eventRequest.identifier());

    if (eventByIdentifier.isPresent()) {
    throw new InvalidIdentifierException("An event with this identifier already exists.");
        }

    Event event = createEventCase.execute(eventRequestMapper.fromRequestToDomain(eventRequest));
    EventResponse response = eventResponseMapper.domainToResponse(event);
        messages.put("Message: ", "Your event was successfully created!");
        messages.put("Info: ", response);
    return ResponseEntity.status(HttpStatus.CREATED).body(messages);
}

@GetMapping("/event")
public ResponseEntity<List<EventResponse>> searchEvent(){
    List<Event> events = searchEventCase.execute();
    List<EventResponse> eventResponses = events.stream()
        .map(eventResponseMapper::domainToResponse)
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(eventResponses);
}


@GetMapping("/event/{identifier}")
public ResponseEntity<EventResponse> searchByIdentifier(@PathVariable String identifier){
    Optional<Event> eventFound = searchByIdentifierCase.execute(identifier);

    if(eventFound.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no event in our DB with the identifier: " + identifier);

    }

    EventResponse eventResponse = eventResponseMapper.domainToResponse(eventFound.get());

    return ResponseEntity.ok(eventResponse);

}

}
