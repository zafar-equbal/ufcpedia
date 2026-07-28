package com.ufcpedia.controller;

import com.ufcpedia.entity.Fighter;
import com.ufcpedia.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/fighters")
public class FighterController {

    @Autowired
    private FighterService fighterService;

    @GetMapping
    public List<Fighter> getAllFighters() {
        return fighterService.getAllFighters();
    }
// Get
    @GetMapping("/{id}")
    public Fighter getFighterById(@PathVariable Long id) {
        return fighterService.getFighterById(id);
    }
// Post
    @PostMapping
    public Fighter addFighter(@Valid @RequestBody Fighter fighter) {
        return fighterService.saveFighter(fighter);
    }
// Put
    @PutMapping("/{id}")
    public Fighter updateFighter(@PathVariable Long id,
                                 @Valid @RequestBody Fighter fighter) {
        return fighterService.updateFighter(id, fighter);
    }
// Delete
    @DeleteMapping("/{id}")
    public String deleteFighter(@PathVariable Long id) {
        fighterService.deleteFighter(id);
        return "Fighter deleted successfully";
    }
}