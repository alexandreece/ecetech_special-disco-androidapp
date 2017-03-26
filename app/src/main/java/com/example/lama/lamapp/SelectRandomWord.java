package com.example.lama.lamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectRandomWord extends AppCompatActivity {

    List<Word> words;
    Random alea = new Random();

    private int pos;
    private int position;
    private ArrayList<String> wordList;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_random_word);
        //get data (int position, ArrayList<String> list) from enterWord adapter
        final Intent intent = getIntent();
        pos = (int) intent.getIntExtra("pos",0);
        position = (int) intent.getIntExtra("position",0);
        wordList = (ArrayList<String>) intent.getSerializableExtra("list");
        game = (Game) intent.getSerializableExtra("game");


        DatabaseHandler db = new DatabaseHandler(this);
        words = db.getWordsList();
        db.close();

    }

    public void fauneTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory().equalsIgnoreCase("Faune"))
            {
                liste.add(mot.getWord());
            }
        }
        int index = alea.nextInt(liste.size());
        String ranMot = liste.get(index);
        returnEnterWord(ranMot);
    }

    public void fictifTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory().equalsIgnoreCase("Fictif"))
            {
                liste.add(mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        returnEnterWord(ranMot);
    }

    public void floreTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory().equalsIgnoreCase("Flore"))
            {
                liste.add(mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        returnEnterWord(ranMot);

    }

    public void objetTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory().equalsIgnoreCase("Objet"))
            {
                liste.add(mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        returnEnterWord(ranMot);

    }

    public void peopleTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory().equalsIgnoreCase("People"))
            {
                liste.add(mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        returnEnterWord(ranMot);

    }

    public void returnEnterWord(String mot){
        Intent intent_next = new Intent(SelectRandomWord.this, PickupWord.class);


        wordList.set(position,mot);


        intent_next.putExtra("list", wordList);
        intent_next.putExtra("pos", pos);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}