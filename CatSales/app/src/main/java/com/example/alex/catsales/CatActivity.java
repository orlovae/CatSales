package com.example.alex.catsales;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alex on 13.03.17.
 */

public class CatActivity extends Activity {
    private ImageView ivPhoto;
    private TextView tvName, tvBreed, tvDescription;
    private Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        initView();
    }

    private void initView() {

    }

}
