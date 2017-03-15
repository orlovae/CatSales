package com.example.alex.catsales;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alex.catsales.helper.DBHelper;
import com.example.alex.catsales.model.Cat;
import com.example.alex.catsales.model.FakeCatArray;
import com.example.alex.catsales.table.FakeCatTable;

import java.util.ArrayList;

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
        if (fakeCatArray == null){
            fakeCatArray = new FakeCatArray(context);
        }
    }
    public void initFakeCatTable(){
        db = dbHelper.getWritableDatabase();

        int photo;
        String name, breed, description;
        double latitude, longtude;
        String telefon;

        for (int i = 0; i < fakeCatArray.getName().size(); i++) {
            photo = fakeCatArray.getPhoto().get(i);
            name = fakeCatArray.getName().get(i);
            breed = fakeCatArray.getBreed().get(i);
            description = fakeCatArray.getDescription().get(i);
            latitude = fakeCatArray.getLatitude().get(i);
            longtude = fakeCatArray.getLongtude().get(i);
            telefon = fakeCatArray.getTelefon().get(i);

            ContentValues cV = new ContentValues();
            cV.put(FakeCatTable.COLUMN_PHOTO, photo);
            cV.put(FakeCatTable.COLUMN_NAME, name);
            cV.put(FakeCatTable.COLUMN_BREED, breed);
            cV.put(FakeCatTable.COLUMN_DESCRIPTION, description);
            cV.put(FakeCatTable.COLUMN_LATITUDE, latitude);
            cV.put(FakeCatTable.COLUMN_LONGTUDE, longtude);
            cV.put(FakeCatTable.COLUMN_TELEFON, telefon);

            db.insert(FakeCatTable.TABLE_NAME, null, cV);
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
}
