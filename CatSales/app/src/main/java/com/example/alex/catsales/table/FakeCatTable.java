package com.example.alex.catsales.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.alex.catsales.model.Cat;

import java.util.ArrayList;

/**
 * Created by alex on 15.03.17.
 */

public class FakeCatTable {
    public static final String TABLE_NAME = "FakeCats";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_URI_PHOTO = "uriPhoto";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BREED = "breed";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGTUDE = "longtude";
    public static final String COLUMN_TELEFON = "telefon";

    public static void createTable(SQLiteDatabase database){
        database.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " integer primary key autoincrement,"
                + COLUMN_URI_PHOTO + " text,"
                + COLUMN_NAME + " text,"
                + COLUMN_BREED + " text,"
                + COLUMN_DESCRIPTION + " text,"
                + COLUMN_LATITUDE + " integer,"
                + COLUMN_LONGTUDE + " integer,"
                + COLUMN_TELEFON + " text);");
    }

    public static ArrayList<Cat> getResultFromCursor(Cursor cursor){
        ArrayList<Cat> fakeListArray = null;

        if (cursor != null && cursor.moveToFirst()){

            fakeListArray = new ArrayList<>();

            int idColIndex = cursor.getColumnIndex(COLUMN_ID);
            int uriPhotoColIndex = cursor.getColumnIndex(COLUMN_URI_PHOTO);
            int nameColIndex = cursor.getColumnIndex(COLUMN_NAME);
            int breedColIndex = cursor.getColumnIndex(COLUMN_BREED);
            int descriptionColIndex = cursor.getColumnIndex(COLUMN_DESCRIPTION);
            int latitudeColIndex = cursor.getColumnIndex(COLUMN_LATITUDE);
            int longtudeColIndex = cursor.getColumnIndex(COLUMN_LONGTUDE);
            int telefonColIndex = cursor.getColumnIndex(COLUMN_TELEFON);

            do {
                int id = cursor.getInt(idColIndex);
                String uriPhoto = cursor.getString(uriPhotoColIndex);
                String name = cursor.getString(nameColIndex);
                String breed = cursor.getString(breedColIndex);
                String description = cursor.getString(descriptionColIndex);
                double latitude = cursor.getDouble(latitudeColIndex);
                double longtude = cursor.getDouble(longtudeColIndex);
                String telefon = cursor.getString(telefonColIndex);

                Cat cat = new Cat(id, uriPhoto, name, breed, description,
                        latitude, longtude, telefon);
                fakeListArray.add(cat);
            } while (cursor.moveToNext());
        }
        if (cursor != null) cursor.close();

        return fakeListArray;
    }
}
