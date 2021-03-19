package com.google.sps.servlets;

// Packages required for datastore functionality
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;

import org.apache.http.client.entity.EntityBuilder;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the comment/suggestion from the form and a timestamp
    String message = request.getParameter("comment-suggestion");
    String title = request.getParameter("title");
    long timestamp = System.currentTimeMillis();

    // Print the value so you can see it in the server logs.
    System.out.println(message);

    // Input commment with timestamp into database
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("comment");
    FullEntity commentEntity = 
        Entity.newBuilder(keyFactory.newKey())
            .set("title", title)
            .set("message", message)
            .set("time", timestamp)
            .build();
    datastore.put(commentEntity);
    
    response.sendRedirect("index.html");
  }
}