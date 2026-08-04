package com.ufcpedia.fighter.controller;

import org.springframework.web.bind.annotation.RequestParam;
import com.ufcpedia.fighter.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FighterPageController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/fighter/{id}")
    public String fighterProfile(@PathVariable Long id,
                                 Model model) {

        model.addAttribute(
                "fighter",
                fighterService.getFighterById(id)
        );

        return "fighter-profile";
    }

    @GetMapping("/fighters-page")
    public String fightersPage(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {

            model.addAttribute(
                    "fighters",
                    fighterService.searchFighters(keyword)
            );

            model.addAttribute("keyword", keyword);

        } else {

            model.addAttribute(
                    "fighters",
                    fighterService.getAllFighters()
            );
        }

        return "fighters";
    }
}