package com.example.hasannaseer.quranapp2;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout myLay = (LinearLayout) findViewById(R.id.surahSelection);
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




