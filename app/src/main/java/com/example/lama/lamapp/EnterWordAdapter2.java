package com.example.lama.lamapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Mae on 21/03/2017.
 */

public class EnterWordAdapter2 extends BaseAdapter implements View.OnClickListener {

    private ArrayList<Object> list;
    private LayoutInflater inflater;
    public Game game;
    private Context context;

    private static final int ROW = 0;
    private static final int HEADER = 1;

    public EnterWordAdapter2(Context context, ArrayList<Object> list, Game game) {
        this.list = list;
        this.game = game;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public Object getItemList(int position) {
        return list.get(position);
    }

    public int getViewTypeCount() {
        // ROW ET HEADER
        return 2;
    }

    public int getItemViewType(int position) {
        if (getItemList(position) instanceof Joueur) {
            return ROW;
        }

        return HEADER;
    }

    public boolean isEnabled(int position) {
        return (getItemViewType(position) == ROW);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences("NBWord", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case ROW:
                    convertView = inflater.inflate(R.layout.layout_enterword_content, parent, false);
                    break;
                case HEADER:
                    convertView = inflater.inflate(R.layout.layout_enterword_section, parent, false);
                    break;
            }
        }

        switch (type) {
            case ROW:
                Joueur player = (Joueur) getItemList(position);
                Button joueur = (Button) convertView.findViewById(R.id.Layout_enterword_content_button_joueur);

                joueur.setText(player.getNomJoueur()+ " : " + (game.getNbWords() - sharedPreferences.getInt("J" + position, 0)) + "/" + game.getNbWords());
                joueur.setOnClickListener(this);
               // joueur.setText(Integer.toString(position) + " : " + (game.getNbWords() - sharedPreferences.getInt("J" + position, 0)) + "/" + game.getNbWords());
                joueur.setTag(position);
                if (sharedPreferences.getInt("J" + position, 0) == 0) {
                    joueur.setEnabled(false);
                }
                break;
            case HEADER:
                TextView title = (TextView) convertView.findViewById(R.id.Layout_enterword_section_textview_title);
                String titleString = (String) getItemList(position);
                //title.setText(titleString);
                title.setText(titleString);
                break;
        }

        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Layout_enterword_content_button_joueur) {
            Intent next = new Intent(v.getContext(), PickupWord.class);

            next.putExtra("pos", (int) v.getTag());
            next.putExtra("game", game);

            v.getContext().startActivity(next);
        }
        this.notifyDataSetChanged();

    }
}
