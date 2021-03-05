package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/artist")
public class RandomArtist extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
      // Declare and initialize ArrayList of favorite music artists
      ArrayList<String> favArtists = new ArrayList<String>() {
          {
              add("Panic! At The Disco");
              add("The Weeknd");
              add("Anderson .Paak");
              add("Hozier");
              add("Daniel Caeasr");
              add("Jacon Collier");
              add("The Strokes");
              add("Mana");
              add("Lola Club");
              add("Los Cafres");
              add("Los Fabulosos Cadillacs");
            }
        };
        
        // Get random artists from lists of artists
        Random rand = new Random();
        String selected_artist = favArtists.get(rand.nextInt(favArtists.size()));
        
        // Convert to json format ready to be sent
        String json = "{ \"selectedArtist\" : \"" + selected_artist + "\" }";
        
        response.setContentType("application/json;");
        response.getWriter().println(json);
  }

}
