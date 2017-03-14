package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Mae on 24/02/2017.
 */

public class EnterWordAdapter extends ArrayAdapter<String> implements OnClickListener {

    //shared preferences
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this.getContext());
    SharedPreferences.Editor editor = preferences.edit();
    //Var static preferences
    public static final String MyPREFERENCES = "Enterword" ;
    public static final String listCountA = "listCountA";

    public static final String listCountB = "listCountB";



    private int ressourceId;
    private Context context;
    private ArrayList<String> wordsA;
    private ArrayList<String> wordsB;
    private ArrayList<String> words;
    private LayoutInflater inflater;
    private int ab;
    private Game game;
    public EnterWordAdapter(Context context, int resourceId, ArrayList<String> myItemsA, ArrayList<String> myItemsB, Game game, int ab) {

        super(context, resourceId, myItemsA);
        if (ab == 1) {
            wordsA = myItemsA;
            wordsB = myItemsB;
        } else if (ab == 2) {
            wordsA = myItemsB;
            wordsB = myItemsA;
        }
        this.context = context;
        this.ressourceId = resourceId;
        this.game = game;
        this.ab = ab;

        inflater = LayoutInflater.from(this.context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {

        //String mot = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        // convertView.setOnClickListener(this);
        EditText word = (EditText) convertView.findViewById(R.id.EnterWord_EditText_Word);

        //Creating Button
        Button precedent = (Button) convertView.findViewById(R.id.pastword);
        Button dictionnaire = (Button) convertView.findViewById(R.id.dicoword);
        Button random = (Button) convertView.findViewById(R.id.randomword);
        Button ok = (Button) convertView.findViewById(R.id.EnterWord_Button_ok);

        //Adding listener on buttons
        precedent.setOnClickListener(this);
        dictionnaire.setOnClickListener(this);
        random.setOnClickListener(this);
        ok.setOnClickListener(this);

        //adding Tag to recognize button
        precedent.setTag(position);
        dictionnaire.setTag(position);
        random.setTag(position);
        ok.setTag(position);


        //Temporary Arraylist
       // ArrayList<int> word
        word.setHint("Entrez un mot" + position);
        if (!wordsA.get(position).isEmpty()) {
            word.setText(wordsA.get(position));
        }

        // word.setText(mot.getWord());

        return convertView;

    }


    @Override
    public void onClick(View v) {
        Intent activity;

        //Show the wordlist of previous word
        if (v.getId() == R.id.pastword) {
            activity = new Intent(this.getContext(), SelectWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.pastword).getTag());
            if (ab == 1) {
                activity.putExtra("listA", wordsA);
                activity.putExtra("listB", wordsB);
            } else if (ab == 2) {
                activity.putExtra("listA", wordsB);
                activity.putExtra("listB", wordsA);
            }
            activity.putExtra("game", game);
            activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);
        }

        //show the dictionary with words by category
        else if (v.getId() == R.id.dicoword) {
            activity = new Intent(this.getContext(), SelectRandomWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.dicoword).getTag());
            if (ab == 1) {
                activity.putExtra("listA", wordsA);
                activity.putExtra("listB", wordsB);
            } else if (ab == 2) {
                activity.putExtra("listA", wordsB);
                activity.putExtra("listB", wordsA);
            }
            activity.putExtra("game", game);
            activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);

        }

        //Select a random word
        else if (v.getId() == R.id.randomword) {
            Random alea = new Random();
            DatabaseHandler db = new DatabaseHandler(this.getContext());
            List<Word> wordsR = db.getWordsList();
            db.close();
            String ranMot = wordsR.get(alea.nextInt(wordsR.size())).getWord();

            Log.i("pos", "onClick: "+(int)v.findViewById(R.id.randomword).getTag());
            wordsA.set((int)v.findViewById(R.id.randomword).getTag(),ranMot);
        this.notifyDataSetChanged();

        }

        else if (v.getId() == R.id.EnterWord_Button_ok){
            if(ab == 1){
                int test =0;
                Log.i("onClick IDDD  ",v.findViewById(R.id.EnterWord_Button_ok).getTag().toString() );
               // Log.i("Nb mots", preferences.getInt("A"+v.findViewById(R.id.EnterWord_Button_ok).getTag().toString(), ""));
                Log.i("Nb mots", "valeur : "+preferences.getInt("A1",0));
            }
            else if (ab == 2) {


            }
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