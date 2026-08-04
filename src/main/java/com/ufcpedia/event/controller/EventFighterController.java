package com.ufcpedia.event.controller;

import com.ufcpedia.event.entity.Event;
import com.ufcpedia.event.service.EventService;
import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EventFighterController {

    @Autowired
    private EventService eventService;

    @Autowired
    private FighterService fighterService;

    @GetMapping("/event/{id}/fighters")
    public String eventFighters(@PathVariable Long id, Model model) {

        Event event = eventService.getEvent(id);

        List<Fighter> fighters =
                fighterService.getMainEventFighters(event.getMainEvent());

        model.addAttribute("event", event);
        model.addAttribute("fighters", fighters);

        return "event-fighters";
    }
}