package com.example.lama.lamapp;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by alexandre on 28/03/2017.
 */

public class ScorePoster {

    public static void post(Game game) {

        String urlServ = "http://78.192.156.30:8050/LAMA/api/index.php/";
        String dataTeamA = game.getNameTeamA() + "&" + game.getWinRoundTeamA() + "&" + game.getNbPlayers() + "&" + game.getLevel();
        String dataTeamB = game.getNameTeamB() + "&" + game.getWinRoundTeamB() + "&" + game.getNbPlayers() + "&" + game.getLevel();

        sendTo(urlServ+dataTeamA);
        sendTo(urlServ+dataTeamB);
    }

    private static void sendTo(String urlString) {

    }
}