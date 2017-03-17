package com.example.zlink.myappmvp.add.model;

import org.parceler.Parcel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Zlink on 14/3/2560.
 */
public class Hobby{
    String cook;
    String sport;
    String game;
    String watch;

    public Hobby(){}

    public Hobby(String cook,String sport,String game,String watch){
        this.cook = cook;
        this.sport = sport;
        this.game = game;
        this.watch = watch;
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
