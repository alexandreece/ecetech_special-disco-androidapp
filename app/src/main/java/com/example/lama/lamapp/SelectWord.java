package com.example.lama.lamapp;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.PreviousWord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectWord extends AppCompatActivity {

    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        DatabaseHandler db = new DatabaseHandler(this);


        try {

            db.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            db.openDataBase();

        }catch(SQLException sqle){

            throw sqle;

        }


        List<PreviousWord> previousWords = db.getAllPreviousWords();


        vue = (ListView) findViewById(R.id.list);


        List<String> liste = new ArrayList<String>();

        for (PreviousWord mot : previousWords){
            liste.add(mot.getPreviousWord());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);
        vue.setAdapter(adapter);

    }
}