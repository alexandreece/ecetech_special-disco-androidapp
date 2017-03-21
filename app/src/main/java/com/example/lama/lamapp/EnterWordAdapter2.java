package com.example.lama.lamapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.lama.lamapp.DAOs.Joueur;

import java.util.ArrayList;

/**
 * Created by Mae on 21/03/2017.
 */

public class EnterWordAdapter2 extends BaseAdapter {
    private ArrayList<Object> list;
    private LayoutInflater inflater;
    private static final int ROW = 0;
    private static final int HEADER = 1;

    public EnterWordAdapter2(Context context, ArrayList<Object> list) {
        this.list = list;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                joueur.setText(player.getNomJoueur());
                break;
            case HEADER:
                TextView title = (TextView)convertView.findViewById(R.id.Layout_enterword_section_textview_title);
                String titleString = (String)getItemList(position);
                title.setText(titleString);
                break;
        }

        return convertView;
    }

}
