package com.example.lama.lamapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

public class PlayersName extends Activity {
    private ListView Liste1;
    private ListView Liste2;
    private PlayerNameAdapter myAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);

        Liste1 = (ListView) findViewById(R.id.listA);
        Liste2 = (ListView) findViewById(R.id.listB);
        //Liste1.setItemsCanFocus(true);

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();
        Joueur J3 = new Joueur();
        Joueur J4 = new Joueur();

        joueurs.add(J1);
        joueurs.add(J2);
        joueurs.add(J3);
        joueurs.add(J4);

        myAdapter = new PlayerNameAdapter(this, R.layout.layout_playername,joueurs);
        Liste1.setAdapter(myAdapter);
        Liste2.setAdapter(myAdapter);
    }
}