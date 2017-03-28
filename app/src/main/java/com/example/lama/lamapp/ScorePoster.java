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


    }

}
