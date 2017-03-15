package com.example.alex.catsales.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alex.catsales.table.FakeCatTable;

/**
 * Created by alex on 15.03.17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DBFakeCat";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        FakeCatTable.createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
