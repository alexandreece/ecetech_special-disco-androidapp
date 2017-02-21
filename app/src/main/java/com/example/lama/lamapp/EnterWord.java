package com.example.lama.lamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EnterWord extends AppCompatActivity {

    ListView vue1;

    String[] equipe = new String[]{
            "Lamatraque", "Lamalédiction"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);

        vue1 = (ListView) findViewById(R.id.list1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EnterWord.this,
                android.R.layout.simple_list_item_1, equipe);
        vue1.setAdapter(adapter);

    }

   /* private List<PlayersEnterWord> affichageEnterWords(){
        List<PlayersEnterWord> words = new ArrayList<PlayersEnterWord>();
        words.add(new PlayersEnterWord(Color.BLACK, "Florent", "Mon premier tweet !"));
        return words;
    }*/



}
