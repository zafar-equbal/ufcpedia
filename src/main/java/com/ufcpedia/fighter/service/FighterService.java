package com.ufcpedia.fighter.service;

import com.ufcpedia.fighter.entity.Fighter;
import com.ufcpedia.fighter.repository.FighterRepository;
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
            fighter.setHallOfFame(updatedFighter.getHallOfFame());
            fighter.setHallOfFameYear(updatedFighter.getHallOfFameYear());
            fighter.setRetired(updatedFighter.getRetired());

            return fighterRepository.save(fighter);
        }

        return null;
    }

    public List<Fighter> searchFighters(String keyword) {

        return fighterRepository
                .findByNameContainingIgnoreCaseOrNicknameContainingIgnoreCaseOrNationalityContainingIgnoreCaseOrWeightClassContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                );
    }

    public long getTotalFighters() {
        return fighterRepository.count();
    }

    public long getChampions() {
        return fighterRepository.findByCurrentChampionTrue().size();
    }

    public long getWeightClasses() {
        return fighterRepository.countDistinctWeightClasses();
    }

    public long getEliteFighters() {
        return fighterRepository.countByWinsGreaterThanEqual(20);
    }

    public List<Fighter> getChampionsList() {
        return fighterRepository.findByCurrentChampionTrue();
    }

    public List<Fighter> getLatestFighters() {

        return fighterRepository.findTop4ByOrderByIdDesc();

    }

    public List<Fighter> getMainEventFighters(String mainEvent) {

        String[] names = mainEvent.split("(?i)vs");

        String fighter1 = names[0].trim();
        String fighter2 = names[1].trim();

        return fighterRepository.findByNameContainingIgnoreCaseOrNameContainingIgnoreCase(
                fighter1,
                fighter2
        );
    }

    public List<Fighter> getRankings(String weightClass) {

        return fighterRepository.findByWeightClassAndCurrentChampionTrue(weightClass);
    }

    public List<Fighter> getHallOfFame() {

        return fighterRepository
                .findByHallOfFameTrueOrderByHallOfFameYearDesc();

    }

    public List<Fighter> getCurrentChampions() {
        return fighterRepository.findByCurrentChampionTrue();
    }
}