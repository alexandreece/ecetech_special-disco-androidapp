package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by adri-laptop on 21/03/17.
 */

public class PickupWordAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    /*
    shared preferences
     */

    SharedPreferences sharedPreferences = this.getContext().getSharedPreferences("NBWord", MODE_PRIVATE);
    SharedPreferences wordListPreference = this.getContext().getSharedPreferences("wordListPreference", MODE_PRIVATE);
    String wordlisSerialize = wordListPreference.getString("list", "");
    SharedPreferences.Editor editor = sharedPreferences.edit();
    /*
    Variables
     */
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<String> list;
    private Game game;
    private int ressourceId;
    private int pos;

    /*
    Constructeur
     */

    public PickupWordAdapter(Context context, int resourceId, ArrayList<String> list, Game game, int pos) {

        super(context, resourceId, list);

        this.context = context;
        inflater = LayoutInflater.from(this.context);
        this.list = list;
        this.ressourceId = resourceId;
        this.pos = pos;
        this.game = game;
    }

    /*
    getview
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        //String mot = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);

        //Creating Button
        Button precedent = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Pastword);
        Button dictionnaire = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Dicoword);
        Button random = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_Randomword);
        Button ok = (Button) convertView.findViewById(R.id.Layout_PickupWord_Button_ok);

        //Edit text
        EditText word = (EditText) convertView.findViewById(R.id.Layout_PickupWord_EditText_Word);

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
        word.setHint("Entrez un mot");
        if (!list.get(position).isEmpty()) {
            word.setText(list.get(position));
        }
        return convertView;

    }


    @Override
    public void onClick(View v) {
        Intent activity;
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //Show the wordlist of previous word
        if (v.getId() == R.id.Layout_PickupWord_Button_Pastword) {
            Log.i("PickupWord", "onClick: " + v.getTag());
            activity = new Intent(this.getContext(), SelectWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.Layout_PickupWord_Button_Pastword).getTag());
            activity.putExtra("list", list);
            activity.putExtra("pos", pos);
            activity.putExtra("game", game);
            this.getContext().startActivity(activity);
        }

        //show the dictionary with words by category
        else if (v.getId() == R.id.Layout_PickupWord_Button_Dicoword) {
            activity = new Intent(this.getContext(), SelectRandomWord.class);
            activity.putExtra("position", (int) v.findViewById(R.id.Layout_PickupWord_Button_Dicoword).getTag());
            activity.putExtra("list", list);
            activity.putExtra("pos", pos);
            activity.putExtra("game", game);
            this.getContext().startActivity(activity);

        }

        //Select a random word
        else if (v.getId() == R.id.Layout_PickupWord_Button_Randomword) {

            Random alea = new Random();
            DatabaseHandler db = new DatabaseHandler(this.getContext());
            List<Word> wordsR = db.getWordsList();
            db.close();
            String ranMot = wordsR.get(alea.nextInt(wordsR.size())).getWord();

            list.set((int) v.findViewById(R.id.Layout_PickupWord_Button_Randomword).getTag(), ranMot);
            this.notifyDataSetChanged();

        }
        // ok button
        else if (v.getId() == R.id.Layout_PickupWord_Button_ok) {

            if (list.size() >= 0) {
                if (!list.get((int) v.getTag()).isEmpty()) {
                    editor.putInt("J" + pos, (sharedPreferences.getInt("J" + pos, 0) - 1));
                    editor.apply();

                    game.getWords_List().add(list.get((int) v.getTag()));
                    list.remove((int) v.getTag());


                    this.notifyDataSetChanged();
                    if (list.isEmpty()) {
                        Intent next = new Intent(v.getContext(), EnterWord2.class);
                        next.putExtra("game", game);

                        v.getContext().startActivity(next);
                    }
                } else {
                    Toast.makeText(context, "Entrez un mot", Toast.LENGTH_SHORT).show();
                }
                this.notifyDataSetChanged();

            }

        }


    }

}



