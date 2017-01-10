package com.example.lama.lamapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectWordDictionaire extends AppCompatActivity {

    ListView CatList;
    SQLiteDatabase db = SQLiteDatabase.openDatabase("bdd/LAMapp.db",null,SQLiteDatabase.CONFLICT_NONE);
    ArrayList<String> mots = new ArrayList<String>();

    void dbAction(){
        Cursor resultSet = db.rawQuery("select * from WordsList order by category",null);
        resultSet.moveToFirst();
        if (resultSet.moveToNext()){
            mots.add(resultSet.getString(3));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word_dictionaire);

        CatList = (ListView) findViewById(R.id.CatList);
        dbAction();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectWordDictionaire.this,android.R.layout.simple_list_item_1,mots);
        CatList.setAdapter(adapter);
    }
}
