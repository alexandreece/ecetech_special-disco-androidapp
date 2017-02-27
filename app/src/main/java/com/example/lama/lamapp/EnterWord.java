package com.example.lama.lamapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnterWord extends Activity {

    private ListView vue1;
    private ListView vue2;
    private Game game;

    private EnterWordAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);
        Intent intent = getIntent();

        game = (Game) intent.getSerializableExtra("game");

        vue1 = (ListView) findViewById(R.id.enter_word_list1);
        vue2 = (ListView) findViewById(R.id.enter_word_list2);

        ArrayList<Word> word = new ArrayList<Word>();
        /*Word W1 = new Word();
        Word W2 = new Word();
        Word W3 = new Word();
        Word W4 = new Word();
        Word W5 = new Word();
        word.add(W1);
        word.add(W2);
        word.add(W3);
        word.add(W4);
        word.add(W5);*/
       // game.setNbPlayers(3);

        for(int i = 0; i<game.getNbPlayers();i++){

            Word W1 = new Word();
            Word W2 = new Word();

            word.add(W1);
            word.add(W2);
        }

        myAdapter = new EnterWordAdapter(this, R.layout.enter_word1, word);
        vue1.setAdapter(myAdapter);
        vue2.setAdapter(myAdapter);

    }

    public void precedent(View view) {
        Intent activityRandomWord = new Intent(EnterWord.this, SelectWord.class);
        startActivity(activityRandomWord);

    }

    public void dictionnaire(View view) {
        Intent activityRandomWord = new Intent(EnterWord.this, SelectRandomWord.class);
        startActivity(activityRandomWord);

    }

    public void aleatoire(View view) {
        EditText word = (EditText) findViewById(R.id.word);
        Random alea = new Random();
        DatabaseHandler db = new DatabaseHandler(this);
        List<Word> words = db.getWordsList();
        db.close();
        String ranMot = words.get(alea.nextInt(words.size())).getWord();
        word.setText(ranMot, TextView.BufferType.NORMAL);
        Toast.makeText(getApplicationContext(), ranMot, Toast.LENGTH_SHORT).show();
    }


}
