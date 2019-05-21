package com.example.hasannaseer.quranapp2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SurahSelectionView extends AppCompatActivity {


    //static data
    String[] surahNamesArray = {"Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal","Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal","Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal"};
    Integer[] surahLengthArray = {5, 25, 100, 158};

    ListView surahList;
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



        ArrayAdapter surahArray = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, surahNamesArray);
        surahList.setAdapter(surahArray);

    }



    //creates the HM with the surahnames and their appropriate length
    public Map createMap(ArrayList list1, ArrayList list2){
        HashMap HM = new HashMap();
        for (int x =0; x < list1.size(); x++){
            HM.put(surahNamesArray[x], surahLengthArray[x]);
        }

        return HM;
    }

}
