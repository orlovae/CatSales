package com.example.alex.catsales.model;

/**
 * Created by alex on 13.03.17.
 */

public class Cat {
    private int ID;
    private String uriPhoto, name, breed, description;
    private double latitude, longtude;
    private String telefon;

    public final static String CAT = "com.example.alex.CatSales.CAT";

    public Cat(int ID, String uriPhoto, String name, String breed, String description,
               double latitude, double longtude, String telefon) {
        this.ID = ID;
        this.uriPhoto = uriPhoto;
        this.name = name;
        this.breed = breed;
        this.description = description;
        this.latitude = latitude;
        this.longtude = longtude;
        this.telefon = telefon;
    }

    public int getID() {
        return ID;
    }

    public String getUriPhoto() {
        return uriPhoto;
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
