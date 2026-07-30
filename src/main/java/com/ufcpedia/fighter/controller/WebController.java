package com.ufcpedia.fighter.controller;

import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.service.FighterService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/fighters-page")
    public String fightersPage(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isBlank()) {
            model.addAttribute("fighters", fighterService.searchFighters(keyword));
        } else {
            model.addAttribute("fighters", fighterService.getAllFighters());
        }

        model.addAttribute("keyword", keyword);

        return "fighters";
    }
    @GetMapping("/add-fighter")
    public String addFighterPage(Model model){
        model.addAttribute("fighter", new Fighter());
        return "add-fighter";
    }

    @PostMapping("/save-fighter")
    public String saveFighter(@ModelAttribute Fighter fighter) {

        fighterService.saveFighter(fighter);

        return "redirect:/fighters-page";
    }

    @GetMapping("/delete-fighter/{id}")
    public String deleteFighter(@PathVariable Long id) {

        fighterService.deleteFighter(id);

        return "redirect:/fighters-page";
    }

}