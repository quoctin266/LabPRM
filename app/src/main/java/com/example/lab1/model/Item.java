package com.example.lab1.model;

public class Item {
    private int picture;
    private String title;

    Item(int picture, String title) {
        this.picture = picture;
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    int getPicture() {
        return picture;
    }
}
