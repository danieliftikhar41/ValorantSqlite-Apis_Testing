package com.example.logginvalorant.Moduls;

public class Weapon {
    private String nom;
    private String details;
    public Weapon(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDtl() {
        return details;
    }

    public void setDtl(String details) {
        this.details = details;
    }
}
