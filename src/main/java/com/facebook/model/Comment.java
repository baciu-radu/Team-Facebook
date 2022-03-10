package com.facebook.model;

public class Comment implements GenericEntity {
    public static final String COMM_REPOSITORY_PATH = "comments.txt";
    private int id;
    private int postId;
    private String comment;

    public Comment(int postId, String comment) {
        this.postId = postId;
        this.comment = comment;
    }
    public Comment(int id, int postId, String comment) {
        this.id = id;
        this.postId = postId;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toDataBaseFormat() {
        return String.format("%s;%s;%s", id, postId, comment);
    }

    @Override
    public String getStoragePath() {
        return COMM_REPOSITORY_PATH;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" + comment + '}';
    }
}
