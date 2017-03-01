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
    String CountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        mWord = (TextView) findViewById(R.id.ShowWord);
        mWord.setText(game.getWord(0));

        mCount = (TextView) findViewById(R.id.ShowCount);
        CountText = "0/" + game.Words_List.size();
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
                Intent intent_next = new Intent(TestFragmentActivity.this, Test.class);
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
                    int i = 0;
                    int Count = 0;
                    int CurrentPoint = 0;
                    int NbWord = game.Words_List.size(); //game.getNbWords();
                    public void onClick(View v){
                        if(i < NbWord) {
                            i++;
                            CurrentPoint++;
                            mWord.setText(game.getWord(i));
                            Count++;
                            CountText = Integer.toString(Count)+ "/" + Integer.toString(NbWord);
                            mCount.setText(CountText);
                            game.setNbPointsTurn(CurrentPoint);
                            Log.i("Test", "NbPoint = " + game.getNbPointsTurn());
                            if(i == NbWord - 1) i = 0;
                        }
                        if(Count == game.Words_List.size()){
                            Intent intent_next = new Intent(TestFragmentActivity.this, Test.class);
                            intent_next.putExtra("game", game);
                            startActivity(intent_next);
                        }
                    }
                });
                final Button button_quit = (Button) findViewById(R.id.button_quit_word);
                button_quit.setOnClickListener(new View.OnClickListener(){
                    int i = 0;
                    int NbWord = game.Words_List.size();
                    public void onClick(View v){
                        if(i < NbWord) {
                            i++;
                            mWord.setText(game.getWord(i));
                            if(i == NbWord - 1) i = 0;
                        }
                    }
                });
            }
        }).start();
    }
}

