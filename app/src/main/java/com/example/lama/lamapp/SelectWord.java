package com.example.lama.lamapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import SQLite.DatabaseHandler;
import SQLite.PreviousWord;

public class SelectWord extends AppCompatActivity {

    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        DatabaseHandler db = new DatabaseHandler(this);

        vue = (ListView) findViewById(R.id.list);

        db.addPreviousWord(new PreviousWord("Brad Pitt"));
        db.addPreviousWord(new PreviousWord("The Rock"));
        db.addPreviousWord(new PreviousWord("Lombric"));

        List<PreviousWord> previousWords = db.getAllPreviousWords();


        List<String> liste = new ArrayList<String>();

        for (PreviousWord mot : previousWords){
            liste.add(mot.getPreviousWord());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);
        vue.setAdapter(adapter);

    }
}