package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PickupWord extends AppCompatActivity {

    public Game game;
    public ArrayList<Object> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //import game
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        //set content view
        setContentView(R.layout.activity_pickup_word);
        ListView listView = (ListView)findViewById(R.id.Activity_pickupword_listview_list);

        //remplissage list
        for (int i = 0; i < game.getNbWords(); i++) {
            String string = "";
            list.add(string);

        }

        listView.setAdapter(new EnterWordAdapter2(this, list));
    }

}
