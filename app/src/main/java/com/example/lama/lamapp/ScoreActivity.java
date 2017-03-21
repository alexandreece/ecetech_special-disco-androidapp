package com.example.lama.lamapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreActivity extends AppCompatActivity {

    private static final String API_SERV_URL = "http://172.16.229.131/api/index.php/teams/";

    private ProgressDialog pDialog;
    private ListView bestScoresLV;
    private ListView worstScoresLV;

    private static String bestURL = API_SERV_URL + "Best";
    private static String worstURL = API_SERV_URL + "worst";

    ArrayList<HashMap<String, String>> bestScoresList;
    ArrayList<HashMap<String, String>> worstScoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        bestScoresList = new ArrayList<>();
        worstScoresList = new ArrayList<>();

        bestScoresLV = (ListView) findViewById(R.id.bestScores);
        worstScoresLV = (ListView) findViewById(R.id.worstScores);

        new GetBestScores().execute();
        new GetWorstScores().execute();
    }

    private class GetBestScores extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ScoreActivity.this);
            pDialog.setMessage("Récupération des meilleurs scores...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(bestURL);

            Log.i("json recu",jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray scores = new JSONArray(jsonStr);

                    for (int i=0; i<scores.length(); i++){
                        JSONObject s = scores.getJSONObject(i);

                        String nomEquipe = s.getString("NomTeam");
                        String points = s.getString("Score");
                        String date = s.getString("Date");
                        String nbJoueurs = s.getString("NbPlayer");
                        String niveau = s.getString("Niveau");

                        HashMap<String,String> score = new HashMap<>();

                        score.put("nomEquipe",nomEquipe);
                        score.put("points",points);
                        score.put("date",date);
                        score.put("nbJoueurs",nbJoueurs);
                        score.put("niveau",niveau);

                        bestScoresList.add(score);

                    }
                }
                catch (final JSONException e) {
                    Log.i("Json parsing error", e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            }
            else {
                Log.i("Error", "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    ScoreActivity.this, bestScoresList,
                    R.layout.score_item, new String[]{"points","nomEquipe","niveau"},
                    new int[]{R.id.score,R.id.equipe,R.id.niveau}
            );
            bestScoresLV.setAdapter(adapter);
        }
    }

    private class GetWorstScores extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ScoreActivity.this);
            pDialog.setMessage("Récupération des pires scores...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = sh.makeServiceCall(worstURL);

            Log.i("json recu",jsonStr);

            if (jsonStr != null) {
                try {
                    JSONArray scores = new JSONArray(jsonStr);

                    for (int i=0; i<scores.length(); i++){
                        JSONObject s = scores.getJSONObject(i);

                        String nomEquipe = s.getString("NomTeam");
                        String points = s.getString("Score");
                        String date = s.getString("Date");
                        String nbJoueurs = s.getString("NbPlayer");
                        String niveau = s.getString("Niveau");

                        HashMap<String,String> score = new HashMap<>();

                        score.put("nomEquipe",nomEquipe);
                        score.put("points",points);
                        score.put("date",date);
                        score.put("nbJoueurs",nbJoueurs);
                        score.put("niveau",niveau);

                        worstScoresList.add(score);

                    }
                }
                catch (final JSONException e) {
                    Log.i("Json parsing error", e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            }
            else {
                Log.i("Error", "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(
                    ScoreActivity.this, worstScoresList,
                    R.layout.score_item, new String[]{"points","nomEquipe","niveau"},
                    new int[]{R.id.score,R.id.equipe,R.id.niveau}
            );
            worstScoresLV.setAdapter(adapter);
        }
    }
}
