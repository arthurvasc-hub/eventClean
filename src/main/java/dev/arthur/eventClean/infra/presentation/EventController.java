package dev.arthur.eventClean.infra.presentation;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.useCases.CreateEventCase;
import dev.arthur.eventClean.infra.gateway.EventRepositoryGateway;
import dev.arthur.eventClean.infra.mapper.EventRequestMapper;
import dev.arthur.eventClean.infra.mapper.EventResponseMapper;
import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EventController {

    private final CreateEventCase createEventCase;
    private final EventRequestMapper eventRequestMapper;
    private final EventResponseMapper eventResponseMapper;
    private final EventRepositoryGateway repositoryGateway;

    public EventController(CreateEventCase createEventCase, EventRequestMapper eventRequestMapper, EventResponseMapper eventResponseMapper, EventRepositoryGateway repositoryGateway) {
        this.createEventCase = createEventCase;
        this.eventRequestMapper = eventRequestMapper;
        this.eventResponseMapper = eventResponseMapper;
        this.repositoryGateway = repositoryGateway;
    }

    @PostMapping("/event")
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest){
        Event event = createEventCase.execute(eventRequestMapper.fromRequestToDomain(eventRequest));
        repositoryGateway.saveDomain(event);
        EventResponse response = eventResponseMapper.domainToResponse(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
