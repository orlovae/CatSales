package com.example.alex.catsales;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.alex.catsales.helper.DBHelper;
import com.example.alex.catsales.model.Cat;
import com.example.alex.catsales.model.FakeCatArray;
import com.example.alex.catsales.table.FakeCatTable;

import java.util.ArrayList;
import java.util.Date;

import static com.example.alex.catsales.CatActivity.TAG;

/**
 * Created by alex on 15.03.17.
 */

public class MyApp extends Application {
    private FakeCatArray fakeCatArray;
    private ArrayList<Cat> fakeListCat;
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    final Context context = this;

    public ArrayList<Cat> getFakeListCat() {
        return fakeListCat;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initDBHelper();

        initFakeCatArray();

        initFakeCatTable();

        initfakeListCat();
    }

    private void initDBHelper(){
        dbHelper = new DBHelper(this);
    }

    private void initFakeCatArray(){
        Log.i(TAG, "Start initDB");
        if (fakeCatArray == null){
            fakeCatArray = new FakeCatArray(context);
        }
    }
    public void initFakeCatTable(){
        db = dbHelper.getWritableDatabase();

        int ID, photo;
        String name, breed, description;
        double latitude, longtude;
        String telefon;

        for (int i = 0; i < fakeCatArray.getName().size(); i++) {
            ID = i;
            photo = fakeCatArray.getPhoto().get(i);
            name = fakeCatArray.getName().get(i);
            breed = fakeCatArray.getBreed().get(i);
            description = fakeCatArray.getDescription().get(i);
            latitude = fakeCatArray.getLatitude().get(i);
            longtude = fakeCatArray.getLongtude().get(i);
            telefon = fakeCatArray.getTelefon().get(i);

            ContentValues cV = new ContentValues();
            cV.put(FakeCatTable.COLUMN_ID, i);
            cV.put(FakeCatTable.COLUMN_PHOTO, photo);
            cV.put(FakeCatTable.COLUMN_NAME, name);
            cV.put(FakeCatTable.COLUMN_BREED, breed);
            cV.put(FakeCatTable.COLUMN_DESCRIPTION, description);
            cV.put(FakeCatTable.COLUMN_LATITUDE, latitude);
            cV.put(FakeCatTable.COLUMN_LONGTUDE, longtude);
            cV.put(FakeCatTable.COLUMN_TELEFON, telefon);
            long rowID = db.insert(FakeCatTable.TABLE_NAME, null, cV);
        }
        dbHelper.close();
    }

    private void initfakeListCat(){
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(FakeCatTable.TABLE_NAME, null, null, null, null, null, null);

        fakeListCat = FakeCatTable.getResultFromCursor(cursor);

        if(cursor != null) cursor.close();
        dbHelper.close();
    }



//    private ArrayList<Cat> fabriceCat(FakeCatArray db){
//        Log.i(TAG, "Start fabriceCat");
//        if(fakeListCat == null) {
//            fakeListCat = new ArrayList<Cat>();
//        }
//
//        int ID;
//        String uriPhoto, name, breed, description;
//        double latitude, longtude;
//        String telefon;
//
//        for (int i = 0; i < db.getName().size(); i++) {
//            ID = i;
//            uriPhoto = "";
//            name = db.getName().get(i);
//            breed = db.getBreed().get(i);
//            description = db.getDescription().get(i);
//            latitude = db.getLatitude().get(i);
//            longtude = db.getLongtude().get(i);
//            telefon = db.getTelefon().get(i);
//
//            Cat cat = new Cat(ID, uriPhoto, name, breed, description, latitude, longtude, telefon);
//            fakeListCat.add(cat);
//        }
//
//        return fakeListCat;
//    }
}
