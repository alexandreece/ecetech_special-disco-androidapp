package com.example.lama.lamapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

public class PlayersName extends Activity {
    private ListView Liste;
    private PlayerNameAdapter myAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);

        //Liste = (ListView) findViewById(android.R.id.list);
        Liste = (ListView) findViewById(R.id.list1);
        Liste.setItemsCanFocus(true);

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();

        joueurs.add(J1);
        joueurs.add(J2);

        myAdapter = new PlayerNameAdapter(this, R.layout.layout_playername,joueurs);
        //ListView lv = (ListView) findViewById(R.id.list1);
        Liste.setAdapter(myAdapter);
        //setListAdapter(myAdapter);

    }
}