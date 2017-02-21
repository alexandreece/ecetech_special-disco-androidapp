package com.example.lama.lamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EnterWord extends AppCompatActivity {

    ListView vue1;
    String[] equipe = new String[]{
            "Lamatraque", "Lamalédiction"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word);

        vue1 = (ListView) findViewById(R.id.list);
        
    }



}
