package com.ufcpedia.service;

import com.ufcpedia.entity.Fighter;
import com.ufcpedia.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    @Autowired
    private FighterRepository fighterRepository;

    public List<Fighter> getAllFighters() {
        return fighterRepository.findAll();
    }

    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public Fighter getFighterById(Long id) {
        return fighterRepository.findById(id).orElse(null);
    }

    public void deleteFighter(Long id) {
        fighterRepository.deleteById(id);
    }

    public Fighter updateFighter(Long id, Fighter updatedFighter) {
        Fighter fighter = fighterRepository.findById(id).orElse(null);

        if (fighter != null) {
            fighter.setName(updatedFighter.getName());
            fighter.setNickname(updatedFighter.getNickname());
            fighter.setNationality(updatedFighter.getNationality());
            fighter.setWeightClass(updatedFighter.getWeightClass());
            fighter.setWins(updatedFighter.getWins());
            fighter.setLosses(updatedFighter.getLosses());
            fighter.setDraws(updatedFighter.getDraws());
            fighter.setImageUrl(updatedFighter.getImageUrl());
            fighter.setAboutUrl(updatedFighter.getAboutUrl());

            return fighterRepository.save(fighter);
        }

        return null;
    }
}