package com.ufcpedia.dashboard.service;

import com.ufcpedia.event.entity.Event;
import com.ufcpedia.event.service.EventService;
import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.service.FighterService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class DashboardService {

    @Autowired
    private EventService eventService;

    @Autowired
    private FighterService fighterService;

    public Event getFeaturedEvent() {
        return eventService.getFeaturedEvent();
    }

    public long getTotalFighters() {
        return fighterService.getTotalFighters();
    }

    public long getChampions() {
        return fighterService.getChampions();
    }

    public long getWeightClasses() {
        return fighterService.getWeightClasses();
    }

    public long getEliteFighters() {
        return fighterService.getEliteFighters();
    }


    public List<Event> getUpcomingEvents() {

        return eventService.getUpcomingEvents();

    }

    public List<Fighter> getChampionList(){
        return fighterService.getChampionsList();
    }

    public List<Fighter> getLatestFighters() {

        return fighterService.getLatestFighters();

    }


}