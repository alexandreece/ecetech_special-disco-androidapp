package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Word;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Mae on 24/02/2017.
 */

public class EnterWordAdapter extends ArrayAdapter<String> implements OnClickListener {

    SharedPreferences sharedPreferences = this.getContext().getSharedPreferences("NBWord", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    SharedPreferences wordListPreference = this.getContext().getSharedPreferences("wordListPreference", MODE_PRIVATE);
    String wordlisSerialize = wordListPreference.getString("list", "");

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
        words = new ArrayList<String>();
        inflater = LayoutInflater.from(this.context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {

        //String mot = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        // convertView.setOnClickListener(this);
        EditText word = (EditText) convertView.findViewById(R.id.Layout_PickupWord_EditText_Word);
        TextView nbWord = (TextView) convertView.findViewById(R.id.EnterWord_TextView_NbWord);
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
        nbWord.setTag(position);
        if (ab == 1) {
            nbWord.setText(sharedPreferences.getInt("A" + Integer.valueOf(ok.getTag().toString()), 0) + "/" + game.getNbWords());
        } else if (ab == 2) {
            nbWord.setText(sharedPreferences.getInt("B" + Integer.valueOf(ok.getTag().toString()), 0) + "/" + game.getNbWords());
        }
        //Temporary Arraylist
        word.setHint("Entrez un mot" + position);
        if (!wordsA.get(position).isEmpty()) {
            word.setText(wordsA.get(position));
        }
        if (!wordsB.get(position).isEmpty()) {
            word.setText(wordsB.get(position));
        }

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

            Log.i("pos", "onClick: " + (int) v.findViewById(R.id.randomword).getTag());
            wordsA.set((int) v.findViewById(R.id.randomword).getTag(), ranMot);
            this.notifyDataSetChanged();

        }
        // ok button
        else if (v.getId() == R.id.EnterWord_Button_ok) {
            if (getWordListSave() == null) {
                Log.i("IF §§§", "EnterWordAdapter: ");
                words = new ArrayList<String>();
            }else{
                Log.i("ELSE §§§ ", "EnterWordAdapter: ");
                words = getWordListSave();
            }

            if (ab == 1) {
                int val = sharedPreferences.getInt("A" + Integer.valueOf(v.findViewById(R.id.EnterWord_Button_ok).getTag().toString()), 0);
                int id = Integer.valueOf(v.findViewById(R.id.EnterWord_Button_ok).getTag().toString());
                if (val < game.getNbWords()) {
                    val++;
                    game.getWords_List().add(wordsA.get(id));
                    wordsA.set(id, "");
                    Log.i("words", "onClick: " + game.getWords_List().toString());
                    setwordListSave();
                } else if (val == game.getNbWords()) {
                    Log.i("NB MOT OK ", "onClick: ");
                    v.findViewById(R.id.EnterWord_Button_ok).setVisibility(v.GONE);
                }

                editor.putInt("A" + id, val);
                editor.apply();
                this.notifyDataSetChanged();


            } else if (ab == 2) {
                int val = sharedPreferences.getInt("B" + Integer.valueOf(v.findViewById(R.id.EnterWord_Button_ok).getTag().toString()), 0);
                int id = Integer.valueOf(v.findViewById(R.id.EnterWord_Button_ok).getTag().toString());
                if (val < game.getNbWords()) {
                    val++;
                    game.getWords_List().add(wordsB.get(id));
                    wordsB.set(id, "");
                    Log.i("words", "onClick: " + game.getWords_List().toString());
                    setwordListSave();
                } else if (val == game.getNbWords()) {
                    Log.i("NB MOT OK ", "onClick: ");
                    v.findViewById(R.id.EnterWord_Button_ok).setVisibility(v.GONE);
                }

                editor.putInt("B" + id, val);
                editor.apply();
                this.notifyDataSetChanged();




            }
        }


    }

    public static Object fromJson(String jsonString, Type type) {
        return new Gson().fromJson(jsonString, type);
    }

    public static String toJson(Object jsonObject) {
        return new Gson().toJson(jsonObject);
    }

    public ArrayList<String> getWordListSave() {
        SharedPreferences wordListPreference = context.getSharedPreferences("wordListPreference", MODE_PRIVATE);
        String serialize = wordListPreference.getString("list", "");

        ArrayList<String> playersList = (ArrayList<String>) fromJson(serialize,
                new TypeToken<ArrayList<String>>() {
                }.getType());

        Log.i("PLAYERLIST", "getWordListSave: " + playersList);
        return playersList;
    }

    public void setwordListSave() {
        String serialize = toJson(words);
        SharedPreferences wordListPreference = this.getContext().getSharedPreferences("wordListPreference", MODE_PRIVATE);
        String wordlisSerialize = wordListPreference.getString("list", "");
    }


    public ArrayList<String> getList() {
        Log.i("Liste Words !!! ", "getList: "  + words.toString());
        return words;
    }




}