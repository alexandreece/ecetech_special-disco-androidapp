package com.example.lama.lamapp;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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


        //Getting the game class from previous view
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

        //create object editext, button
        valider = (Button) findViewById(R.id.playerName_Button_okPlayerName);
        valider.setOnClickListener(this);
        teamA = (EditText) findViewById(R.id.playerName_Editext_nameEqA);
        teamB = (EditText) findViewById(R.id.playerName_Editext_nameEqB);

        //generating Arraylist for each team and adding adapter
        equipeA = new ArrayList<>();
        equipeB = new ArrayList<>();

       for(int i =0; i<game.getNbPlayers();i++){
            Joueur joueurA = new Joueur();
            Joueur joueurB = new Joueur();

            equipeA.add(joueurA);
            equipeB.add(joueurB);
        }

        ListeA = (ListView) findViewById(R.id.playerName_ListView_listA);
        ListeB = (ListView) findViewById(R.id.playerName_Listview_listB);


        adapterA = new PlayerNameAdapter(this, R.layout.layout_playername,equipeA);
        adapterB = new PlayerNameAdapter(this, R.layout.layout_playername,equipeB);

        ListeA.setAdapter(adapterA);
        ListeB.setAdapter(adapterB);


    }

    // action button "valider"
    @Override
    public void onClick(View v) {
        //team name
        game.setNameTeamA(teamA.getText().toString());
        game.setNameTeamB(teamB.getText().toString());

        //team players
        game.addTeamA(adapterA.getList());
        game.addTeamB(adapterB.getList());

        //sendind game object to next class

        Intent intent_next = new Intent(PlayersName.this, EnterWord.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);



    }
}