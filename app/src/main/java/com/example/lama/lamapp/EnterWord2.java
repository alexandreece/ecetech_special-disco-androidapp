package com.example.lama.lamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EnterWord2 extends AppCompatActivity implements View.OnClickListener{


    public Game game;
    public ArrayList<Object> list;
    public Button valider;
    // Gets linearlayout
    public LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // import class game
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");


        //creation de l'activité
        setContentView(R.layout.activity_enter_word2);
        layout = (LinearLayout)findViewById(R.id.ActivityEnterword2_LinearLayout_Listviewconstraint);
        ListView listView = (ListView) findViewById(R.id.ActivityEnterword2_listView);
        valider = (Button) findViewById(R.id.ActivityEnterword2_button);
        valider.setOnClickListener(this);
        // Gets the layout params that will allow you to resize the layout
        ViewGroup.LayoutParams params = layout.getLayoutParams();
// Changes the height and width to the specified *pixels*
        if(game.getNbPlayers() == 2){
            params.height = 1400;
        }
        else if(game.getNbPlayers() == 3){
            params.height = 1800;
        }
        else if(game.getNbPlayers() == 4){
            params.height = 2000;
        }
        else if(game.getNbPlayers() == 5){
            params.height = 2200;
        }
        layout.setLayoutParams(params);


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

    public void setLayoutSize(){

    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ActivityEnterword2_button){
            if(game.getWords_List().size() < (game.getNbWords()* (game.getNbPlayers()*2))){
                Toast.makeText(this, "Tous les mots ne sont pas remplis", Toast.LENGTH_SHORT).show();

            }
            else {
                Intent next = new Intent(EnterWord2.this, StartRound.class);
                game.setWords_Current_List();
                game.setCurrentRound(1);
                next.putExtra("game", game);
                Log.i("Game launching ", "onClick: " + game.getWords_List().toString());
                startActivity(next);
            }
        }
    }
}
