package com.example.alex.catsales.model;

/**
 * Created by alex on 13.03.17.
 */

public class Cat {
    private String uriPhoto, name, breed, description;

    public Cat(String uriPhoto, String name, String breed, String description) {
        this.uriPhoto = uriPhoto;
        this.name = name;
        this.breed = breed;
        this.description = description;
    }
}
