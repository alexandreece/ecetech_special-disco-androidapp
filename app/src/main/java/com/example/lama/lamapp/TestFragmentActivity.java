package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TestFragmentActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_test_fragment);

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
        Log.i("Current", "Round = " + Round);
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

        mWord = (TextView) findViewById(R.id.ShowWord);
        mWord.setText(game.getWordCurrentList(0));

        mCount = (TextView) findViewById(R.id.ShowCount);
        CountText = "0/" + game.Words_List.size();
        Log.i("Word", "ListSize = " + game.Words_List.size());
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
                }
                Intent intent_next = new Intent(TestFragmentActivity.this, EndTurn.class);
                intent_next.putExtra("game", game);
                startActivity(intent_next);
            }
        };
        new Thread(runnable).start();
    }

    void WordListThread (final Game game){
        new Thread(new Runnable() {
            public void run() {
                final Button button_validate = (Button) findViewById(R.id.button_valid_word);
                button_validate.setOnClickListener(new View.OnClickListener(){

                    int Count = 0;
                    int CurrentPoint = 0;
                    int Nb = game.Words_List.size();//game.getNbWords();

                    public void onClick(View v){

                        int NbWord = game.Words_Current_List.size();//game.getNbWords();
                        int CurrentWord = game.getCurrentWord();

                        String LastWord = game.getWordCurrentList(CurrentWord);
                        game.deleteWord(LastWord);
                        mWord.setText(game.getWordCurrentList(CurrentWord));

                        Count++;
                        CountText = Integer.toString(Count)+ "/" + Integer.toString(Nb);
                        mCount.setText(CountText);

                        CurrentPoint++;
                        game.setNbPointsTurn(CurrentPoint);
                        Log.i("Count", "=" + Count);
                        Log.i("WordCurrent","List =" + game.getWords_Current_List().toString());
                        Log.i("Word","List=" + game.getWords_List().toString());

                        if(Count == Nb){
                        Intent intent_next = new Intent(TestFragmentActivity.this, EndTurn.class);
                            intent_next.putExtra("game", game);
                            startActivity(intent_next);
                        }
                    }
                });
                final Button button_quit = (Button) findViewById(R.id.button_quit_word);
                button_quit.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v){
                        int NbWord = game.Words_List.size();
                        int CurrentWord = game.getCurrentWord();
                        if(CurrentWord < NbWord) {
                            CurrentWord++;
                            if(CurrentWord == NbWord) CurrentWord = 0;
                            mWord.setText(game.getWordCurrentList(CurrentWord));
                            game.setCurrentWord(CurrentWord);
                        }
                    }
                });
            }
        }).start();
    }
}

