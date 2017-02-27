package com.example.lama.lamapp;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Joueur;

public class PlayersName extends Activity implements OnClickListener {
    private ListView ListeA;
    private ListView ListeB;
    private PlayerNameAdapter adapterA;
    private PlayerNameAdapter adapterB;
    private Game game;
    private ArrayList<Joueur> equipeA ;
    private ArrayList<Joueur> equipeB ;
    private Button valider;
    EditText teamA;
    EditText teamB;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Intent intent = getIntent();

        game = (Game) intent.getSerializableExtra("game");

        equipeA = new ArrayList<>();
        equipeB = new ArrayList<>();

        valider = (Button) findViewById(R.id.okPlayerName);
        teamA = (EditText) findViewById(R.id.nameEqA);
        teamB = (EditText) findViewById(R.id.nameEqB);

        valider.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {
        game.setNameTeamA(teamA.getText().toString());
        game.setNameTeamB(teamB.getText().toString());
        game.addTeamA(adapterA.getList());
        game.addTeamA(adapterB.getList());
        Toast.makeText(getApplicationContext(), game.getTeamA_List_Joueurs().toString(),Toast.LENGTH_SHORT).show();
        Game temp = new Game();
        Intent intent_next = new Intent("com.example.lama.lamapp.EnterWord");
        intent_next.putExtra("temp", temp);
        startActivity(intent_next);


    }
}