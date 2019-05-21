package com.example.hasannaseer.quranapp2;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton surahSelectionButton;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        surahSelectionButton = findViewById(R.id.imageButton3);
        ctx = getApplication();

        surahSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ctx, SurahSelectionView.class);
                startActivity(myIntent);
            }
        });



    }

//    public void selectSurah(View view){
//        Intent myIntent = new Intent(this, SurahSelectionView.class);
//        startActivity(myIntent);
//    }
}




