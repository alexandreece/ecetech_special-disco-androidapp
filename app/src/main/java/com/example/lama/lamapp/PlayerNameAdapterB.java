package com.example.lama.lamapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by adri-laptop on 23/02/17.
 */

public class PlayerNameAdapterB extends ArrayAdapter<Joueur> {
    private int ressourceId;
    private Context context;
    private ArrayList<Joueur> joueursB;
    private Joueur joueurB;
    private LayoutInflater inflater;



    public PlayerNameAdapterB(Context context, int ressourceId, ArrayList<Joueur> myItems ) {
        super (context, ressourceId, myItems);
        joueursB = myItems;
        Log.i(TAG, "PlayerNameAdapter: " +joueursB.toString());
        this.context = context;
        this.ressourceId = ressourceId;

        inflater = LayoutInflater.from(this.context);
    }



    public View getView(final int position, View convertView, ViewGroup parent) {
        joueurB = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);

       // joueursB.add(joueurB);
        final TextView nJoueur = (TextView) convertView.findViewById(R.id.nJoueur);
        final EditText nom = (EditText) convertView.findViewById(R.id.nom);

        nJoueur.setText("Joueur " + (position + 1));
        nom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                joueurB = joueursB.get(position);
                joueurB.setIdJoueur(position);
                Log.i(TAG, "id joueurB: "+joueurB.toString());
                joueurB.setNomJoueur(nom.getText().toString());
                Log.i(TAG, "joueurB: "+joueurB.toString());
                joueursB.set(position, joueurB);
                //joueursB.add(joueurB);
            }

        });
        return convertView;

    }

    public ArrayList<Joueur> getList() {
        Log.i(TAG, "getList: " + joueursB.toString());
        return joueursB;
    }

}
