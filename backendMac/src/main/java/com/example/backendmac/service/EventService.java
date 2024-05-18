package com.example.com_rucinski.service;

import java.util.List;

import com.example.model.EventDTO;

public interface EventService {
    EventDTO getEventById(Long eventId);
    EventDTO createEvent(EventDTO saleEventDTO);
    EventDTO getEvent(Long eventId);
    List<EventDTO> getAllEvents();
    EventDTO updateEvent(Long eventId, EventDTO saleEventDTO);
    boolean deleteEvent(Long eventId);
}
