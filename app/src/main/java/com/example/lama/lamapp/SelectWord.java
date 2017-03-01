package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Joueur;
import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;

public class SelectWord extends AppCompatActivity {

    ListView vue;
    private Game game;
    private int position;
    private ArrayList<String> wordList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        Intent intent = getIntent();
        //position = (int) intent.getSerializableExtra("position");
        position = intent.getIntExtra("position",100);
        DatabaseHandler db = new DatabaseHandler(this);
        final List<Word> words = db.getWordsList();
        db.close();

        vue = (ListView) findViewById(R.id.list);

        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            liste.add(mot.getWord());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,liste);
        vue.setAdapter(adapter);

        vue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                String selected = (String) vue.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
                Intent intent_next = new Intent(SelectWord.this, EnterWord.class);
                wordList.add(position,selected);
                intent_next.putExtra("wordlist", wordList);
                startActivity(intent_next);
            }
        });
    }
}