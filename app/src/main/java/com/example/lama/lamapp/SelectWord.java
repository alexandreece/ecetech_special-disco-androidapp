package com.example.lama.lamapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectWord extends AppCompatActivity {

    ListView listeMots;
    ArrayList<String> mots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        listeMots = (ListView) findViewById(R.id.listViewSelectWord);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(SelectWord.this,android.R.layout.simple_list_item_1,mots);
        listeMots.setAdapter(adapter);
    }
}