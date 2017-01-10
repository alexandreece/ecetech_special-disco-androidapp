package com.example.lama.lamapp;

import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SelectWordDictionaire extends AppCompatActivity {

    ListView CatList;
    SQLiteDatabase db = SQLiteDatabase.openDatabase("",null,SQLiteDatabase.CONFLICT_NONE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word_dictionaire);

        CatList = (ListView) findViewById(R.id.CatList);
    }
}
