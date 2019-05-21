package com.example.hasannaseer.quranapp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aya_Surah_Helper {

    //static data
    static String[] surahNamesArray = {"Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal","Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal","Al-Fatihah", "Yunus", "Al-A’raf", "Al-Anfal"};
    static Integer[] surahLengthArray = {5, 25, 100, 158};

    static HashMap hashMap = null;

    //creates the HM with the surahnames and their appropriate length
    public static void createMap(){
        HashMap HM = new HashMap();
        for (int x =0; x < surahLengthArray.length; x++){
            HM.put(surahNamesArray[x], surahLengthArray[x]);
        }

        hashMap = HM;
    }

}
