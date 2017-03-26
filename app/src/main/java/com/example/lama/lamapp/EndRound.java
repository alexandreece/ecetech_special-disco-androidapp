package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndRound extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_round);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        String text;

        int Round = game.getCurrentRound();
        switch (Round){
            case 1:
                text  = "Manche 1";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text  = "Plusieurs mots autorisés";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            case 2:
                text  = "Manche 2";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);
                text  = "Un seul mot autorisé";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);
                break;

            case 3:
                text  = "Manche 3";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text  = "Mimer les mots";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            default:
                text  = "Manche indéterminée";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text  = "Règle indéterminée";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;
        }

        if(game.getNbPointsRoundTeamA() > game.getNbPointsRoundTeamB())
        {
            text  = game.getNameTeamA() + " remporte la manche";
            mText = (TextView) findViewById(R.id.text_teamwin);
            mText.setText(text);
            game.setWinRoundTeamA();

            int lamas = game.getNbPointsRoundTeamA() - game.getNbPointsRoundTeamB();
            text  = "Chaque joueur de " + game.getNameTeamB() + " reçoit " + Integer.toString(lamas) + " lamas";
            mText = (TextView) findViewById(R.id.text_distrib);
            mText.setText(text);

        } else if(game.getNbPointsRoundTeamA() < game.getNbPointsRoundTeamB()) {

            text  = game.getNameTeamB() + " remporte la manche";
            mText = (TextView) findViewById(R.id.text_teamwin);
            mText.setText(text);
            game.setWinRoundTeamB();

            int lamas = game.getNbPointsRoundTeamB() - game.getNbPointsRoundTeamA();
            text  = "Chaque joueur de " + game.getNameTeamB() + " reçoit " + Integer.toString(lamas) + " lamas";
            mText = (TextView) findViewById(R.id.text_distrib);
            mText.setText(text);

        } else if(game.getNbPointsRoundTeamA() == game.getNbPointsRoundTeamB()) {

            text  = "Égalité ! Personne ne remporte la manche";
            mText = (TextView) findViewById(R.id.text_teamwin);
            mText.setText(text);

            text  = "Chaque joueur reçoit 1 lamas";
            mText = (TextView) findViewById(R.id.text_distrib);
            mText.setText(text);

        }

        text  = game.getNameTeamA() + " : " + game.getNbPointsRoundTeamA() + " Lamas distribués";
        mText = (TextView) findViewById(R.id.text_teama);
        mText.setText(text);

        text  = game.getNameTeamB() + " : " + game.getNbPointsRoundTeamB() + " Lamas distribués";
        mText = (TextView) findViewById(R.id.text_teamb);
        mText.setText(text);

    }

    public void goto_NextRound(View view) {

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        if(game.getCurrentRound() != 3) {

            game.setCount(0);
            game.setNbPointsTurn(0);
            game.setNbPointRoundTeamA(0);
            game.setNbPointRoundTeamB(0);
            game.setCurrentWord(0);
            game.setWords_Current_List();
            int Round = game.getCurrentRound() + 1;
            game.setCurrentRound(Round);
            game.setQuit(0);

            int[] NextPlayer = new int[2];
            if(Round == 2){
                NextPlayer[0] = 1;
                NextPlayer[1] = 0;
                game.setPlayerToPlay(NextPlayer);
            } else if(Round == 3) {
                int[] LastPlayer = new int[2];
                LastPlayer = game.getPlayerToPlay();

                int NbPlayer = game.getNbPlayers();

                if (LastPlayer[0] != 1 || LastPlayer[1] != NbPlayer - 1) {
                    if (LastPlayer[0] == 0) {
                        NextPlayer[0] = 1;
                        NextPlayer[1] = LastPlayer[1];
                    } else if (LastPlayer[0] == 1) {
                        NextPlayer[0] = 0;
                        NextPlayer[1] = LastPlayer[1] + 1;
                    }
                } else {
                    NextPlayer[0] = 0;
                    NextPlayer[1] = 0;
                }
                game.setPlayerToPlay(NextPlayer);
            }

            Intent intent_next = new Intent(EndRound.this, PlayGame.class);
            intent_next.putExtra("game", game);
            startActivity(intent_next);

        } else {

            Intent intent_next = new Intent(EndRound.this, EndGame.class);
            intent_next.putExtra("game", game);
            startActivity(intent_next);

        }
    }
}
