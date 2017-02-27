package com.example.lama.lamapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.lama.lamapp.DAOs.Word;

import java.util.List;

public class TestFragmentActivity extends AppCompatActivity {

//    String [] WordList = {"Chien","Chat","Poisson","Ours", "Lombric", "Loup", "Chèvre", "Hyène","Pigeon", "Aigle", "Souris", "Rat", "Grenouille","Vache"};
   /* DatabaseHandler db = new DatabaseHandler(this);
    List<Word> WordList = db.getWordsList();*/
//    db.close();


    TextView mWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        mWord = (TextView) findViewById(R.id.ShowWord);
        startTimerThread();
//        String word = WordList.get(0).getWord();
//        mWord.setText(word);
    }

     void startTimerThread() {
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
                            mWord = (TextView) findViewById(R.id.ShowTimer);
                            mWord.setText(finalTimer);
                        }
                    });
                    timer--;
//                    Log.i("timer", "run: " + timer);
                }
            }
        };
        new Thread(runnable).start();
    }


    public void UpdateWord(View view) {/*
        for(int i = 0; i < 5; i++){
            mWord = (TextView) findViewById(R.id.ShowWord);
            //mWord.setText(WordList.get(i).getWord());
        }*/

    }
}
