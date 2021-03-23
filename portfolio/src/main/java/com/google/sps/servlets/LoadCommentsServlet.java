package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.comments.Comment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Lists the comments from database
@WebServlet("/view-comments")
public class LoadCommentsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("comment").setOrderBy(OrderBy.desc("time")).build();
        QueryResults<Entity> results = datastore.run(query);

        List<Comment> comments = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();
            
            String title = entity.getString("title");
            String message = entity.getString("message");
            long id = entity.getKey().getId();
            long timestamp = entity.getLong("time");


            Comment comment = new Comment(id, title, message, timestamp);
            comments.add(comment);
        }

        Gson gson = new Gson();

        response.setContentType("application/json;");
        response.getWriter().println(gson.toJson(comments));
    }


}