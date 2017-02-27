package com.example.lama.lamapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Joueur;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by adri-laptop on 23/02/17.
 */

public class PlayerNameAdapter extends ArrayAdapter<Joueur> {
    private int ressourceId;
    private Context context;
    private ArrayList<Joueur> joueurs;
    private Joueur joueur;
    private LayoutInflater inflater;



    public PlayerNameAdapter (Context context, int ressourceId, ArrayList<Joueur> myItems ) {
        super (context, ressourceId, myItems);
        joueurs = myItems;
        Log.i(TAG, "PlayerNameAdapter: " +joueurs.toString());
        this.context = context;
        this.ressourceId = ressourceId;

        inflater = LayoutInflater.from(this.context);
    }



    public View getView(final int position, View convertView, ViewGroup parent) {
        joueur = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);

       // joueurs.add(joueur);
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
                joueur = joueurs.get(position);
                joueur.setIdJoueur(position);
                Log.i(TAG, "id joueur: "+joueur.toString());
                joueur.setNomJoueur(nom.getText().toString());
                Log.i(TAG, "joueur: "+joueur.toString());
                joueurs.set(position, joueur);
                //joueurs.add(joueur);
            }

        });
        return convertView;

    }

    public ArrayList<Joueur> getList() {
        Log.i(TAG, "getList: " + joueurs.toString());
        return joueurs;
    }

}
