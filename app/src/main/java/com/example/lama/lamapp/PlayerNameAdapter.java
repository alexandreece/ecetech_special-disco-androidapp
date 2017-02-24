package com.example.lama.lamapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import com.example.lama.lamapp.DAOs.Joueur;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adri-laptop on 23/02/17.
 */

public class PlayerNameAdapter extends ArrayAdapter<Joueur> {
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



    public View getView(int position, View convertView, ViewGroup parent) {
        Joueur joueur = getItem(position);
        convertView = inflater.inflate(this.ressourceId, null);
        EditText nom = (EditText) convertView.findViewById(R.id.nom);
        nom.setText(joueur.getNomJoueur());

        return convertView;

    }
}
