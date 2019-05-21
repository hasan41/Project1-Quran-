package com.example.hasannaseer.quranapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Aya_selection_view extends AppCompatActivity {


    //Instantiating variables
    Aya_Surah_Helper ASHelper = new Aya_Surah_Helper();
    ListView ayaList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aya_selection_view);

        ayaList = findViewById(R.id.ayaSelectionList);

        //Getting Dimensions
        DisplayMetrics DM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(DM);
        int height = DM.heightPixels;
        int width = DM.widthPixels;

        //resetting the size of the screen
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));


        ArrayAdapter surahArray = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ASHelper.surahLengthArray);
        ayaList.setAdapter(surahArray);
    }
}
