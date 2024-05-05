package com.example.com_rucinski.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String time;

    @Column
    private Boolean approved = false;

    public Event() {
        // Default constructor
    }

    public Event(String location, LocalDate date, String time) {
        this.location = location;
        this.date = date;
        this.time = time;
    }

    // Getters and setters

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId) &&
                Objects.equals(location, event.location) &&
                Objects.equals(date, event.date) &&
                Objects.equals(time, event.time) &&
                Objects.equals(approved, event.approved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, location, date, time, approved);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", approved=" + approved +
                '}';
    }
}
