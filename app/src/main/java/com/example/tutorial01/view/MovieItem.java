package com.example.tutorial01.view;

public class MovieItem {
    private int iconId;
    private String title;
    private String content;

    public MovieItem(int iconId, String title, String content) {
        this.iconId = iconId;
        this.title = title;
        this.content = content;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
