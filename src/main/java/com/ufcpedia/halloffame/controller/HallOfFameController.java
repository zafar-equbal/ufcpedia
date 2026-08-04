package com.ufcpedia.halloffame.controller;

import com.ufcpedia.fighter.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HallOfFameController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/hall-of-fame")
    public String hallOfFame(Model model){

        model.addAttribute(
                "legends",
                fighterService.getHallOfFame()
        );

        return "hall-of-fame";
    }

}