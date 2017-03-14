package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
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
    private ArrayList<String> wordListA;
    private ArrayList<String> wordListB;
    private Game game;
    private int ab;
    private Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //get data (int position, ArrayList<String> list) from enterWord adapter
        final Intent intent = getIntent();
        pos = (int) intent.getSerializableExtra("position");
        ab = (int) intent.getSerializableExtra("ab");
        wordListA = (ArrayList<String>) intent.getSerializableExtra("listA");
        wordListB = (ArrayList<String>) intent.getSerializableExtra("listB");
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

                if(ab == 1){
                    wordListA.set(pos,selected);}
                else if(ab == 2){
                    wordListB.set(pos,selected);}

           //     wordList.add(pos,selected);
                intent_next.putExtra("wordlistA", wordListA);
                intent_next.putExtra("wordlistB", wordListB);
                intent_next.putExtra("game", game);
                intent_next.putExtra("ab",ab);

                vibe.vibrate(400); // 50 is time in ms
               startActivity(intent_next);
            }
        });
    }
}