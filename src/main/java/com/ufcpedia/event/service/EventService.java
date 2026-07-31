package com.ufcpedia.event.service;

import com.ufcpedia.event.entity.Event;
import com.ufcpedia.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufcpedia.event.entity.Event;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> searchEvents(String keyword) {

        return eventRepository
                .findByNameContainingIgnoreCaseOrLocationContainingIgnoreCaseOrCountryContainingIgnoreCaseOrMainEventContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                );
    }

    public List<Event> getEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    public Event getFeaturedEvent() {

        return eventRepository
                .findFirstByStatusOrderByEventDateAsc("Upcoming")
                .orElse(null);

    }

    public List<Event> getUpcomingEvents() {

        return eventRepository.findTop3ByStatusOrderByEventDateAsc("Upcoming");

    }
}