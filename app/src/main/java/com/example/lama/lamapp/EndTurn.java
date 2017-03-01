package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EndTurn extends AppCompatActivity {

    TextView mPlayerName;
    TextView mTeamName;
    TextView mCurrentRound;
    TextView mPointsMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_turn);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        int[] PlayerToPlay = new int[2];
        PlayerToPlay = game.getPlayerToPlay();
        String NamePlayerToPlay;
        String NameTeam;

        if(PlayerToPlay[0] == 0){
            NamePlayerToPlay = game.getNameJoueurTeamA(PlayerToPlay[1]);
            mPlayerName = (TextView) findViewById(R.id.text_player_name);
            mPlayerName.setText(NamePlayerToPlay);
            NameTeam = game.getNameTeamA();
            mTeamName = (TextView) findViewById(R.id.text_team);
            mTeamName.setText(NameTeam);
        }else if(PlayerToPlay[0] == 1){
            NamePlayerToPlay = game.getNameJoueurTeamB(PlayerToPlay[1]);
            mPlayerName = (TextView) findViewById(R.id.text_player_name);
            mPlayerName.setText(NamePlayerToPlay);
            NameTeam = game.getNameTeamB();
            mTeamName = (TextView) findViewById(R.id.text_team);
            mTeamName.setText(NameTeam);
        }else{
            NamePlayerToPlay = "Null";
            mPlayerName = (TextView) findViewById(R.id.text_player_name);
            mPlayerName.setText(NamePlayerToPlay);
            NameTeam = "Null";
            mTeamName = (TextView) findViewById(R.id.text_team);
            mTeamName.setText(NameTeam);
        }

        int Round = game.getCurrentRound();
        String CurrentRound;
        switch (Round){
            case 1:
                CurrentRound = "Manche 1";
                mCurrentRound = (TextView) findViewById(R.id.text_round);
                mCurrentRound.setText(CurrentRound);
                break;

            case 2:
                CurrentRound = "Manche 2";
                mCurrentRound = (TextView) findViewById(R.id.text_round);
                mCurrentRound.setText(CurrentRound);
                break;

            case 3:
                CurrentRound = "Manche 3";
                mCurrentRound = (TextView) findViewById(R.id.text_round);
                mCurrentRound.setText(CurrentRound);
                break;

            default:
                CurrentRound = "Manche indéterminée";
                mCurrentRound = (TextView) findViewById(R.id.text_round);
                mCurrentRound.setText(CurrentRound);
                break;
        }

        int CurrentPoints = game.getNbPointsTurn();
        String PointsMessage = "L'équipe adverse reçoit " + CurrentPoints +  " LAMAs";
        mPointsMessage = (TextView) findViewById(R.id.Points_Message);
        mPointsMessage.setText(PointsMessage);
    }

    public void goto_NextPlayer(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        int[] LastPlayer = new int[2];
        int[] NextPlayer = new int[2];
        LastPlayer = game.getPlayerToPlay();

        int NbPlayer = game.getNbPlayers();

        if(LastPlayer[0] != 1 || LastPlayer[1] != NbPlayer-1){
            if (LastPlayer[0] == 0){
                NextPlayer[0] = 1;
                NextPlayer[1] = LastPlayer[1];
            }else if(LastPlayer[0] == 1){
                NextPlayer[0] = 0;
                NextPlayer[1] = LastPlayer[1]+1;
            }
        }else{
            NextPlayer[0] = 0;
            NextPlayer[1] = 0;
        }

        game.setPlayerToPlay(NextPlayer);

        Intent intent_next = new Intent(EndTurn.this, TestFragmentActivity.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}
