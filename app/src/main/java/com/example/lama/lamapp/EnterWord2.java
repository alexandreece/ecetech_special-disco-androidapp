package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lama.lamapp.DAOs.Joueur;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EnterWord2 extends AppCompatActivity {

    public Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word2);

        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");
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
