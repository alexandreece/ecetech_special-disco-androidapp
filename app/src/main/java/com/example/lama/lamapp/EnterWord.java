package com.example.lama.lamapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class EnterWord extends Activity {




    private ListView vue1;
    private ListView vue2;
    private TextView LabelNomEq1, LabelNomEq2;
    private Game game;
    private EditText word;
    private EnterWordAdapter adaptaterA;
    private EnterWordAdapter adaptaterB;

    private ArrayList<String> wordlistA;
    private ArrayList<String> wordlistB;
    private ArrayList<String> wordB = new ArrayList<>();
    private ArrayList<String> wordA = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);
        Intent intent = getIntent();

        game = (Game) intent.getSerializableExtra("game");

        int ab;
        if (intent.getSerializableExtra("wordlistA") != null || intent.getSerializableExtra("wordlistB") != null) {
            ab = (int) intent.getSerializableExtra("ab");
            wordA = (ArrayList<String>) intent.getSerializableExtra("wordlistA");
            wordB = (ArrayList<String>) intent.getSerializableExtra("wordlistB");
        } else {
            for (int i = 0; i < game.getNbPlayers(); i++) {
                String wA = "";
                String wB = "";
                wordA.add(wA);
                wordB.add(wB);
                saveWordNumber(i);
            }
        }
        LabelNomEq1 = (TextView) findViewById(R.id.NameEq1TextViewEnterWord);
        LabelNomEq2 = (TextView) findViewById(R.id.NameEq2TextViewEnterWord);
        LabelNomEq1.setText(game.getNameTeamA());
        LabelNomEq2.setText(game.getNameTeamB());



        vue1 = (ListView) findViewById(R.id.enter_word_list1);
        vue2 = (ListView) findViewById(R.id.enter_word_list2);


        adaptaterA = new EnterWordAdapter(this, R.layout.enter_word1, wordA,wordB, game, 1);
        adaptaterB = new EnterWordAdapter(this, R.layout.enter_word1, wordA,wordB, game, 2);
        vue1.setAdapter(adaptaterA);
        vue2.setAdapter(adaptaterB);

    }

    public void start(View v){
        ArrayList <String>  words = new ArrayList<>();
        words.addAll(adaptaterA.getList());
        Random random = new Random();
        Collections.shuffle(words,random);
        Log.i("START ", "start: "+ words.toString());
        game.setWords_List(words);
        game.setWords_Current_List();
        game.setCurrentRound(1);
        Intent next = new Intent(EnterWord.this, TestFragmentActivity.class);
        next.putExtra("game", game);
        startActivity(next);
    }

    private void saveWordNumber(int i){
        SharedPreferences sharedPreferences = getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.i("val", "A"+i);
        editor.putInt("A"+i,0);
        editor.putInt("B"+i,0);
        editor.apply();
    }
}