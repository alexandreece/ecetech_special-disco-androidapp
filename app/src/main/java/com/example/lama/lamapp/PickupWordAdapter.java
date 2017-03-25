package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by adri-laptop on 21/03/17.
 */

public class PickupWordAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    /*
    Variables
     */
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> list;
    private Game game;


    /*
    Constructeur
     */

    public PickupWordAdapter(Context context, int resourceId, ArrayList<String> myItems, Game game) {

        super(context, resourceId, myItems);

        this.context = context;
        inflater = LayoutInflater.from(this.context);
        list = myItems;
        this.game = game;
    }

    /*
    getview
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        //String mot = getItem(position);
        convertView = inflater.inflate(position,null);

        //Creating Button
        Button precedent = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Pastword);
        Button dictionnaire = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Dicoword);
        Button random = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Randomword);
        Button ok = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_ok);

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

        return convertView;

    }




    @Override
    public void onClick(View v) {
        Intent activity;

        //Show the wordlist of previous word
        if (v.getId() == R.id.Layout_PickupWord_Button_Pastword) {
            activity = new Intent(this.getContext(), SelectWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.Layout_PickupWord_Button_Pastword).getTag());

            activity.putExtra("game", game);
           // activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);
        }

        //show the dictionary with words by category
        else if (v.getId() == R.id.Layout_PickupWord_Button_Dicoword) {
            activity = new Intent(this.getContext(), SelectRandomWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.Layout_PickupWord_Button_Dicoword).getTag());

            activity.putExtra("game", game);
         //   activity.putExtra("ab", ab);
            this.getContext().startActivity(activity);

        }

        //Select a random word
        else if (v.getId() == R.id.Layout_PickupWord_Button_Randomword) {
            Random alea = new Random();
            DatabaseHandler db = new DatabaseHandler(this.getContext());
            List<Word> wordsR = db.getWordsList();
            db.close();
            String ranMot = wordsR.get(alea.nextInt(wordsR.size())).getWord();

            Log.i("pos", "onClick: " + (int) v.findViewById(R.id.Layout_PickupWord_Button_Randomword).getTag());
            list.set((int) v.findViewById(R.id.Layout_PickupWord_Button_Randomword).getTag(), ranMot);
            this.notifyDataSetChanged();

        }
        // ok button
        else if (v.getId() == R.id.Layout_PickupWord_Button_ok) {
            if (!list.isEmpty()) {
                Log.i("IF §§§", "EnterWordAdapter: ");
                game.getWords_List().add(list.get(R.id.Layout_PickupWord_Button_ok));
                list.remove(R.id.Layout_PickupWord_Button_ok);
            }else{
                Log.i("ELSE §§§ ", "EnterWordAdapter: ");

            }
                this.notifyDataSetChanged();

        }


    }

}



