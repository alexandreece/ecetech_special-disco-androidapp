package com.example.lama.lamapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class PickupWord extends AppCompatActivity implements View.OnClickListener {

    public Game game;
    public ArrayList<String> list = new ArrayList<>();
    public Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //import game
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");
        int pos = (int) intent.getIntExtra("pos", 0);

        //import shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //set content view
        setContentView(R.layout.activity_pickup_word);
        ListView listView = (ListView) findViewById(R.id.Activity_pickupword_listview_list);

        //button retour
        retour = (Button) findViewById(R.id.Activity_pickupword_Button_Return);
        retour.setOnClickListener(this);

        //remplissage list
        if (intent.getSerializableExtra("list") != null) {

            list = (ArrayList<String>) intent.getSerializableExtra("list");
        } else {
            for (int i = 0; i < sharedPreferences.getInt("J" + pos, 0); i++) {
                String string = "";
                list.add(string);

            }
        }
        listView.setAdapter(new PickupWordAdapter(this, R.layout.layout_pickupword, list, game, pos));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Activity_pickupword_Button_Return) {
            Intent next = new Intent(PickupWord.this, EnterWord2.class);
            next.putExtra("game", game);

            v.getContext().startActivity(next);
        }
    }
}

