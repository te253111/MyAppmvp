package com.example.zlink.myappmvp.add.model;

import com.example.domain.entity.HobbyEntity;
import com.example.zlink.myappmvp.detail.model.DataUser;

import javax.inject.Inject;

/**
 * Created by Zlink on 16/3/2560.
 */

public class HobbyMapper {

    @Inject
    public HobbyMapper(){}

    public Hobby transform(HobbyEntity entity) {
        Hobby item = null;
        if (entity != null) {
            item = new Hobby();
            item.setCook(entity.getCook());
            item.setSport(entity.getSport());
            item.setWatch(entity.getWatch());
            item.setGame(entity.getGame());
        }
        return item;
    }
}
