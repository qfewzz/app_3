package com.example.myapplication.Classes;

import java.util.Calendar;

public class Purchase {
    private int id;
    private Person who;
    private String title;
    private int price;
    private String date;
    private String desc;
    private boolean isPublic;



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public static final String
            KEY_ID = "purchase_id",
            KEY_WHO = "who",
            KEY_TITLE = "title",
            KEY_PRICE = "price",
            KEY_DATE = "date",
            KEY_DESC = "description",
            KEY_IS_PUBLIC = "is_public";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getWho() {
        return who;
    }

    public void setWho(Person who) {
        this.who = who;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

}