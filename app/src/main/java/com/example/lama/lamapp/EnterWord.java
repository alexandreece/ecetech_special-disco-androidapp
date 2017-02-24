package com.example.lama.lamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EnterWord extends AppCompatActivity {

    ListView vue1;
    ListView vue2;

    String[] equipe = new String[]{
            "Lamatraque", "Lamalédiction"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);

        vue1 = (ListView) findViewById(R.id.enter_word_list1);
        vue2 = (ListView) findViewById(R.id.enter_word_list2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(EnterWord.this,
                android.R.layout.simple_list_item_1, equipe);
        vue1.setAdapter(adapter1);


    }





}
