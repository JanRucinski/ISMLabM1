package com.example.com_rucinski.service;

import com.example.com_rucinski.repository.EventRepository;
import com.example.com_rucinski.model.Event;
import com.example.model.EventDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImplementation implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO getEventById(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        return eventOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = convertToEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
        return convertToDTO(savedEvent);
    }

    @Override
    public EventDTO getEvent(Long eventId) {
        return null;
    }

    @Override
    public EventDTO updateEvent(Long eventId, EventDTO eventDTO) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            Event eventToUpdate = eventOptional.get();
            BeanUtils.copyProperties(eventDTO, eventToUpdate);
            eventToUpdate.setEventId(Math.toIntExact(eventId));
            Event updatedEvent = eventRepository.save(eventToUpdate);
            return convertToDTO(updatedEvent);
        }
        return null;
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (eventOptional.isPresent()) {
            eventRepository.delete(eventOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        BeanUtils.copyProperties(event, eventDTO);
        return eventDTO;
    }

    private Event convertToEntity(EventDTO eventDTO) {
        Event event = new Event();
        BeanUtils.copyProperties(eventDTO, event);
        return event;
    }
}
