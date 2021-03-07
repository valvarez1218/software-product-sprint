package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the comment/suggestion from the form.
    String textValue = request.getParameter("comment-suggestion");

    // Print the value so you can see it in the server logs.
    System.out.println(textValue);

    // Say thank you to the user for their contribution
    response.setContentType("text/html;");
    
    // Not currently implemented but would like to acknowledge user
    //  for submitting a comment
    // response.getWriter().println("Thank you for your input!");
    
    
    response.sendRedirect("index.html");
  }
}