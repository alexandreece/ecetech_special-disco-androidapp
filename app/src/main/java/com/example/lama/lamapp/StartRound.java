package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartRound extends AppCompatActivity {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_round);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        String text;

        int Round = game.getCurrentRound();

        switch (Round){

            case 1:
                text = "Première Manche !";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Plusieurs mots sont permis";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            case 2:
                text = "Deuxième Manche !";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Un seul mot est permi";
                mText = (TextView) findViewById(R.id.text_rule);
                mText.setText(text);

                break;

            case 3:
                text = "Dernière Manche !";
                mText = (TextView) findViewById(R.id.text_round);
                mText.setText(text);

                text = "Mime les mots";
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
    }

    public void goto_StartTurn(View view) {
        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        Intent intent_next = new Intent(StartRound.this, StartTurn.class);
        intent_next.putExtra("game", game);
        startActivity(intent_next);
    }
}
