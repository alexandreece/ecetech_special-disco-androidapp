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

import com.example.lama.lamapp.DAOs.Joueur;
import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Button random = (Button) convertView.findViewById(R.id.randomword);
        precedent.setOnClickListener(this);
        dictionnaire.setOnClickListener(this);
        random.setOnClickListener(this);
        precedent.setTag(position);
        dictionnaire.setTag(position);
        random.setTag(position);
        word.setHint("Entrez un mot" + position);
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
        }
        else if (v.getId() == R.id.dicoword) {
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

        else if (v.getId() == R.id.randomword) {
            Random alea = new Random();
            DatabaseHandler db = new DatabaseHandler(this.getContext());
            List<Word> wordsR = db.getWordsList();
            db.close();
            String ranMot = wordsR.get(alea.nextInt(wordsR.size())).getWord();

            Log.i("pos", "onClick: "+(int)v.findViewById(R.id.randomword).getTag());
            words.set((int)v.findViewById(R.id.randomword).getTag(),ranMot);
        this.notifyDataSetChanged();

        }



    }

    public ArrayList<String> getList(){
        return words;
    }

    /*
     EditText word = (EditText) findViewById(R.id.word);
        Random alea = new Random();
        DatabaseHandler db = new DatabaseHandler(this);
        List<Word> words = db.getWordsList();
        db.close();
        String ranMot = words.get(alea.nextInt(words.size())).getWord();
        word.setText(ranMot, TextView.BufferType.NORMAL);
        Toast.makeText(getApplicationContext(), ranMot, Toast.LENGTH_SHORT).show();
     */
}