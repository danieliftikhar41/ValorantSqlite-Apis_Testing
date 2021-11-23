package com.example.logginvalorant.Moduls;

import java.io.Serializable;

public class Agent implements Serializable {
    private String name;

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
