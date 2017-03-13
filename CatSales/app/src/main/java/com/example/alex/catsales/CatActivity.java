package com.example.alex.catsales;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alex on 13.03.17.
 */

public class CatActivity extends Activity implements View.OnClickListener {
    private ImageView ivPhoto;
    private TextView tvName, tvBreed, tvDescription;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        initView();
        setImageView();
        setTextView();
        buttonBehavior();
    }

    private void initView() {
        ivPhoto = (ImageView)findViewById(R.id.photo);
        tvName = (TextView)findViewById((R.id.name));
        tvBreed = (TextView)findViewById(R.id.breed);
        tvDescription = (TextView)findViewById(R.id.description);
        bCall = (Button)findViewById(R.id.call);
    }

    private void setImageView(){

    }

    private void setTextView(){
        
    }

    private void buttonBehavior(){
        bCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call:
                //здесь метод вызова звонка
                break;
        }
    }
}
