package com.example.hasannaseer.quranapp2;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Select extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.read);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);


        int w= dm.widthPixels;
        int h= dm.heightPixels;

        getWindow().setLayout((int) (w*0.5),(int) (h*0.4));


    }
}
