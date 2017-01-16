package com.example.lama.lamapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import SQLite.DatabaseHandler;
import SQLite.Word;

public class SelectWord extends AppCompatActivity {

    ListView listeMots;
    List<Word> mots = new ArrayList<>();
    ArrayAdapter<String> adapter;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        listeMots = (ListView) findViewById(R.id.listViewSelectWord);

        mots = db.getWordsList();

        for (Word mot : mots) {
            adapter.add(mot.toString());
        }

        listeMots.setAdapter(adapter);

    }
}