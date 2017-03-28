package com.example.lama.lamapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by alexandre on 28/03/2017.
 */

public class ScorePoster {

    public static void  Post(Game game)  throws UnsupportedEncodingException {

        // Create data variable for sent values to server

        String dataTeamA = URLEncoder.encode(game.getNameTeamA(), "UTF-8");

        dataTeamA += "&" + URLEncoder.encode(""+game.getWinRoundTeamA(), "UTF-8");

        dataTeamA += "&" + URLEncoder.encode(""+game.getNbPlayers(), "UTF-8");

        dataTeamA += "&" + URLEncoder.encode(""+game.getLevel(), "UTF-8");


        String dataTeamB = URLEncoder.encode(game.getNameTeamB(), "UTF-8");

        dataTeamB += "&" + URLEncoder.encode(""+game.getWinRoundTeamB(), "UTF-8");

        dataTeamB += "&" + URLEncoder.encode(""+game.getNbPlayers(), "UTF-8");

        dataTeamB += "&" + URLEncoder.encode(""+game.getLevel(), "UTF-8");


        String text = "";
        BufferedReader reader = null;

        // Send data
        try {

            // Defined URL  where to send data
            URL url = new URL("http://78.192.156.30:8050/LAMA/api/index.php/");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(dataTeamA);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
            }
        }

        try {

            // Defined URL  where to send data
            URL url = new URL("http://78.192.156.30:8050/LAMA/api/index.php/");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(dataTeamB);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        } catch (Exception ex) {

        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
            }
        }


    }
}
