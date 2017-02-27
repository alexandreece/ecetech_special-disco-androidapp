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

public class PlayerNameAdapter extends ArrayAdapter<Joueur> implements OnClickListener {
    private int ressourceId;
    private Context context;
    private ArrayList<Joueur> myItems;
    private LayoutInflater inflater;



    public PlayerNameAdapter (Context context, int ressourceId, List myItems ) {
        super (context, ressourceId, myItems);
        this.context = context;
        this.ressourceId = ressourceId;

        inflater = LayoutInflater.from(this.context);
    }



    public View getView(final int position, View convertView, ViewGroup parent) {
        final Joueur joueur = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        final TextView nJoueur = (TextView) convertView.findViewById(R.id.nJoueur);
        EditText nom = (EditText) convertView.findViewById(R.id.nom);

        nom.setText(joueur.getNomJoueur());
        nJoueur.setText("Joueur " + (position + 1));
        nJoueur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                joueur.setIdJoueur(position);
                joueur.setNomJoueur(nJoueur.getText().toString());
                myItems.add(joueur);

            }
        });
        return convertView;

    }

    public ArrayList<Joueur> getList() {
        return myItems;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        //Toast.makeText(context,getPosition(this),Toast.LENGTH_SHORT).show();

    }
}
