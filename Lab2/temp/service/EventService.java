package com.example.com_rucinski.service;

import com.example.com_rucinski.dto.SaleEventDTO;

import java.util.List;

public interface EventService {
    Event getEventById(Long eventId);
    SaleEventDTO createEvent(SaleEventDTO saleEventDTO);
    SaleEventDTO getEvent(Long eventId);
    List<SaleEventDTO> getAllEvents();
    SaleEventDTO updateEvent(Long eventId, SaleEventDTO saleEventDTO);
    boolean deleteEvent(Long eventId);
}
