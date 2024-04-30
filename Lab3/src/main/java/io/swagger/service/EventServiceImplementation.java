package io.swagger.service;

import io.swagger.model.Event;
import io.swagger.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventServiceImplementation implements EventService{
    @Autowired
    private EventRepository eventRepository;
    public Event approveEvent(String eventId) {
        Optional<Event> event = eventRepository.findById(Long.parseLong(eventId));
        if(event.isPresent()){
            Event event1 = event.get();
            event1.setApproved(true);
            eventRepository.save(event1);
            return event1;
        }
        return null;
    }

    public Boolean deleteEvent(String eventId) {
        Optional<Event> event = eventRepository.findById(Long.parseLong(eventId));
        if(event.isPresent()){
            eventRepository.delete(event.get());
            return true;
        }
        return false;
    }

    public Event getEvent(String eventId) {
        Optional<Event> event = eventRepository.findById(Long.parseLong(eventId));
        if(event.isPresent()){
            return event.get();
        }
        return null;
    }

    public Event updateEvent(String eventId, Event event) {
        Optional<Event> event1 = eventRepository.findById(Long.parseLong(eventId));
        if(event1.isPresent()){
            Event event2 = event1.get();
            event2.setEventId(event.getEventId());
            event2.setLocation(event.getLocation());
            event2.setDate(event.getDate());
            event2.setTime(event.getTime());
            event2.setApproved(event.isApproved());
            eventRepository.save(event2);
            return event2;
        }
        return null;

    }

    public Event createEvent(Event event) {
        Event event1 = event;
        eventRepository.save(event1);
        return event1;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }
}
