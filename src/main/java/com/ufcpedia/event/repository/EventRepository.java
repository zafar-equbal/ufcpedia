package com.ufcpedia.event.repository;

import com.ufcpedia.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCaseOrCountryContainingIgnoreCaseOrMainEventContainingIgnoreCase(
            String name,
            String location,
            String country,
            String mainEvent
    );
    List<Event> findByStatus(String status);
    Optional<Event> findFirstByStatusOrderByEventDateAsc(String status);

    List<Event> findTop3ByStatusOrderByEventDateAsc(String status);
}