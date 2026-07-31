package com.ufcpedia.event.controller;

import org.springframework.web.bind.annotation.RequestParam;
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
    public String events(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String status,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {

            model.addAttribute("events", eventService.searchEvents(keyword));

        } else if (status != null && !status.isBlank()) {

            model.addAttribute("events", eventService.getEventsByStatus(status));

        } else {

            model.addAttribute("events", eventService.getAllEvents());

        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("status", status);

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

    @GetMapping("/edit-event/{id}")
    public String editEvent(@PathVariable Long id, Model model) {

        model.addAttribute("event", eventService.getEvent(id));

        return "add-event";
    }

    @GetMapping("/delete-event/{id}")
    public String deleteEvent(@PathVariable Long id) {

        eventService.deleteEvent(id);

        return "redirect:/events";
    }
}