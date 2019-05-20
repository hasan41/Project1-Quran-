package com.example.hasannaseer.quranapp2;


import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SurahLoader {

    String[] surahNamesArray = {"Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal"};
    Integer[] surahLengthArray = {5, 25, 100, 158};

    Map<String, Integer> surahNames = new HashMap<>();

    protected void populate(Context className, ConstraintLayout surahLayout){
        ConstraintLayout newLayout = surahLayout;


        for (int x =0; x < surahNamesArray.length; x++){
            surahNames.put(surahNamesArray[x], surahLengthArray[x]);
        }


        Set surahSet = surahNames.keySet();

        System.out.println(surahNames.keySet());

        for(Object x : surahSet) {

            TextView surahName = new TextView(className);
            surahName.setText(x.toString() + " has " + surahNames.get(x) + " Ayas");
            newLayout.addView(surahName);
        }

    }

}
