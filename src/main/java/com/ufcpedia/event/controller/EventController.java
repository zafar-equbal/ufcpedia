package com.ufcpedia.event.controller;

import com.ufcpedia.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ufcpedia.event.entity.Event;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public String events(Model model) {

        model.addAttribute("events", eventService.getAllEvents());

        return "events";
    }

    @GetMapping("/add-event")
    public String addEventPage(Model model) {

        model.addAttribute("event", new Event());

        return "add-event";
    }

    @PostMapping("/save-event")
    public String saveEvent(@ModelAttribute Event event) {

        eventService.saveEvent(event);

        return "redirect:/events";
    }

    @GetMapping("/event/{id}")
    public String eventDetails(@PathVariable Long id, Model model) {

        model.addAttribute("event", eventService.getEvent(id));

        return "event-details";
    }
}