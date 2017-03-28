package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {

    TextView mTimer;
    TextView mWord;
    TextView mCount;
    TextView mPlayerName;
    TextView mTeamName;
    TextView mCurrentRound;
    String CountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

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

        if(game.getLevel() == 2){
            final Button button_quit = (Button) findViewById(R.id.button_quit_word);
            button_quit.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF016566));
            button_quit.setTextColor(0xFFFF0000);
        }

        mWord = (TextView) findViewById(R.id.ShowWord);
        mWord.setText(game.getWordCurrentList(0));

        mCount = (TextView) findViewById(R.id.ShowCount);
        int Count = game.getCount();
        CountText = Count + "/" + game.Words_List.size();
        mCount.setText(CountText);

        // START TIMER
        startTimerThread(game);

        // WORD
        WordListThread(game);
    }

    // TIMER FUNCTION
    void startTimerThread(final Game game) {
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                int timer = 61;
                while (timer != 0) {
                    timer--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final String finalTimer = Integer.toString(timer);
                    handler.post(new Runnable() {
                        public void run() {
                            mTimer = (TextView) findViewById(R.id.ShowTimer);
                            mTimer.setText(finalTimer);
                        }
                    });

                    if (timer <= 5 && game.getCount() < game.Words_List.size()) {
                        Vibrator vibreur = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        Log.i("Vibreur", "" + vibreur.hasVibrator());
                        long[] pattern = {0, 800, 200};
                        vibreur.vibrate(pattern, -1);
                    }
                }
                if (game.getCount() < game.Words_List.size() && timer == 0) {
                    Intent intent_next = new Intent(PlayGame.this, EndTurn.class);
                    intent_next.putExtra("game", game);
                    startActivity(intent_next);
                }
            }
        };
        new Thread(runnable).start();
    }

    void WordListThread (final Game game){
        new Thread(new Runnable() {
            public void run() {
                final Button button_validate = (Button) findViewById(R.id.button_valid_word);
                button_validate.setOnClickListener(new View.OnClickListener(){

                    int Count = game.getCount();
                    int CurrentPoint = 0;

                    public void onClick(View v){

                        int CurrentWord = game.getCurrentWord();

                        Count++;
                        game.setCount(Count);

                        if(Count == game.Words_List.size()) {
                            CurrentPoint++;
                            game.setNbPointsTurn(CurrentPoint);
                            Intent intent_next = new Intent(PlayGame.this, EndTurn.class);
                            intent_next.putExtra("game", game);
                            startActivity(intent_next);
                        }else {
                            CountText = Integer.toString(Count) + "/" + Integer.toString(game.Words_List.size());
                            mCount.setText(CountText);

                            String LastWord = game.getWordCurrentList(CurrentWord);

                            game.deleteWord(LastWord);

                            if(CurrentWord == game.getWords_Current_List().size()) CurrentWord--;

                            game.setCurrentWord(CurrentWord);
                            mWord.setText(game.getWordCurrentList(CurrentWord));
                            CurrentPoint++;
                            game.setNbPointsTurn(CurrentPoint);
                        }
                    }
                });
                final Button button_quit = (Button) findViewById(R.id.button_quit_word);
                button_quit.setOnClickListener(new View.OnClickListener(){

                    int quit = 1;

                    public void onClick(View v){

                        if (game.getLevel() != 2){

                            if( game.getQuit() < 3 ){

                                if(game.getLevel() == 1) game.setQuit(quit++);

                                if(game.getQuit() == 3){
                                    button_quit.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFF016566));
                                    button_quit.setTextColor(0xFF017E80);
                                }

                                int CurrentWord = game.getCurrentWord();

                                if(CurrentWord < game.getWords_Current_List().size()) {

                                    CurrentWord++;
                                    if(CurrentWord == game.getWords_Current_List().size()) CurrentWord = 0;
                                    mWord.setText(game.getWordCurrentList(CurrentWord));
                                    game.setCurrentWord(CurrentWord);

                                } else if(CurrentWord == game.getWords_Current_List().size()) {

                                    CurrentWord = 0;
                                    mWord.setText(game.getWordCurrentList(CurrentWord));
                                    game.setCurrentWord(CurrentWord);

                                }
                            }
                        }

                    }
                });
            }
        }).start();
    }
}