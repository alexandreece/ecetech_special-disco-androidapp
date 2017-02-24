package com.example.lama.lamapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mae on 24/02/2017.
 */

public class EnterWordAdapter extends ArrayAdapter<Word> {
    private int ressourceId;
    private Context context;
    private ArrayList<Word> myItems;
    private LayoutInflater inflater;

    public EnterWordAdapter(Context context, int resourceId , List myItems) {
        super(context, resourceId, myItems);
        this.context = context;
        this.ressourceId = resourceId;
        inflater = LayoutInflater.from(this.context);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Word mot = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        EditText word = (EditText) convertView.findViewById(R.id.word);
        Button validword = (Button) convertView.findViewById(R.id.validerword);

        word.setText(mot.getWord());


        return convertView;

    }
}
