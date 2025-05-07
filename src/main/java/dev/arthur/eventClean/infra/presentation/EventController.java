package dev.arthur.eventClean.infra.presentation;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.useCases.CreateEventCase;
import dev.arthur.eventClean.core.useCases.SearchEventCase;
import dev.arthur.eventClean.infra.mapper.EventRequestMapper;
import dev.arthur.eventClean.infra.mapper.EventResponseMapper;
import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CreateEventCase createEventCase;
    private final SearchEventCase searchEventCase;
    private final EventRequestMapper eventRequestMapper;
    private final EventResponseMapper eventResponseMapper;


    public EventController(CreateEventCase createEventCase, SearchEventCase searchEventCase, EventRequestMapper eventRequestMapper, EventResponseMapper eventResponseMapper) {
        this.createEventCase = createEventCase;
        this.searchEventCase = searchEventCase;
        this.eventRequestMapper = eventRequestMapper;
        this.eventResponseMapper = eventResponseMapper;
    }

    @PostMapping("/event")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest){
        Event event = createEventCase.execute(eventRequestMapper.fromRequestToDomain(eventRequest));
        EventResponse response = eventResponseMapper.domainToResponse(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/event")
    public ResponseEntity<List<EventResponse>> searchEvent(){
        List<Event> events = searchEventCase.execute();
        List<EventResponse> eventResponses = events.stream()
                .map(eventResponseMapper::domainToResponse)
                .toList();
        return ResponseEntity.ok().body(eventResponses);
    }


}
