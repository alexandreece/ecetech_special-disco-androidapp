package com.example.lama.lamapp;

import android.content.Intent;
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
    private ArrayList<String> wordListA;
    private ArrayList<String> wordListB;
    private Game game;
    private int ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_random_word);

        //get data (int position, ArrayList<String> list) from enterWord adapter
        final Intent intent = getIntent();
        pos = (int) intent.getSerializableExtra("position");
        ab = (int) intent.getSerializableExtra("ab");
        wordListA = (ArrayList<String>) intent.getSerializableExtra("listA");
        wordListB = (ArrayList<String>) intent.getSerializableExtra("listB");
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
                Log.i("Faune",mot.getWord());
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
                Log.i("Fictif",mot.getWord());
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
                Log.i("Flore",mot.getWord());
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
                Log.i("Objet",mot.getWord());
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
                Log.i("People",mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        returnEnterWord(ranMot);

    }

    public void returnEnterWord(String mot){
        Intent intent_next = new Intent(SelectRandomWord.this, EnterWord.class);
        Log.i("SELECTED", "onItemClick: "+ pos);
        Log.i("AB","AABB"+ab);
        Log.i("WordlistA " , wordListA.toString());
        if(ab == 1){
        wordListA.set(pos,mot);}
        else if(ab == 2){
        wordListB.set(pos,mot);}


        intent_next.putExtra("wordlistA", wordListA);
        intent_next.putExtra("wordlistB", wordListB);
        intent_next.putExtra("game", game);
        intent_next.putExtra("ab",ab);
        startActivity(intent_next);
    }
}