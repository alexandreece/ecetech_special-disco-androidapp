package com.example.lama.lamapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;


public class EnterWord extends Activity {

    private ListView vue1;
    private ListView vue2;

    private EnterWordAdapter myAdapter;

    String[] equipe = new String[]{
            "Lamatraque", "Lamalédiction"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);

        vue1 = (ListView) findViewById(R.id.enter_word_list1);
        vue2 = (ListView) findViewById(R.id.enter_word_list2);

        ArrayList<Word> word = new ArrayList<Word>();
        Word W1 = new Word();
        Word W2 = new Word();

        word.add(W1);
        word.add(W2);

        /*
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(EnterWord.this,

                R.layout.enter_word1, equipe);
        vue1.setAdapter(adapter1);
        */
        myAdapter = new EnterWordAdapter(this,R.layout.enter_word1, word);
        vue1.setAdapter(myAdapter);
        vue2.setAdapter(myAdapter);

    }





}
