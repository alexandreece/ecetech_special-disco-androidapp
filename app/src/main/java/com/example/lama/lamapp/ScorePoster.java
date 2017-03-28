package com.example.lama.lamapp;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * Created by alexandre on 28/03/2017.
 */

public class ScorePoster {

    public static void post(Game game) {

        String urlServ = "http://78.192.156.30:8050/LAMA/api/index.php/";

        String dataTeamA = game.getNameTeamA() + "&" +game.getWinRoundTeamA() + "&" + game.getNbPlayers() + "&" +game.getLevel();
        String dataTeamB = game.getNameTeamB() + "&" +game.getWinRoundTeamB() + "&" + game.getNbPlayers() + "&" +game.getLevel();


        try {
            URL url = new URL(urlServ+dataTeamA);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }

        try {
            URL url = new URL(urlServ+dataTeamB);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }

    }

}
