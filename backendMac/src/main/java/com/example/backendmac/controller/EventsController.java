package com.example.com_rucinski.controller;

import com.example.api.EventManagementApi;
import com.example.com_rucinski.service.EventService;
import com.example.model.EventDTO;
import com.example.model.EventsEventIdApprovalPutRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsController implements EventManagementApi {

    @Autowired
    private EventService eventService;

    @Override
    public ResponseEntity<EventDTO> eventsEventIdGet(Integer eventId) {
        EventDTO eventDTO = eventService.getEventById(eventId.longValue());
        if (eventDTO != null) {
            return ResponseEntity.ok(eventDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> eventsEventIdPut(Integer eventId, EventDTO eventDTO) {
        EventDTO updatedEvent = eventService.updateEvent(eventId.longValue(), eventDTO);
        if (updatedEvent != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> eventsPost(EventDTO eventDTO) {
        EventDTO createdEvent = eventService.createEvent(eventDTO);
        if (createdEvent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<EventDTO>> eventsGet() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

//    @Override
//    public ResponseEntity<Void> eventsEventIdApprovalPut(Integer eventId, EventsEventIdApprovalPutRequest eventsEventIdApprovalPutRequest) {
//        // Assuming you handle event approval logic in EventService
//        boolean isApproved = eventService.approveEvent(eventId.longValue(), eventsEventIdApprovalPutRequest.isApproved());
//        if (isApproved) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
