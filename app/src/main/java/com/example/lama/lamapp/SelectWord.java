package com.example.lama.lamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectWord extends AppCompatActivity {

    ListView vue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_word);

        vue = (ListView) findViewById(R.id.list);

        String[][] mots = new String[][]{
                {"Brad Pitt", "People"},
                {"The Rock", "People"},
                {"Lombric", "Faune"}
        };

        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> element;

        for(int i = 0 ; i < mots.length ; i++) {
            element = new HashMap<String, String>();
            element.put("mot", mots[i][0]);
            element.put("categorie", mots[i][1]);
            liste.add(element);
        }

        ListAdapter adapter = new SimpleAdapter(this, liste, android.R.layout.simple_list_item_2, new String[] {"mot", "categorie"}, new int[] {android.R.id.text1, android.R.id.text2 });
        vue.setAdapter(adapter);

    }
}