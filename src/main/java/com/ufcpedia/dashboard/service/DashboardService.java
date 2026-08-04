package com.ufcpedia.dashboard.service;

import com.ufcpedia.event.entity.Event;
import com.ufcpedia.event.service.EventService;
import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.service.FighterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ufcpedia.news.entity.News;
import com.ufcpedia.news.service.NewsService;


import java.util.List;


@Service
public class DashboardService {

    @Autowired
    private EventService eventService;

    @Autowired
    private FighterService fighterService;

    @Autowired
    private NewsService newsService;

    public Event getFeaturedEvent() {
        return eventService.getFeaturedEvent();
    }

    public long getTotalFighters() {
        return fighterService.getTotalFighters();
    }

    public long getChampions() {
        return fighterService.getCurrentChampions().size();
    }

    public long getWeightClasses() {
        return fighterService.getWeightClasses();
    }



    public List<Event> getUpcomingEvents() {

        return eventService.getUpcomingEvents();

    }

    public List<Fighter> getChampionsList(){
        return fighterService.getChampionsList();
    }

    public List<Fighter> getLatestFighters() {

        return fighterService.getLatestFighters();

    }

    public List<News> getTopStories() {

        return newsService.getTopStories();

    }


}