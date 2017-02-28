package com.example.lama.lamapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

public class TestJeux extends AppCompatActivity {

    private TextView textTimer;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_jeux);
        Intent intent = getIntent();
        game = (Game) intent.getSerializableExtra("game");

    }


    void setPlayerName(String name){
        TextView playername = (TextView) findViewById(R.id.TestJeux_TextView_PlayerName);
        playername.setText(name);
    }

    void startTimerThread() {
        textTimer = (TextView) findViewById(R.id.TestJeux_TextView_ShowTimer);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                int timer = 60;
                while (timer != 0) {
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final String finalTimer = Integer.toString(timer);
                    handler.post(new Runnable(){
                        public void run() {
                            textTimer = (TextView) findViewById(R.id.TestJeux_TextView_ShowTimer);
                            textTimer.setText(finalTimer);
                        }
                    });
                    timer--;
//                    Log.i("timer", "run: " + timer);
                }
            }
        };
        new Thread(runnable).start();
    }

    //void jeux(){
   //     for(int i = 0; i<game.getNbPlayers(),)
   // }

}
