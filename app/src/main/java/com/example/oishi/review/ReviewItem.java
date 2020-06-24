package com.example.oishi.review;

public class ReviewItem {
    private String rating;
    private String content;
    private String time;
    private String id;

    public ReviewItem(String id, String content, String  rating, String time) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.time = time;
    }

    public String getRating() {
        return this.rating;
    }

    public String getContent() {
        return this.content;
    }

    public String getTime() {
        return this.time;
    }

    public String getId() {
        return this.id;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }
}
