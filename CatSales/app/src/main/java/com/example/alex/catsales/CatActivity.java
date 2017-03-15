package com.example.alex.catsales;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.catsales.model.Cat;
import com.example.alex.catsales.model.FakeCatArray;

import java.util.ArrayList;

import static com.example.alex.catsales.MainActivity.CAT_NAME;

/**
 * Created by alex on 13.03.17.
 */

public class CatActivity extends Activity implements View.OnClickListener {
    private static final int CHANGE_DATE = 1;
    public static final String TAG = "MyApp";

    private Cat cat = null;
    private String catName;
    private FakeCatArray db;
    private ArrayList<Cat> fakeListCat;

    private ImageView ivPhoto;
    private TextView tvName, tvBreed, tvDescription;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Start onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        initIntent();
        fabriceCat(initDB());
        setActualCat(catName);
        initView();
        setImageView();
        setTextView();
        buttonBehavior();
    }

    private void initIntent(){
        catName = getIntent().getExtras().getString(CAT_NAME);
        Log.i(TAG, "catName = " + catName);
    }

    private void initView() {
        Log.i(TAG, "Start initView");
        ivPhoto = (ImageView)findViewById(R.id.photo);
        tvName = (TextView)findViewById((R.id.name));
        tvBreed = (TextView)findViewById(R.id.breed);
        tvDescription = (TextView)findViewById(R.id.description);
        bCall = (Button)findViewById(R.id.call);
    }

    private void setImageView(){
        Log.i(TAG, "Start setImageView");

    }

    private void setTextView(){
        Log.i(TAG, "Start setTextView");
        tvName.setText(cat.getName());
        tvBreed.setText(cat.getBreed());
        tvDescription.setText(cat.getDescription());

    }

    private void buttonBehavior(){
        bCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call:
                call();
                break;
        }
    }

    private void call(){
        //Здесь нужен try catch
        if (cat != null){
        String telefon = "tel:" + cat.getTelefon();
        Intent intentCalling = new Intent(Intent.ACTION_DIAL);
        intentCalling.setData(Uri.parse(telefon));
        startActivity(intentCalling);
        }
    }

    private void setActualCat(String name){
        Log.i(TAG, "Start setActualCat");
        for (Cat item:fakeListCat
             ) {
            if (item.getName().equals(name)){
                cat = item;
            }
        }
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
