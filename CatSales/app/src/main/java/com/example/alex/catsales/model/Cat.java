package com.example.alex.catsales.model;

/**
 * Created by alex on 13.03.17.
 */

public class Cat {
    private int photo;
    private String name, breed, description;
    private double latitude, longtude;
    private String telefon;

    public Cat(int photo, String name, String breed, String description,
               double latitude, double longtude, String telefon) {
        this.photo = photo;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.latitude = latitude;
        this.longtude = longtude;
        this.telefon = telefon;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtude() {
        return longtude;
    }

    public String getTelefon() {
        return telefon;
    }
}
