package com.ufcpedia.event.repository;

import com.ufcpedia.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}