package com.ufcpedia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fighters")
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String nickname;
    private String nationality;
    private String weightClass;

    private Integer wins;
    private Integer losses;
    private Integer draws;

    private String imageUrl;
    private String aboutUrl;

    public Fighter(){
    }

    public Fighter(Long id, String name , String nickname ,String nationality, String weightClass, Integer wins , Integer losses, Integer draws, String imageUrl, String aboutUrl) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.nationality = nationality;
        this.weightClass = weightClass;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.imageUrl = imageUrl;
        this.aboutUrl = aboutUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAboutUrl() {
        return aboutUrl;
    }

    public void setAboutUrl(String aboutUrl) {
        this.aboutUrl = aboutUrl;
    }
}

