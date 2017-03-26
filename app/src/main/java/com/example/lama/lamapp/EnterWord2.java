package com.example.lama.lamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EnterWord2 extends AppCompatActivity implements View.OnClickListener{


    public Game game;
    public ArrayList<Object> list;
    public Button valider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // import class game
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        //creation de l'activité
        setContentView(R.layout.activity_enter_word2);
        ListView listView = (ListView) findViewById(R.id.ActivityEnterword2_listView);
        valider = (Button) findViewById(R.id.ActivityEnterword2_button);
        valider.setOnClickListener(this);

        // fusion des deux listes de joueurs
        list = mergeList(game.getTeamA_List_Joueurs(), game.getTeamB_List_Joueurs(), game.TeamA, game.TeamB);


        listView.setAdapter(new EnterWordAdapter2(this, list, game));
    }


    private void saveWordNumber(int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("A" + i, 0);
        editor.putInt("B" + i, 0);
        editor.apply();
    }

    public ArrayList mergeList(ArrayList<Joueur> joueurA, ArrayList<Joueur> joueurB, String teamA, String teamB) {
        ArrayList<Object> list = new ArrayList<>();
        int i = 0;
        SharedPreferences sharedPreferences = getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        list.add(teamA);
        i++;
        for (Joueur joueur : joueurA) {

            list.add(joueur);
            if (!sharedPreferences.contains("J" + i)) {
                editor.putInt("J" + i, game.getNbWords());
                editor.apply();
            }
            i++;
        }
        list.add(teamB);
        i++;
        for (Joueur joueur : joueurB) {
            list.add(joueur);
            if (!sharedPreferences.contains("J" + i)) {
                editor.putInt("J" + i, game.getNbWords());
                editor.apply();
            }
            i++;
        }

        return list;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ActivityEnterword2_button){
            Intent next = new Intent(EnterWord2.this, TestFragmentActivity.class);
            next.putExtra("game", game);
            Log.i("Game launching ", "onClick: "+game.getWords_List().toString());
            //startActivity(next);
        }
    }
}
