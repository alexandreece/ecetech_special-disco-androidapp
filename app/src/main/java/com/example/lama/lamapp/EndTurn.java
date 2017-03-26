package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.Random;

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

        int[] TablePoint = new int[game.getNbPlayers()];

        for(int i = 0; i < game.getNbPlayers(); i++){
            TablePoint[i] = 0;
        }

        for(int i = 0; i < game.getCount(); i++){
            Random rand = new Random();
            int player = rand.nextInt(game.getNbPlayers());

            TablePoint[player] = TablePoint[player] + 1;
        }

        for(int i = 0; i < game.getNbPlayers(); i++){
            Log.i("Table","Point = " + TablePoint[i]);
        }

        final TextView[] myTextViews = new TextView[game.NbPlayers];

        RelativeLayout activity_end_turn = (RelativeLayout)findViewById(R.id.activity_end_turn);
        Log.i("Nb","Players =" + game.getNbPlayers());
        int n = 450;
        for (int i = 0; i < game.getNbPlayers(); i++) { // game.getNbPlayers()
            final TextView rowTextView = new TextView(this);
            Log.i("val", " i =" + i );

            if (PlayerToPlay[0]  == 0){
                rowTextView.setText(game.getNameJoueurTeamB(i)+ " ⟶ " + TablePoint[i] + " lamas");
            }else if (PlayerToPlay[0]  == 1){
                rowTextView.setText(game.getNameJoueurTeamA(i)+ " ⟶ " + TablePoint[i] + " lamas");
            }

            RelativeLayout relativeLayout = new RelativeLayout(this);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
            RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams)relativeLayout.getLayoutParams();
            relativeParams.setMargins(500, n, 10, 10);
            rowTextView.setLayoutParams(relativeParams);
            rowTextView.setTextSize(25);
            rowTextView.setBackgroundColor(0);
            activity_end_turn.addView(rowTextView);

            myTextViews[i] = rowTextView;

            n = n + 100;
        }
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
