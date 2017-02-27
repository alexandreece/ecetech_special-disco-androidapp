package com.example.lama.lamapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;


public class EnterWord extends Activity {

    private ListView vue1;
    private ListView vue2;
    private Game game;

    private EnterWordAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        game = (Game) intent.getSerializableExtra("game");

        setContentView(R.layout.activity_enter_word);

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

        for(int i =0; i<game.getNbPlayers();i++){
            Word W1 = new Word();
            Word W2 = new Word();

            word.add(W1);
            word.add(W2);
        }

        myAdapter = new EnterWordAdapter(this,R.layout.enter_word1, word);
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


}
