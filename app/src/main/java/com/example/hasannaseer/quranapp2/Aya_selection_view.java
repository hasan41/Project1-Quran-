package com.example.hasannaseer.quranapp2;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Aya_selection_view extends AppCompatActivity {


    //Instantiating variables
    Aya_Surah_Helper ASHelper = new Aya_Surah_Helper();
    ListView ayaList;
    String surahName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aya_selection_view);

        ayaList = findViewById(R.id.ayaSelectionList);
        Bundle myBundle = getIntent().getExtras();

        if (savedInstanceState == null) {
            if (myBundle == null) {
                surahName = null;
            } else {
                surahName = myBundle.getString("surahName");
            }
        }

        //Getting Dimensions
        DisplayMetrics DM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(DM);
        int height = DM.heightPixels;
        int width = DM.widthPixels;

        //resetting the size of the screen
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        int numOfAyas;

        if (ASHelper.hashMap == null) {
            ASHelper.createMap();
            numOfAyas = (int) ASHelper.hashMap.get(surahName);
        } else {
            numOfAyas = (int) ASHelper.hashMap.get(surahName);
        }

        //create new array with aya numbers
        ArrayList ayaArr = new ArrayList();
        for (int x = 1; x <= numOfAyas; x++) {
            ayaArr.add(x);
        }
            ArrayAdapter surahArray = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ayaArr);
            ayaList.setAdapter(surahArray);
        }




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("surahName", surahName);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        super.onRestart();
        surahName = (String) savedInstanceState.getSerializable("surahName");

    }
}
