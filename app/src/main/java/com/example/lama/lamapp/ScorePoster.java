package com.example.lama.lamapp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by alexandre on 28/03/2017.
 */

public class ScorePoster {

    public static void post(Game game) {

        String urlServ = "http://78.192.156.30:8050/LAMA/api/index.php/";

        String dataTeamA = game.getNameTeamA() + "&" +game.getWinRoundTeamA() + "&" + game.getNbPlayers() + "&" +game.getLevel();
        String dataTeamB = game.getNameTeamB() + "&" +game.getWinRoundTeamB() + "&" + game.getNbPlayers() + "&" +game.getLevel();


        byte[] postData       = dataTeamA.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        String request        = urlServ;
        URL    url            = null;
        try {
            url = new URL( request );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn= null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        try {
            conn.setRequestMethod( "POST" );
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        try {
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write( postData );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        postData       = dataTeamB.getBytes( StandardCharsets.UTF_8 );
        postDataLength = postData.length;
        URL    urlB            = null;
        try {
            urlB = new URL( request );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            conn= (HttpURLConnection) urlB.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        try {
            conn.setRequestMethod( "POST" );
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setUseCaches( false );
        try {
            try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
                wr.write( postData );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
