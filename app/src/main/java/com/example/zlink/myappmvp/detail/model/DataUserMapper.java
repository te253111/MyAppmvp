package com.example.zlink.myappmvp.detail.model;

import com.example.domain.entity.DataUserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Zlink on 14/3/2560.
 */

public class DataUserMapper {

    @Inject
    public DataUserMapper(){

    }

    public List<DataUser> transform(List<DataUserEntity> entities) {
        List<DataUser> items = new ArrayList<>();
        if (entities == null) return items;

        for (DataUserEntity entity : entities) {
            DataUser item = transform(entity);
            if (item != null) items.add(item);
        }
        return items;
    }

    public DataUser transform(DataUserEntity entity) {
        DataUser item = null;
        if (entity != null) {
            item = new DataUser();
            item.setId(entity.getId());
            item.setName(entity.getName());
            item.setAge(entity.getAge());
            item.setDate(entity.getDate());
            item.setNo(entity.getNo());
            item.setState(entity.getState());
            item.setContry(entity.getContry());
        }
        return item;
    }
}