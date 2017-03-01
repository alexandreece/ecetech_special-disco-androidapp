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
    private int pos;
    private ArrayList<String> wordList;
    private Game game;
    private int ab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        //get data (int position, ArrayList<String> list) from enterWord adapter
        final Intent intent = getIntent();
        pos = (int) intent.getIntExtra("position", pos);
        ab = (int) intent.getSerializableExtra("ab");
        wordList = (ArrayList<String>) intent.getSerializableExtra("list");
        game = (Game) intent.getSerializableExtra("game");

        //get word from DB
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


        //click listener
        vue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {


                String selected = (String) vue.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();

                Intent intent_next = new Intent(SelectWord.this, EnterWord.class);
                Log.i("SELECTED", "onItemClick: "+ selected);

                wordList.add(pos,selected);
                Log.i("WORDLIST", "onItemClick: "+wordList.toString());
                intent_next.putExtra("wordlist", wordList);
                intent_next.putExtra("game", game);
                intent_next.putExtra("ab",ab);
                startActivity(intent_next);
            }
        });
    }
}