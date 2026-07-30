package com.ufcpedia.dashboard.controller;

import com.ufcpedia.fighter.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/")
    public String dashboard(Model model) {

        model.addAttribute("totalFighters", fighterService.getTotalFighters());

        model.addAttribute("champions", fighterService.getChampions());

        model.addAttribute("weightClasses", fighterService.getWeightClasses());

        model.addAttribute("eliteFighters", fighterService.getEliteFighters());

        return "dashboard";
    }

}