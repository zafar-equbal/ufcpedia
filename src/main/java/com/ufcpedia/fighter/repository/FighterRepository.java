package com.ufcpedia.fighter.repository;

import com.ufcpedia.fighter.entity.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {

    List<Fighter> findByNameContainingIgnoreCaseOrNicknameContainingIgnoreCaseOrNationalityContainingIgnoreCaseOrWeightClassContainingIgnoreCase(
            String name,
            String nickname,
            String nationality,
            String weightClass
    );

    long count();

    long countByTitleIsNotNull();

    @Query("SELECT COUNT(DISTINCT f.weightClass) FROM Fighter f")
    long countDistinctWeightClasses();

    long countByWinsGreaterThanEqual(int wins);

    List<Fighter> findByTitleIsNotNull();

    List<Fighter> findTop4ByOrderByIdDesc();

    List<Fighter> findByNameContainingIgnoreCaseOrNameContainingIgnoreCase(
            String fighter1,
            String fighter2
    );
    List<Fighter> findByWeightClassOrderByWinsDesc(String weightClass);

    List<Fighter> findByCurrentChampionTrue();

    List<Fighter> findByHallOfFameTrueOrderByHallOfFameYearDesc();

    List<Fighter> findByWeightClassAndCurrentChampionTrue(String weightClass);
}