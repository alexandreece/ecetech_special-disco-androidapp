package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndTurnRecap extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_turn_recap);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        String text;

        int Round = game.getCurrentRound();
        switch (Round){
            case 1:
                text = "Manche 1";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Plusieurs mots permis";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            case 2:
                text = "Manche 2";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Un seul mot permi";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            case 3:
                text= "Manche 3";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Mimer les mots";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            default:
                text = "Manche indéterminée";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Règle indéterminée";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;
        }

        text = game.getNameTeamA() + " : " + game.getNbPointsRoundTeamA() + " Lamas distribués";
        mText = (TextView) findViewById(R.id.text_teama);
        mText.setText(text);

        text = game.getNameTeamB() + " : " + game.getNbPointsRoundTeamB() + " Lamas distribués";
        mText = (TextView) findViewById(R.id.text_teamb);
        mText.setText(text);

        int WordToFind = game.getWords_List().size() - game.getCount();

        text = Integer.toString(WordToFind) + " mots restant à trouver";
        mText = (TextView) findViewById(R.id.text_words);
        mText.setText(text);
    }

    public void goto_NextPlayer(View view) {

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        int[] LastPlayer = new int[2];
        int[] NextPlayer = new int[2];
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
        game.setQuit(0);

        Intent intent_next = new Intent(EndTurnRecap.this, StartTurn.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}
