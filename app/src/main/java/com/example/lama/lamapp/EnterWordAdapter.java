package com.example.lama.lamapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Mae on 24/02/2017.
 */

public class EnterWordAdapter extends ArrayAdapter<String> implements OnClickListener {
    private int ressourceId;
    private Context context;
    private ArrayList<String> words;
    private ArrayList<String> words2;
    private LayoutInflater inflater;
    private int ab;
    private Game game;

    public EnterWordAdapter(Context context, int resourceId, ArrayList<String> myItemsA, ArrayList<String> myItemsB, Game game, int ab) {

        super(context, resourceId, myItemsA);
        if (ab == 1) {
            Log.i("myitemsA", "EnterWordAdapter: " + myItemsA.toString());
            words = myItemsA;
            words2 = myItemsB;
        } else if (ab == 2) {
            Log.i("myitemsB", "EnterWordAdapter: " + myItemsB.toString());
            words = myItemsB;
            words2 = myItemsA;
        }
        this.context = context;
        this.ressourceId = resourceId;
        this.game = game;
        this.ab = ab;
        Log.i("AABB", "EnterWordAdapter: " + ab);

        inflater = LayoutInflater.from(this.context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {

        //String mot = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        // convertView.setOnClickListener(this);
        EditText word = (EditText) convertView.findViewById(R.id.word);
        Button precedent = (Button) convertView.findViewById(R.id.pastword);
        Button dictionnaire = (Button) convertView.findViewById(R.id.dicoword);
        precedent.setOnClickListener(this);
        dictionnaire.setOnClickListener(this);
        precedent.setTag(position);
        //precedent.setOnClickListener(this);
        dictionnaire.setTag(position);
        //dictionnaire.setOnClickListener(this);
        word.setHint("Joueur" + position);
        if (!words.get(position).isEmpty()) {
            word.setText(words.get(position));
        }
        //Button validword = (Button) convertView.findViewById(R.id.validerword);

        // word.setText(mot.getWord());

        return convertView;

    }


    @Override
    public void onClick(View v) {
        Intent activity;
        if (v.getId() == R.id.pastword) {
            activity = new Intent(this.getContext(), SelectWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.pastword).getTag());
            if (ab == 1) {
                activity.putExtra("listA", words);
                activity.putExtra("listB", words2);
            } else if (ab == 2) {
                activity.putExtra("listA", words2);
                activity.putExtra("listB", words);
            }
            activity.putExtra("game", game);
            activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);
        } else if (v.getId() == R.id.dicoword) {
            activity = new Intent(this.getContext(), SelectRandomWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.dicoword).getTag());
            if (ab == 1) {
                activity.putExtra("listA", words);
                activity.putExtra("listB", words2);
            } else if (ab == 2) {
                activity.putExtra("listA", words2);
                activity.putExtra("listB", words);
            }
            activity.putExtra("game", game);
            activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);

        }

    }


}