package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

                    int Count = game.getCount();
                    int CurrentPoint = 0;

                    public void onClick(View v){

                        int CurrentWord = game.getCurrentWord();

                        Count++;
                        game.setCount(Count);

                        Log.i("VALD", "-Count = " + Count);
                        Log.i("VALD", "-WordListSize = " + game.Words_List.size());

                        if(Count == game.Words_List.size()) {
                            CurrentPoint++;
                            game.setNbPointsTurn(CurrentPoint);
                            Intent intent_next = new Intent(TestFragmentActivity.this, EndTurn.class);
                            intent_next.putExtra("game", game);
                            startActivity(intent_next);
                        }else {
                            CountText = Integer.toString(Count) + "/" + Integer.toString(game.Words_List.size());
                            mCount.setText(CountText);
                            String LastWord = game.getWordCurrentList(CurrentWord);
                            Log.i("VALD", "-AvantCurrentWordList = " + game.getWords_Current_List());

                            game.deleteWord(LastWord);
                            Log.i("VALD", "-AprèsCurrentWordList = " + game.getWords_Current_List());

                            if(CurrentWord == game.getWords_Current_List().size()) CurrentWord--;
                            mWord.setText(game.getWordCurrentList(CurrentWord));
                            Log.i("VALD", "-CurrentWordNB = " + CurrentWord);

                            CurrentPoint++;
                            game.setNbPointsTurn(CurrentPoint);
                        }
                    }
                });
                final Button button_quit = (Button) findViewById(R.id.button_quit_word);
                button_quit.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v){
                        int CurrentWord = game.getCurrentWord();

                        Log.i("QUIT", "-Count = " + game.getCount());
                        Log.i("QUIT", "-1CurrentWord = " + CurrentWord);
                        Log.i("QUIT", "-CurrentListSIze = " + game.getWords_Current_List().size());
                        if(CurrentWord < game.getWords_Current_List().size()) {
                            CurrentWord++;
                            Log.i("QUIT", "-2CurrentWord = " + CurrentWord);

                            if(CurrentWord == game.getWords_Current_List().size()) {
                                CurrentWord = 0;
                                Log.i("QUIT", "-4CurrentWord = " + CurrentWord);
                            }

                            mWord.setText(game.getWordCurrentList(CurrentWord));
                            game.setCurrentWord(CurrentWord);
                        } else if(CurrentWord == game.getWords_Current_List().size()) {
                            CurrentWord = 0;
                            Log.i("QUIT", "-3CurrentWord = " + CurrentWord);
                            mWord.setText(game.getWordCurrentList(CurrentWord));
                            game.setCurrentWord(CurrentWord);
                        }

                    }
                });
            }
        }).start();
    }
}