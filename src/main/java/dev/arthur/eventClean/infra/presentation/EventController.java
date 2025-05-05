package dev.arthur.eventClean.infra.presentation;

import dev.arthur.eventClean.core.entities.Event;
import dev.arthur.eventClean.core.useCases.CreateEventCase;
import dev.arthur.eventClean.infra.mapper.EventRequestMapper;
import dev.arthur.eventClean.infra.mapper.EventResponseMapper;
import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class EventController {

    private CreateEventCase createEventCase;
    private final EventRequestMapper eventRequestMapper;
    private final EventResponseMapper eventResponseMapper;



    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest){
        Event event = createEventCase.execute(eventRequestMapper.fromRequestToDomain(eventRequest));
        EventResponse response = eventResponseMapper.domainToResponse(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
