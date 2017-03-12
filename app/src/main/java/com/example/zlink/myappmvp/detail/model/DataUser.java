package com.example.zlink.myappmvp.detail.model;

import org.parceler.Parcel;

/**
 * Created by Zlink on 9/3/2560.
 */
@Parcel
public class DataUser {
    private String id;
    private String name;
    private String age;
    private String date;

    private String no;
    private String state;
    private String contry;

    public DataUser( /* Parcel Required empty bean constructor */ ){}

    public DataUser(String id,String name,String age,String date,String no,String state,String contry){
        this.id=id;
        this.name=name;
        this.age=age;
        this.date=date;
        this.no = no;
        this.state = state;
        this.contry = contry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }
}
