package com.example.lama.lamapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectWord extends AppCompatActivity {

    ListView listeMots;
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
        setContentView(R.layout.activity_select_word);

        listeMots = (ListView) findViewById(R.id.listViewSelectWord);
        dbAction();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SelectWord.this,android.R.layout.simple_list_item_1,mots);
        listeMots.setAdapter(adapter);


    }

}
