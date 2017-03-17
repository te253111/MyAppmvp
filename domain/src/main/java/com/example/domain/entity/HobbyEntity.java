package com.example.domain.entity;

import javax.inject.Singleton;

/**
 * Created by Zlink on 16/3/2560.
 */
public class HobbyEntity {
    String cook;
    String sport;
    String game;
    String watch;


    private static HobbyEntity instance = null;

    public static HobbyEntity getInstance() {
        if(instance == null) {
            instance = new HobbyEntity();
        }
        return instance;
    }

    public String getCook() {
        return cook;
    }

    public void setCook(String cook) {
        this.cook = cook;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }


}
