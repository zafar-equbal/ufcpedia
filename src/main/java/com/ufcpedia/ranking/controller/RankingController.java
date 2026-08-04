package com.ufcpedia.ranking.controller;

import com.ufcpedia.fighter.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingController {

    @Autowired
    FighterService fighterService;

    @GetMapping("/rankings")
    public String rankings(Model model){

        model.addAttribute("flyweights",
                fighterService.getRankings("Flyweight"));

        model.addAttribute("bantamweights",
                fighterService.getRankings("Bantamweight"));

        model.addAttribute("featherweights",
                fighterService.getRankings("Featherweight"));

        model.addAttribute(
                "lightweights",
                fighterService.getRankings("Lightweight"));

        model.addAttribute(
                "welterweights",
                fighterService.getRankings("Welterweight"));

        model.addAttribute(
                "middleweights",
                fighterService.getRankings("Middleweight"));

        model.addAttribute("lightheavyweights",
                fighterService.getRankings("Light Heavyweight"));

        model.addAttribute(
                "heavyweights",
                fighterService.getRankings("Heavyweight"));

        return "rankings";
    }

}