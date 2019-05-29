package com.example.hasannaseer.quranapp2;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SurahSelectionView extends AppCompatActivity {

    //Instantiating variables
    Aya_Surah_Helper ASHelper = new Aya_Surah_Helper();
    ListView surahList;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_selection_view);

        surahList = findViewById(R.id.surahSelectionList);

        //Getting Dimensions
        DisplayMetrics DM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(DM);
        int height = DM.heightPixels;
        int width = DM.widthPixels;

        //resetting the size of the screen
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        ctx = getApplication();



        ArrayAdapter surahArray = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ASHelper.surahNamesArray);
        surahList.setAdapter(surahArray);

        surahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(ctx, Aya_selection_view.class);
                //TODO send over surah name in myIntent.putExtra()
                myIntent.putExtra("surahName", ASHelper.surahNamesArray[position]);
                Log.d(ASHelper.surahNamesArray[position], "This item has been clicked: ");
                startActivity(myIntent);
            }
        });

    }




}
