package io.swagger.service;

import io.swagger.model.Event;

import java.util.List;

public interface EventService {
    Event approveEvent(String eventId);
    Boolean deleteEvent(String eventId);
    Event getEvent(String eventId);
    Event updateEvent(String eventId, Event event);
    Event createEvent(Event event);

    List<Event> getAllEvents();
}
