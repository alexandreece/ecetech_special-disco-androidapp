package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EnterWord2 extends AppCompatActivity {

    public Game game;
    public ArrayList<Object> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");
        setContentView(R.layout.activity_enter_word2);
        ListView listView = (ListView)findViewById(R.id.ActivityEnterword2_listView);
        list = mergeList(game.getTeamA_List_Joueurs(),game.getTeamB_List_Joueurs(),game.TeamA,game.TeamB);


        listView.setAdapter(new EnterWordAdapter2(this, list));
    }





    public ArrayList mergeList(ArrayList<Joueur> joueurA, ArrayList<Joueur> joueurB, String teamA, String teamB ){
        ArrayList<Object> list =new  ArrayList<>();
        
        list.add(teamA);
        for (Joueur joueur :joueurA){
            list.add(joueur);
        }
        list.add(teamB);
        for (Joueur joueur :joueurB){
            list.add(joueur);
        }
        return list;



    }
}
