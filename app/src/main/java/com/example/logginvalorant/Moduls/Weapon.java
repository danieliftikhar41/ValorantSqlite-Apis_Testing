package com.example.logginvalorant.Moduls;

import java.io.Serializable;

public class Weapon implements Serializable {
    private String name;
    private String type;
    private String cost;

    public Weapon(String nom, String type, String cost) {
        this.name = nom;
        this.type = type;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
