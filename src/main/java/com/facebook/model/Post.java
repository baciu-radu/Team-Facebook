package com.facebook.model;

public class Post implements GenericEntity {

    public static final String POST_REPOSITORY_PATH = "posts.txt";
    private int id;
    private int userId;
    private String description;
    private int likes;
    private int comments;

    public Post(){
    }

    public Post(int id, int userId, String description, int likes, int comments){
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public void like() { this.likes += 1;}

    public void comm() { this.comments += 1;}


    public String toDataBaseFormat(){
        return String.format("%s;%s;%s;%s;%s", id, userId, description, likes, comments);
    }

    @Override
    public String getStoragePath() {
        return POST_REPOSITORY_PATH;
    }

    @Override
    public String toString() {
        return "Post{" +
                "description='" + description + '\'' +
                ", likes=" + likes +
                ", comments='" + comments + '\'' +
                '}';
    }
}
