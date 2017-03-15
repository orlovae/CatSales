package com.example.alex.catsales;

import android.app.Application;
import android.util.Log;

import com.example.alex.catsales.model.Cat;
import com.example.alex.catsales.model.FakeCatArray;

import java.util.ArrayList;

import static com.example.alex.catsales.CatActivity.TAG;

/**
 * Created by alex on 15.03.17.
 */

public class MyApp extends Application {
    private FakeCatArray db;
    private ArrayList<Cat> fakeListCat;

    public ArrayList<Cat> getFakeListCat() {
        return fakeListCat;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        fabriceCat(initDB());
    }

    private FakeCatArray initDB(){
        Log.i(TAG, "Start initDB");
        if (db == null){
            db = new FakeCatArray();
            return db;
        }
        return db;
    }

    private ArrayList<Cat> fabriceCat(FakeCatArray db){
        Log.i(TAG, "Start fabriceCat");
        if(fakeListCat == null) {
            fakeListCat = new ArrayList<Cat>();
        }

        int ID;
        String uriPhoto, name, breed, description;
        double latitude, longtude;
        String telefon;

        for (int i = 0; i < db.getName().size(); i++) {
            ID = i;
            uriPhoto = "";
            name = db.getName().get(i);
            breed = db.getBreed().get(i);
            description = db.getDescription().get(i);
            latitude = db.getLatitude().get(i);
            longtude = db.getLongtude().get(i);
            telefon = db.getTelefon().get(i);

            Cat cat = new Cat(ID, uriPhoto, name, breed, description, latitude, longtude, telefon);
            fakeListCat.add(cat);
        }

        return fakeListCat;
    }
}
