package com.example.lama.lamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lama.lamapp.DAOs.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectRandomWord extends AppCompatActivity {

    List<Word> words;
    Random alea = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_random_word);

        DatabaseHandler db = new DatabaseHandler(this);
        words = db.getWordsList();
        db.close();

    }

    public void fauneTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory()=="Faune")
            {
                liste.add(mot.getWord());
                Log.i("Faune",mot.getWord());
            }
        }
        //int index = alea.nextInt(liste.size());
        //Log.i("Taille liste", ""+index);
        //String ranMot = liste.get(index);
        String ranMot = "Tigre";
        Toast.makeText(getApplicationContext(),ranMot,Toast.LENGTH_SHORT).show();
    }

    public void fictifTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory()=="Fictif")
            {
                liste.add(mot.getWord());
                Log.i("Fictif",mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        Toast.makeText(getApplicationContext(),ranMot,Toast.LENGTH_SHORT).show();
    }

    public void floreTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory()=="Flore")
            {
                liste.add(mot.getWord());
                Log.i("Flore",mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        Toast.makeText(getApplicationContext(),ranMot,Toast.LENGTH_SHORT).show();
    }

    public void objetTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory()=="Objet")
            {
                liste.add(mot.getWord());
                Log.i("Objet",mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        Toast.makeText(getApplicationContext(),ranMot,Toast.LENGTH_SHORT).show();
    }

    public void peopleTouched(View view){
        List<String> liste = new ArrayList<String>();
        for (Word mot : words){
            if (mot.getCategory()=="People")
            {
                liste.add(mot.getWord());
                Log.i("People",mot.getWord());
            }
        }
        String ranMot = liste.get(alea.nextInt(liste.size()));
        Toast.makeText(getApplicationContext(),ranMot,Toast.LENGTH_SHORT).show();
    }

}
