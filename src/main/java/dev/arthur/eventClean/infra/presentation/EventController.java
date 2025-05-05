package dev.arthur.eventClean.infra.presentation;

import dev.arthur.eventClean.infra.request.EventRequest;
import dev.arthur.eventClean.infra.response.EventResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(EventRequest eventRequest){

    }
}
