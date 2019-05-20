package com.example.hasannaseer.quranapp2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SurahSelectionView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_selection_view);


        ConstraintLayout myLay = findViewById(R.id.surahSelectionView);
        TextView myText = new TextView(this);
        myText.setWidth(300);
        myText.setHeight(50);
        myText.setText("now its good");
//        myText.setId(5);

        myLay.addView(myText);


        SurahLoader SL = new SurahLoader();
        SL.populate(this, myLay);
    }
}
