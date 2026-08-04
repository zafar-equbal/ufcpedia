package com.ufcpedia.fighter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.service.FighterService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

        @Autowired
        private FighterService fighterService;


    @GetMapping("/edit-fighter/{id}")
    public String editFighter(@PathVariable Long id, Model model) {

        Fighter fighter = fighterService.getFighterById(id);

        model.addAttribute("fighter", fighter);

        return "edit-fighter";
    }

    @GetMapping("/cards")
    public String cards(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.trim().isEmpty()) {
            model.addAttribute("fighters",
                    fighterService.searchFighters(keyword));
        } else {
            model.addAttribute("fighters",
                    fighterService.getAllFighters());
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("totalFighters",
                fighterService.getAllFighters().size());

        return "cards";
    }
}
