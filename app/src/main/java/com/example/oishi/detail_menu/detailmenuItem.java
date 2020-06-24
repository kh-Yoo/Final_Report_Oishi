package com.example.oishi.detail_menu;

public class detailmenuItem {
    private String rating;
    private String content;
    private String time;
    private String id;

    public detailmenuItem(String id, String  rating, String time) {
        this.id = id;
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
