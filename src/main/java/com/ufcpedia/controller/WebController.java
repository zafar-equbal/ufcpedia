package com.ufcpedia.controller;

import com.ufcpedia.entity.Fighter;
import com.ufcpedia.service.FighterService;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WebController {

    @Autowired
    private FighterService fighterService;

    @GetMapping("/fighters-page")
    public String fightersPage(Model model) {

        model.addAttribute("fighters",
                fighterService.getAllFighters());

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