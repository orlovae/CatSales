package com.example.alex.catsales;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.catsales.model.Cat;

import java.util.ArrayList;

import static com.example.alex.catsales.MainActivity.CAT_NAME;

/**
 * Created by alex on 13.03.17.
 */

public class CatActivity extends Activity implements View.OnClickListener {
    private Cat cat = null;
    private String catName;
    private ArrayList<Cat> fakeListCat;

    private ImageView imageViewPhoto;
    private TextView tvName, tvBreed, tvDescription;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        initIntent();
        initFabricCat();
        setActualCat(catName);
        initView();
        setImageView();
        setTextView();
        buttonBehavior();
    }

    private void initIntent(){
        catName = getIntent().getExtras().getString(CAT_NAME);
    }

    private void initView() {
        imageViewPhoto = (ImageView)findViewById(R.id.photo);
        tvName = (TextView)findViewById((R.id.name));
        tvBreed = (TextView)findViewById(R.id.breed);
        tvDescription = (TextView)findViewById(R.id.description);
        bCall = (Button)findViewById(R.id.call);
    }

    private void setImageView(){
        imageViewPhoto.setImageResource(cat.getPhoto());
    }

    private void setTextView(){
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
        if (cat != null){
        String telefon = "tel:" + cat.getTelefon();
        Intent intentCalling = new Intent(Intent.ACTION_DIAL);
        intentCalling.setData(Uri.parse(telefon));
        startActivity(intentCalling);
        } else try {throw new NullPointerException("Cat == null!");
        }catch (NullPointerException e){
                e.printStackTrace();
        }
    }

    private void setActualCat(String name){
        for (Cat item:fakeListCat
             ) {
            if (item.getName().equals(name)){
                cat = item;
            }
        }
    }

    private void initFabricCat(){
        if(fakeListCat == null) {
            fakeListCat = new ArrayList<Cat>();
        }

        MyApp app = ((MyApp)getApplicationContext());
        fakeListCat = app.getFakeListCat();
    }
}
