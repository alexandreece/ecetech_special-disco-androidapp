package com.example.lama.lamapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Word;

import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class TestFragmentActivity extends AppCompatActivity {

    String[] WordList = {"Chien", "Chat", "Poisson", "Ours", "Lombric", "Loup", "Chèvre", "Hyène", "Pigeon", "Aigle", "Souris", "Rat", "Grenouille", "Vache"};
   /* DatabaseHandler db = new DatabaseHandler(this);
    List<Word> WordList = db.getWordsList();*/
//    db.close();

    private Handler mHandler = new Handler();

    TextView mTimer;
    TextView mWord;
    TextView mCount;
    String CountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        mWord = (TextView) findViewById(R.id.ShowWord);
        mWord.setText(WordList[0]);

        mCount = (TextView) findViewById(R.id.ShowCount);
        CountText = "0/" + WordList.length;
        mCount.setText(CountText);

        // START TIMER
        startTimerThread();

        // WORD
        WordListThread();

        //String word = WordList.get(0).getWord();
    }

    // TIMER FUNCTION
    void startTimerThread() {
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {
                int timer = 60;
                while (timer != 0) {
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
                    timer--;
                }
            }
        };
        new Thread(runnable).start();
    }

    void WordListThread (){
        new Thread(new Runnable() {
            public void run() {
                final Button button_validate = (Button) findViewById(R.id.button_valid_word);
                button_validate.setOnClickListener(new View.OnClickListener(){
                    int i = 0;
                    int Count = 0;
                    int NbWord = WordList.length;
                    public void onClick(View v){
                        if(i < NbWord) {
                            i++;
                            mWord.setText(WordList[i]);
                            Count++;
                            CountText = Integer.toString(Count)+ "/" + Integer.toString(WordList.length);
                            mCount.setText(CountText);
                            if(i == WordList.length - 1) i = 0;
                        }
                    }
                });
                final Button button_quit = (Button) findViewById(R.id.button_quit_word);
                button_quit.setOnClickListener(new View.OnClickListener(){
                    int i = 0;
                    int NbWord = WordList.length;
                    public void onClick(View v){
                        if(i < NbWord) {
                            i++;
                            mWord.setText(WordList[i]);
                            if(i == WordList.length - 1) i = 0;
                        }
                    }
                });
            }
        }).start();
    }
}

