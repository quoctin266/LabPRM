package com.example.lab1.custom;

import android.app.Application;

public class MyApplication extends Application {
    private String food;

    private String drink;

    public String getFood() {return food;}
    public void setFood(String food) {this.food = food;}

    public String getDrink() {return drink;}
    public void setDrink(String drink) {this.drink = drink;}
}
