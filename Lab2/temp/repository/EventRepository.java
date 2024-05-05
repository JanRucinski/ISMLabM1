package com.example.com_rucinski.repository;

import com.example.com_rucinski.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}