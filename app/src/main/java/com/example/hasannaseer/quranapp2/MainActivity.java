package com.example.hasannaseer.quranapp2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton surahSelectionButton;
    ImageButton ayaSelectionButton;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ctx = getApplication();
        Intent myIntent = new Intent(ctx, RegisterActivity.class);
        startActivity(myIntent);


//        surahSelectionButton = findViewById(R.id.imageButton3);
//        ayaSelectionButton = findViewById(R.id.imageButton4);
//
//        surahSelectionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(ctx, RegisterActivity.class);
//                startActivity(myIntent);
//            }
//        });
//
//
//        ayaSelectionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(ctx, Aya_selection_view.class);
//                //TODO send over surah name in myIntent.putExtra()
//                startActivity(myIntent);
//            }
//        });


    }

}




