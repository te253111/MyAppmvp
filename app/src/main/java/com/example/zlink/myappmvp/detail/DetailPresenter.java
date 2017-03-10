package com.example.zlink.myappmvp.detail;

import com.example.zlink.myappmvp.detail.model.DataUser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Zlink on 9/3/2560.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private DetailContract.View view;

    @Inject
    public DetailPresenter() {

    }

    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getDataUser() {
        List<DataUser> userList = new ArrayList<>();
        userList.add(new DataUser("1", "john", "18", "2000-01-01"));
        userList.add(new DataUser("2", "red", "20", "2000-01-02"));
        userList.add(new DataUser("3", "mark", "26", "2000-03-01"));
        userList.add(new DataUser("4", "Ted", "53", "2000-01-02"));
        userList.add(new DataUser("5", "Brown", "11", "2000-01-04"));
        userList.add(new DataUser("6", "Hennry", "33", "2000-01-05"));
        userList.add(new DataUser("7", "tercy", "50", "2000-01-06"));
        userList.add(new DataUser("8", "Marco", "45", "2000-01-07"));
        userList.add(new DataUser("9", "Bruno", "33", "2000-01-08"));
        userList.add(new DataUser("10", "boy", "23", "2000-01-09"));
        userList.add(new DataUser("11", "joey", "24", "2000-01-10"));
        userList.add(new DataUser("12", "stephen", "60", "2000-06-01"));
        userList.add(new DataUser("13", "steve", "12", "2000-07-01"));
        userList.add(new DataUser("14", "alice", "19", "2000-09-01"));
        userList.add(new DataUser("15", "meena", "20", "2000-10-01"));
        userList.add(new DataUser("16", "brave", "29", "2000-11-01"));
        userList.add(new DataUser("17", "chaton", "28", "2000-12-01"));
        userList.add(new DataUser("18", "aloha", "31", "2000-02-022"));
        userList.add(new DataUser("19", "minny", "36", "2000-01-03"));
        userList.add(new DataUser("20", "toon", "55", "2000-01-22"));
        view.SetDataUser(userList);
    }
}
