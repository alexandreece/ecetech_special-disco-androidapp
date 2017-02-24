package com.example.lama.lamapp;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lama.lamapp.DAOs.Joueur;

public class PlayersName extends ListActivity {
    private ListView Liste;
    private PlayerNameAdapter myAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_name);

        Liste = (ListView) findViewById(android.R.id.list);
        Liste.setItemsCanFocus(true);

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();

        joueurs.add(J1);
        joueurs.add(J2);

        myAdapter = new PlayerNameAdapter(this, R.layout.item,joueurs);
        //myAdapter = new PlayerNameAdapter (this, android.R.layout.simple_list_item_1, joueurs);
        setListAdapter(myAdapter);




        /*myAdapter = new PlayerNameAdapter();
        myList.setAdapter(myAdapter);*/

    }
}
/*
    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        public ArrayList<ListItem> myItems = new ArrayList();

        public MyAdapter() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            for (int i = 0; i < 20; i++) {
                ListItem listItem = new ListItem();
                listItem.caption = "Caption" + i;
                myItems.add(listItem);
            }
            notifyDataSetChanged();
        }

        public int getCount() {
            return myItems.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item, null);
                holder.caption = (EditText) convertView
                        .findViewById(R.id.ItemCaption);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //Fill EditText with the value you have in data source
            holder.caption.setText(myItems.get(position).caption);
            holder.caption.setId(position);

            //we need to update adapter once we finish with editing
            holder.caption.setOnFocusChangeListener(new OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus){
                        final int position = v.getId();
                        final EditText Caption = (EditText) v;
                        myItems.get(position).caption = Caption.getText().toString();
                    }
                }
            });

            return convertView;
        }
    }

    class ViewHolder {
        EditText caption;
    }

    class ListItem {
        public String caption;
    }
}*/