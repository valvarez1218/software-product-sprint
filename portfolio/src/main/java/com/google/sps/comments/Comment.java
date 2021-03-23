package com.google.sps.comments;

/** A comment by user */
public final class Comment {

  private final long id;
  private final String title;
  private final String message;
  private final long timestamp;

  public Comment(long id, String title, String message, long timestamp) {
    this.id = id;
    this.title = title;
    this.message = message;
    this.timestamp = timestamp;
  }
}