package com.example.logginvalorant.Moduls;

import java.io.Serializable;

public class Map implements Serializable {
    private String name;

    public Map(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

