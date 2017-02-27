package com.example.lama.lamapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

public class PlayersName extends Activity {
    private ListView ListeA;
    private ListView ListeB;
    private PlayerNameAdapter adapterA;
    private PlayerNameAdapter adapterB;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);

        Intent intent = getIntent();

        Game game = (Game) intent.getSerializableExtra("game");

        ArrayList<Joueur> equipeA = new ArrayList<>();
        ArrayList<Joueur> equipeB = new ArrayList<>();

        Button valider = find
        for(int i =0; i<game.getNbPlayers();i++){
            Joueur joueurA = new Joueur();
            Joueur joueurB = new Joueur();

            equipeA.add(joueurA);
            equipeB.add(joueurB);
        }

        ListeA = (ListView) findViewById(R.id.listA);
        ListeB = (ListView) findViewById(R.id.listB);

        adapterA = new PlayerNameAdapter(this, R.layout.layout_playername,equipeA);
        adapterB = new PlayerNameAdapter(this, R.layout.layout_playername,equipeB);
        ListeA.setAdapter(adapterA);
        ListeB.setAdapter(adapterB);
    }
}