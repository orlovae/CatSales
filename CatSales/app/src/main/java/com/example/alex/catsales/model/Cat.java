package com.example.alex.catsales.model;

/**
 * Created by alex on 13.03.17.
 */

public class Cat {
    private String uriPhoto, name, breed, description;
    private double latitude, longtude;
    private int telefon;

    public Cat(String uriPhoto, String name, String breed, String description,
               double latitude, double longtude, int telefon) {
        this.uriPhoto = uriPhoto;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.latitude = latitude;
        this.longtude = longtude;
        this.telefon = telefon;
    }

}
