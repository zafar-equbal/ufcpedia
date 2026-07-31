package com.ufcpedia.dashboard.controller;
import com.ufcpedia.fighter.service.FighterService;
import com.ufcpedia.dashboard.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @GetMapping("/")
    public String dashboard(Model model) {

        // ================= Featured Event =================

        model.addAttribute("featuredEvent",
                dashboardService.getFeaturedEvent());

        //=================upcoming=========================
        model.addAttribute("upcomingEvents",
                dashboardService.getUpcomingEvents());

        // ================= Statistics =================

        model.addAttribute("totalFighters",
                dashboardService.getTotalFighters());

        model.addAttribute("champions",
                dashboardService.getChampions());

        model.addAttribute("weightClasses",
                dashboardService.getWeightClasses());

        model.addAttribute("eliteFighters",
                dashboardService.getEliteFighters());


        model.addAttribute("championsList",
                dashboardService.getChampionsList());

        model.addAttribute("latestFighters",
                dashboardService.getLatestFighters());

        return "dashboard";
    }

}